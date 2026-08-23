
package Abstraction;


public class SmartPhone implements Callable,Camera,Movie,Music,Game,Wifi{
    
    @Override
    public void makeCall(){
        System.out.println("John is calling.......");
    }
    
    @Override
    public void playMusic(){
        System.out.println("Music is playing");
    }
    
    @Override
    public void playGame(){
        System.out.println("John is gaming.......");
    }
    
    @Override
    public void takePicture(){
        System.out.println("Picture has been taken");
    }
    
    @Override
    public void playMovie(){
        System.out.println("Movie is playing");
    }
    
    @Override
    public void connectToWifi(){
        System.out.println("Connecting to wifi......");
    }
}
