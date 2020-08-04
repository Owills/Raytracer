
public class Ray{
    private Point position;
    private Vector direction;
    private double time;
    public Ray(Point p, Vector v, double t){
       position = p;
       direction = v.normalize();
       time = t;
    }
    public Point evaluate(double dist){
        return position.add(direction.scale(dist));
    }    
    public Point getPosition(){
        return position;
    }    
    public Vector getDirection(){
        return direction;
    }  
    public double getTime(){
        return time;
    }  
}
