
public class Ray{
    private Point position;
    private Vector direction;
    public Ray(Point p, Vector v){
       position = p;
       direction = v.normalize();
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
}
