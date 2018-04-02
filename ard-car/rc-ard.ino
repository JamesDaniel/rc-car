#include <AFMotor.h>

int incomingByte = 0;
AF_DCMotor motor1(1);
AF_DCMotor motor2(2);
AF_DCMotor motor3(3);
AF_DCMotor motor4(4);

void setup() {
  Serial.begin(9600);
 
  motor1.run(RELEASE);
  motor2.run(RELEASE);
  motor3.run(RELEASE);
  motor4.run(RELEASE);
}

void loop() {
  if (Serial.available() > 0) {
    incomingByte = Serial.read();
    char myChar = incomingByte;

    switch (myChar) {
      case '0': // stop
        motor1.setSpeed(0);
        motor2.setSpeed(0);
        motor3.setSpeed(0);
        motor4.setSpeed(0);
        break;
      case '1': // forward
        motor1.setSpeed(255);
        motor2.setSpeed(255);
        motor3.setSpeed(255);
        motor4.setSpeed(255);
        motor1.run(FORWARD);
        motor2.run(FORWARD);
        motor3.run(FORWARD);
        motor4.run(FORWARD);
        break;
      case '2': // backward
        motor1.setSpeed(255);
        motor2.setSpeed(255);
        motor3.setSpeed(255);
        motor4.setSpeed(255);
        motor1.run(BACKWARD);
        motor2.run(BACKWARD);
        motor3.run(BACKWARD);
        motor4.run(BACKWARD);
        break;
      case '3': // left forward
        motor1.setSpeed(255);
        motor2.setSpeed(200);
        motor3.setSpeed(200);
        motor4.setSpeed(255);
        motor1.run(FORWARD);
        motor2.run(FORWARD);
        motor3.run(FORWARD);
        motor4.run(FORWARD);
        break;
      case '4': // right forward
        motor1.setSpeed(200);
        motor2.setSpeed(255);
        motor3.setSpeed(255);
        motor4.setSpeed(200);
        motor1.run(FORWARD);
        motor2.run(FORWARD);
        motor3.run(FORWARD);
        motor4.run(FORWARD);
        break;
      case '5': // left backward
        motor1.setSpeed(200);
        motor2.setSpeed(255);
        motor3.setSpeed(255);
        motor4.setSpeed(200);
        motor1.run(BACKWARD);
        motor2.run(BACKWARD);
        motor3.run(BACKWARD);
        motor4.run(BACKWARD);
        break;
      case '6': // right backward
        motor1.setSpeed(200);
        motor2.setSpeed(255);
        motor3.setSpeed(255);
        motor4.setSpeed(200);
        motor1.run(BACKWARD);
        motor2.run(BACKWARD);
        motor3.run(BACKWARD);
        motor4.run(BACKWARD);
        break;
    }
  }
}
