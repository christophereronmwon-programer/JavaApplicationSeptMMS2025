
package classWork1;


public class TestingVehicle {
    public static void main(String[] args){
        Vehicle[] vehicleObjects = {
        new Car(),
        new Bike(),
        new Bus(),
        };
        
        for(Vehicle vehicle : vehicleObjects){
            vehicle.move();
        }
    }
}
