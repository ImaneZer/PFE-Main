void test(){
  testHorizon();
  parseYPRTest();
  parseAltTest();
  parseCoordTest();
}

void testHorizon(){
  v2= new PVector();
  v1= new PVector(width/2, height/2);
  v2.x=mouseX;
  v2.y=mouseY;
  Bank = PVector.angleBetween(v1, v2);
  pitch=mouseY-height/2;
}
void parseYPRTest(){
    String ypr = "ypr:50,100,30";
    parseYPR(ypr);
    Boolean test = (yaw == 50) && (pitch == 100) && (roll == 30);
    println("Test convertion ypr   =======>        " + (test ? "Réussi":"Raté"));
}
void parseAltTest(){
    String altString = "alt:5000";
     parseAlt(altString);
    Boolean test = (alt == 5000);
    println("Test convertion alt   =======>        " + (test ? "Réussi":"Raté"));
}
void parseCoordTest(){
    String alt = "coord:50,100";
     parseCoord(alt);
    Boolean test = ( x == 50 &&  y == 100);
    println("Test convertion x/y   =======>        " + (test ? "Réussi":"Raté"));
}