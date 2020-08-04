/**
 * Represents a sphere in 3D space.
 * 
 * @author Ben Farrar
 * @version 2019.05.22
 */
public class Sphere extends Surface {
    private Point center;
    private double r;
    private Material mat;
    private Vector movement;
    
    //Minimum distance for a valid collision. This prevents the sphere's rays from colliding with itself.
    public static double EPSILON = 1e-6;

    public Sphere(Point position, double radius, Material m, Vector v){
        center = position;
        r = radius;
        mat = m;
        movement = v;
    }
    //motion blur intersect
    public Intersection intersect(Ray ray){
        Point p = center.add(movement.scale(ray.getTime()));
        
        Vector diff = ray.getPosition().subtract(p);
        double a = ray.getDirection().dot(ray.getDirection());
        double b = (ray.getDirection().scale(2)).dot(diff);
        double c = diff.dot(diff)-(r*r);
        // determinant
        double d = (b*b)-4*a*c;
        if (d>=0){
            //Confirmed collision
            double distance = ((-b)-Math.sqrt(d))/(2*a);
            if (distance>EPSILON){
                Point collision = ray.evaluate(distance);
                Vector normal = collision.subtract(p).normalize();
                return new Intersection(collision, normal, distance, mat);
            }
        }
        return null;
    }
    //normal intersect
    // public Intersection intersect(Ray ray){
        // //Point p = center.add(movement.scale(ray.getTime()));
        
        // Vector diff = ray.getPosition().subtract(center);
        // double a = ray.getDirection().dot(ray.getDirection());
        // double b = (ray.getDirection().scale(2)).dot(diff);
        // double c = diff.dot(diff)-(r*r);
        // // determinant
        // double d = (b*b)-4*a*c;
        // if (d>=0){
            // //Confirmed collision
            // double distance = ((-b)-Math.sqrt(d))/(2*a);
            // if (distance>EPSILON){
                // Point collision = ray.evaluate(distance);
                // Vector normal = collision.subtract(center).normalize();
                // return new Intersection(collision, normal, distance, mat);
            // }
        // }
        // return null;
    // }
}