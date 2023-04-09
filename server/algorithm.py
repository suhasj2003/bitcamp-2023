import requests
import json

diffusion_url = "https://stablediffusionapi.com/api/v3/text2img"
diffusion_json = {
 "key": "2MG9G6Tt9a8Q1OL0O1UkwX2KApsBkxVIBA6iyVugtu5LFVeN1pnWU3j1EPsW",
 "prompt": "A game of chess",
 "negative_prompt": "((out of frame)), anime",
 "width": "512",
 "height": "512",
 "samples": "1",
 "num_inference_steps": "20",
 "seed": "null",
 "guidance_scale": 7.5,
"safety_checker":"yes",
 "webhook": "null",
 "track_id": "null"
}

# Returns URL of the picture generated
def stable_diff():
    response = requests.post(diffusion_url, diffusion_json).json()
    return response['output']


def algorithm(info):
    pass