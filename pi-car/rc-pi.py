from flask import Flask, request
from flask_restful import reqparse
from flask import jsonify
from serial import Serial

ser = Serial('/dev/ttyACM0', 9600)
app = Flask(__name__)
parser = reqparse.RequestParser()

@app.route('/remote')
def my_route():
  instruction = request.args.get('instruction', default = 0, type = int)
  ser.write(str(instruction))
  response = {'instruction': instruction}
  return jsonify(response)

if __name__ == '__main__':
     app.run(host='192.168.43.137', port=5002)

