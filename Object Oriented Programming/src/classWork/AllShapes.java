
package classWork;


public class AllShapes {
    public static void main(String[] args){
        Shape[] Shapes ={
            new Circle(),
            new Rectangle(),
            new Triangle(),
        };
        
        for(Shape shape : Shapes){
            shape.draw();
        }    
    }
}
