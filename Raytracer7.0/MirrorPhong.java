public class MirrorPhong extends Phong{
   double reflectiveness;
   public MirrorPhong(Color diff, Color spec, double exp, double refPwr){
       super(diff,spec,exp);
       reflectiveness = refPwr;
   }   
   @Override
   public double getReflectiveness(){
       return reflectiveness;
   }    

}
