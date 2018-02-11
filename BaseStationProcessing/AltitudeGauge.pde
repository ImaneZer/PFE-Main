
void AltitudeGauge(){
  translate(width/2, height/1.5); 
  stroke(128,128,128) ;
  ellipse(0, 0, width/4, height/2) ;
  stroke(0,255,0) ;
  guage(height/4, alt) ;
}
void guage(float r, float angle) {
  // Conver from Degree -> Rad
  angle = -angle*(PI/180) ;
    // Convert Polar -> Cartesian
  float x = r * cos(angle);
  float y = r * sin(angle);

  arrow(0,0, (int)x, (int)y) ;
}
void arrow(int x1, int y1, int x2, int y2) {
  line(x1, y1, x2, y2);
  pushMatrix();
  translate(x2, y2);
  float a = atan2(x1-x2, y2-y1);
  rotate(a);
  line(0, 0, -10, -10);
  line(0, 0, 10, -10);
  popMatrix();
} 