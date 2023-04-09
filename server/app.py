from flask import Flask
import json
import requests
from algorithm import algorithm
URL = ''

app = Flask(__name__)

@app.route("/")
def process_request():
    info = get_request()
    return_val = algorithm(info)
    post = requests.post(url = URL, json = return_val)
    return "<p>STATUS: 200</p>"

if __name__ == '__main__':
    app.run()

def get_request():
    params = dict()
    resp = requests.get(url = URL, params = params).json()
    data = json.loads(resp)
    return data
