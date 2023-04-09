package com.bitcamp2023.hobbyrecapi.user;

import java.util.logging.Logger;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import reactor.core.publisher.Mono;

@SuppressWarnings({"unused", "unchecked"})

@RestController
@RequestMapping("/api/v1")
public class UserController {
    

    private final UserService userService;

    @Value("${CLIENT_URL}")
    private static String CLIENT_URL;
    @Value("${SERVER_URL}")
    private static String SERVER_URL;

    private static Logger log 
        = Logger.getLogger(
            UserController.class.getName());

    private static final WebClient HTTP_TO_CLIENT = WebClient.builder()
        .baseUrl(CLIENT_URL)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();

    public static final WebClient HTTP_TO_SERVER = WebClient.builder()
        .baseUrl("http://localhost:5050")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public User getTest() {
        return userService.createNewUser(null, null);
    }


    /**
     * postNewUser creates a new user when a user uses the app for the first time. 
     * Handles the http request and receive a JSON body containing both UserID (Double)
     * and tags (Map[String, Double]).
     * 
     * @param body
     * @return ResponseSpec
     *
     */ 
    @PostMapping("/new-user")
    public Mono<String> postNewUser(@RequestBody Map<String, Object> body) {

        log.info("Creating New User!");

        Long userID = ((Number) body.get("userID")).longValue();
        Object tagsObject = body.get("tags");
        User newUser = null;

        if (tagsObject instanceof Map) {
            Map<Object, Object> tagsMap = (Map<Object, Object>) tagsObject;
            newUser = userService.createNewUser(userID, tagsMap);
        }

        return HTTP_TO_SERVER.post()
            .uri("/create/new-user")
            .body(Mono.just(userService.userToMap(newUser)), 
                User.class)
            .retrieve()
            .bodyToMono(String.class);
    }
}