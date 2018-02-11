
void parseYPR(String ypr){
    String[] data = ypr.split(":");
    ypr = data[1];
    String[] yprInt = ypr.split(",");
    yaw = Float.parseFloat(yprInt[0]);
    pitch = Float.parseFloat(yprInt[1]);
    roll = Float.parseFloat(yprInt[2]);
}
void parseAlt(String altString){
    String[] data = altString.split(":");
    alt = Float.parseFloat(data[1]);
}
void parseCoord(String coord){
    String[] data = coord.split(":");
    coord = data[1];
    String[] yprInt = coord.split(",");
    x = Float.parseFloat(yprInt[0]);
    y = Float.parseFloat(yprInt[1]);
}