public class Main {
    public static void main(String[] args){
        /*
        Windows windowH = new Windows("Ligne d'horizon");
        Windows windowA = new Windows("Altitude");

        BaseStation base = new BaseStation();

        windowH.setImageHorizon();

        windowH.repaintHorizon(base.setHorizon());

        windowA.setTextAltitude(String.valueOf(base.setAltitude()));
        */


        //===================Donnée du drone===================
        double droneDestination = 50;
        double droneAngleHorizontal = -45 ;
        double droneAngleVertical = -10;
        double droneVitesse = 10; // pas a définir
        double droneAtltitude = 50;

        //===================Ordre à envoyer au drone===================
        double orderDestination = 100;
        double orderVitesse = 10;
        double orderAlttitude = 20;

        //===================Set donnée base récolté du drone===================
        BaseStation baseStation = new BaseStation();
        baseStation.setDroneDestination(droneDestination);
        baseStation.setDroneAngleHorizontal(droneAngleHorizontal);
        baseStation.setDroneAngleVertical(droneAngleVertical);
        baseStation.setDroneAtltitude(droneAtltitude);
        baseStation.setDroneVitesse(droneVitesse);
        //===================Set donnée des ordres===================
        baseStation.setOrderAtltitude(orderAlttitude);
        baseStation.setOrderDestination(orderDestination);
        baseStation.setOrderVitesse(orderVitesse);


        while(!baseStation.sendOrder(droneAtltitude, orderAlttitude, "ALT")
                && !baseStation.sendOrder(droneDestination, orderDestination, "DST")){
            droneAtltitude = baseStation.getDroneAtltitude();
            droneDestination = baseStation.getDroneDestination();
        }

    }
}
