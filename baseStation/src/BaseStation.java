public class BaseStation {
    //===================Donnée du drone===================
    private double droneDestination;
    private double droneAngleHorizontal;
    private double droneAngleVertical;
    private double droneVitesse;
    private double droneAtltitude;

    //===================Ordre à envoyer au drone===================
    private double orderDestination;
    private double orderVitesse;
    private double orderAlttitude;

    //===================Get Donnée du drone===================
    public double getDroneDestination() {return droneDestination;}
    public double getDroneVitesse() {return droneVitesse;}
    public double getDroneAtltitude() {return droneAtltitude;}
    public double getDroneAngleVertical() {return droneAngleVertical;}
    public double getDroneAngleHorizontal() {return droneAngleHorizontal;}

    //===================Get ordre du drone===================
    public double getOrderAlttitude() {return orderAlttitude;}
    public double getOrderDestination() {return orderDestination;}
    public double getOrderVitesse() {return orderVitesse;}

    //===================Set Donnée du drone===================
    public void setDroneAngleHorizontal(double droneAngleHorizontal) {this.droneAngleHorizontal = droneAngleHorizontal;}
    public void setDroneAngleVertical(double droneAngleVertical) {this.droneAngleVertical = droneAngleVertical;}
    public void setDroneAtltitude(double droneAtltitude) {this.droneAtltitude = droneAtltitude;}
    public void setDroneDestination(double droneDestination) {this.droneDestination = droneDestination;}
    public void setDroneVitesse(double droneVitesse) {this.droneVitesse = droneVitesse;}

    //===================Set ordre à envoyer au du drone===================
    public void setOrderAtltitude(double orderAlttitude) {this.orderAlttitude = orderAlttitude;}
    public void setOrderDestination(double orderDestination) {this.orderDestination = orderDestination;}
    public void setOrderVitesse(double orderVitesse) {this.orderVitesse = orderVitesse;}

    //===================Calculer des ordres à envoyer===================
    public void sendDestination(){
        //TODO
    }
    public Boolean sendOrder(double droneData, double orderData, String orderType){
        Boolean drone = false;
        String order;
        if(droneData < orderData){
            order = "UP";
        }
        else if(droneData > orderData){
            order = "DOWN";
        }
        else{
            order = "GOOD";
            drone = true;
        }

        switch (order){
            case "UP":
                if(orderType.equals("ALT")) {
                    //SEND order up altitude
                    setDroneAtltitude(droneAtltitude--);
                }
                if(orderType.equals("DST")) {
                    //SEND order up altitude
                    setDroneDestination(droneDestination + droneVitesse);
                }
                break;
            case "DOWN":
                if(orderType.equals("ALT")) {
                    setDroneAtltitude(droneAtltitude++);
                    //SEND order up altitude
                }
                if(orderType.equals("DST")) {
                    //SEND order up altitude
                    setDroneDestination(droneDestination + droneVitesse);
                }
                break;
            case "GOOD":
                if(orderType.equals("ALT")) {
                    System.out.println(" altitude atteinte");
                }
                if(orderType.equals("DST")) {
                    setDroneVitesse(0);
                    System.out.println("destination atteinte");
                }
                break;
        }
        return drone;
    }
}
