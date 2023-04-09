import requests
import json
import base64

def algorithm(info):
    pass

def get_request2():
    engine_id = "stable-diffusion-v1-5"
    response = requests.post(
        f"https://api.stability.ai/v1/generation/{engine_id}/text-to-image",
        headers={
        "Content-Type": "application/json",
        "Accept": "application/json",
        "Authorization": f"Bearer sk-pLwzLsBZPI0Q8wfnFXpQSyiyXLxzkTdZofeLFa5eCzuuBRuq"
        },
        json={
        "text_prompts": [
            {
                "text": "hiking"
            }
        ],
        "cfg_scale": 7,
        "clip_guidance_preset": "FAST_BLUE",
        "height": 512,
        "width": 512,
        "samples": 1,
        "steps": 10,
        },
    )

    data = response.json()
    picture = data["artifacts"][0]['base64']
    for i, image in enumerate(data["artifacts"]):
        with open("out.png", "wb") as f:
            f.write(base64.b64decode(image["base64"]))
    

get_request2()