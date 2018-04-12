#include <AFMotor.h>

int incomingByte = 0;
AF_DCMotor motor1(1);
AF_DCMotor motor2(2);

void setup() {
  Serial.begin(9600);
 
  motor1.run(RELEASE);
  motor2.run(RELEASE);
}

void loop() {
  if (Serial.available() > 0) {
    incomingByte = Serial.read();
    char myChar = incomingByte;

    switch (myChar) {
      case '0': // stop
        motor1.setSpeed(0);
        motor2.setSpeed(0);
        break;
      case '1': // clockwise
        motor1.run(FORWARD);
        motor2.run(BACKWARD);
        break;
      case '2': // anti-clockwise
        motor1.run(BACKWARD);
        motor2.run(FORWARD);
        break;
      case '3': // forward
        motor1.run(FORWARD);
        motor2.run(FORWARD);
        break;
      case '4': // backward
        motor1.run(BACKWARD);
        motor2.run(BACKWARD);
        break;
      case '5': // speed 1
        motor1.setSpeed(51);
        motor2.setSpeed(51);
        break;
      case '6': // speed 2
        motor1.setSpeed(102);
        motor2.setSpeed(102);
        break;
      case '7': // speed 3
        motor1.setSpeed(153);
        motor2.setSpeed(153);
        break;
      case '8': // speed 4
        motor1.setSpeed(204);
        motor2.setSpeed(204);
        break;
      case '9': // speed 5
        motor1.setSpeed(255);
        motor2.setSpeed(255);
        break;
    }
  }
}
