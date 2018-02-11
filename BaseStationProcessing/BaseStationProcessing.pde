float yaw;
float pitch;
float roll;
float alt;
float x;
float y;
void setup(){
  size(1600, 800);
  background(0);
  rectMode(CENTER);
  smooth();
  test();
}
void draw(){
  pitch = 150;
  LineHorizon();
  AltitudeGauge();
}