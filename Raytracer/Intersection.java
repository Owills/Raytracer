public class Intersection{
    private Point position;
    private Vector normal;
    private double distance;
    private Material surfaceMaterial;
    public Intersection(Point pos, Vector norm, 
                        double dist, Material material){
        position = pos;
        normal = norm;
        distance = dist;
        surfaceMaterial = material;
    } 
    public Point getPosition(){
        return position;
    }
    public Vector getNormal(){
        return normal;
    }
    public double getDistance(){
        return distance;
    }
    public Material getMaterial(){
        return surfaceMaterial;
    }    

}
