
package EmergencyResponse;

public class EmergencyTest {

    public static void main(String[] args) {

        Emergency emergency = new Emergency(
                "John Doe",
                "08031234567",
                "15 Aba Road, Port Harcourt",
                "Fire",
                "A building is on fire.",
                "Fire Service",
                "Response Team Dispatched",
                "27/07/2026",
                "10:30 AM"
        );

        emergency.displayEmergency();
    }

}
