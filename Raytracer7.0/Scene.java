import java.util.ArrayList;
public class Scene{
   private Camera sceneCam;
   private ArrayList<Surface> surfaces;
   private ArrayList<Light> lights;
   public Scene (Camera newCam){
       sceneCam = newCam;
       surfaces = new ArrayList<Surface>();
       lights = new ArrayList<Light>();
   } 
   public boolean isShadowed(Point p, Light li){
       Ray r = new Ray(p,(li.computeLightDirection(p)));
       double d=  li.computeLightDistance(p);
       for(int i = 0; i<surfaces.size(); i++){
           Intersection inter = surfaces.get(i).intersect(r);
           if(inter != null && inter.getDistance() < d){
               return true;
           }    
       }    
       return false;
   }    
   public Color computeVisibleColor(Ray r, int bouncesLeft){
       Intersection closest = surfaces.get(0).intersect(r);
       for(int i = 1; i <surfaces.size(); i++){
           Intersection inter = surfaces.get(i).intersect(r);
           if(closest == null){
                closest = inter;
           } else if(inter != null && inter.getDistance() < closest.getDistance()){
               closest = inter;
           }    
       }   
       if(closest == null){
           return new Color(0,0,0);
       }    
       Color c = new Color(0,0,0);
       for(int j = 0; j< lights.size(); j++){
           if(!isShadowed(closest.getPosition(),lights.get(j))){
               Color c1 = closest.getMaterial().computeLighting(closest, r,lights.get(j));
               c = c.tint(c1);
           }    
       }    
       if(closest.getMaterial().getReflectiveness() == 0 || bouncesLeft == 0)
            return c;
       Vector N = closest.getNormal();  
       Vector V = r.getDirection().scale(-1);
       Vector M = N.scale(2* N.dot(V)).subtract(V);
       Ray newR = new Ray(closest.getPosition(),M);
       return computeVisibleColor(newR,bouncesLeft-1);
   }    
   public void addLight(Light li){
       lights.add(li);
   }    
   public void setCamera(Camera newCam){
       sceneCam = newCam;
   }   
   public void addSurface(Surface s){
       surfaces.add(s);
   }    
   public ColorImage render(int xRes, int yRes, int numSamples){
       ColorImage ci = new ColorImage(xRes, yRes);
       for(int i = 0; i< xRes; i++){
           for(int j = 0; j< yRes; j++){
               Color c = new Color(0,0,0);
               for(int ii = 0; ii< numSamples; ii++){
                    for(int jj = 0; jj< numSamples; jj++){
                       double u = (double)(i+(ii+0.5)/numSamples)/xRes;
                       double v = (double)(j+(jj+0.5)/numSamples)/yRes;
                       Ray r = sceneCam.generateRay(u,v);
                       c = c.add(computeVisibleColor(r,3));
                    }
               }   
               ci.setColor(i,j,c.scale(1.0 /(numSamples*numSamples)));
           } 
       } 
       return ci;
   }   
}
