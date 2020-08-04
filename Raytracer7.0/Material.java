
public abstract class Material{
    public abstract Color computeLighting(Intersection i, Ray viewingRay, Light li);
    public double getReflectiveness(){
        return 0;
    }    
}
