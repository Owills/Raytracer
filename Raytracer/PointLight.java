public class PointLight extends Light{
    private Color intensity;
    private Point position;
    public PointLight(Color c, Point location){
       intensity = c;
       position = location;
    }
    public Vector computeLightDirection(Point surfacePoint){
        return position.subtract(surfacePoint).normalize();
    }    
    public Color computeLightColor(Point surfacePoint){
        return intensity;
    }    
    public double computeLightDistance(Point surfacePoint){
        return surfacePoint.subtract(position).length();
    }    
    public void getRandomPoint(){
        return;
    }   
    
}
