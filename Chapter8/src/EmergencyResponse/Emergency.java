
package EmergencyResponse;


public class Emergency {

    private String callerName;
    private String phoneNumber;
    private String address;
    private String emergencyType;
    private String emergencyDescription;
    private String responseUnit;
    private String status;
    private String dateReported;
    private String timeReported;

    public Emergency(String callerName,
                     String phoneNumber,
                     String address,
                     String emergencyType,
                     String emergencyDescription,
                     String responseUnit,
                     String status,
                     String dateReported,
                     String timeReported) {

        this.callerName = callerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.emergencyType = emergencyType;
        this.emergencyDescription = emergencyDescription;
        this.responseUnit = responseUnit;
        this.status = status;
        this.dateReported = dateReported;
        this.timeReported = timeReported;
    }

    public void displayEmergency() {

        System.out.println("===== EMERGENCY REPORT =====");
        System.out.println("Caller: " + callerName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Description: " + emergencyDescription);
        System.out.println("Response Unit: " + responseUnit);
        System.out.println("Status: " + status);
        System.out.println("Date Reported: " + dateReported);
        System.out.println("Time Reported: " + timeReported);
    }
}
