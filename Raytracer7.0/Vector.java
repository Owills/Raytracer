public class Vector{
    private double dx;
    private double dy;
    private double dz;
    public Vector(double newDX, double newDY, double newDZ){
       dx = newDX;
       dy = newDY;
       dz = newDZ;
    }
    public Vector scale(double scalar){
        return new Vector(this.dx*scalar, this.dy*scalar, this.dz*scalar);
    }    
    public Vector subtract(Vector v){
        return new Vector(this.dx-v.getDX(), this.dy-v.getDY(), this.dz-v.getDZ());
    }   
    public double dot(Vector v){
        return (this.dx * v.getDX() + this.dy * v.getDY() + this.dz * v.getDZ());
    }    
    public Vector cross(Vector v){
        return new Vector(this.dy * v.getDZ() - this.dz * v.getDY(), 
                               this.dz * v.getDX() - this.dx * v.getDZ(), 
                               this.dx * v.getDY() - this.dy * v.getDX());
    } 
    public double length(){
        return Math.sqrt(this.dot(this));
    }    
    public Vector normalize(){
        return this.scale(1/this.length());
    }    
    public double getDX(){
        return dx;
    } 
    public double getDY(){
        return dy;
    } 
    public double getDZ(){
        return dz;
    } 
}
