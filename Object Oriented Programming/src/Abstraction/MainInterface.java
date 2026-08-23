
package Abstraction;


public class MainInterface {
    public static void main(String[] args){
        SmartPhone smartPhone = new SmartPhone();
        
        Nokia3310 nokia = new Nokia3310();
        
        System.out.print("\nSmartPhone Interface\n");
        smartPhone.makeCall();
        smartPhone.playGame();
        smartPhone.playMusic();
        smartPhone.takePicture();
        smartPhone.connectToWifi();
        smartPhone.playMovie();
        
        System.out.print("\nNokia3310 interface\n");
        nokia.playMusic();
        nokia.playGame();
        nokia.makeCall();
    }
}
