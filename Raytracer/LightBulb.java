public class LightBulb extends Light{
    private Color intensity;
    private Point position;
    private double demX;// take up space in both the positive a negative directions, making the point the center
    private double demY;
    private double demZ;
    private Point random;
    public LightBulb(Color c, Point location,double demX, double demY, double demZ){
       intensity = c;
       position = location;
       this.demX = demX;
       this.demY = demY;
       this.demZ = demZ;
    }
    public Vector computeLightDirection(Point surfacePoint){
        return random.subtract(surfacePoint).normalize();
    }    
    public Color computeLightColor(Point surfacePoint){
        return intensity;
    }    
    public double computeLightDistance(Point surfacePoint){
        return surfacePoint.subtract(random).length();
    }    
    public void getRandomPoint(){
        double x = Math.random() * ((position.getX()+demX) - (position.getX()-demX)) + (position.getX() - demX);
        double y = Math.random() * ((position.getY()+demY) - (position.getY()-demY)) + (position.getY() - demY);
        double z = Math.random() * ((position.getZ()+demZ) - (position.getZ()-demZ)) + (position.getZ() - demZ);
        random = new Point(x,y,z);
    }    
}
