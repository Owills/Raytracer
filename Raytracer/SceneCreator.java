/**
 * Details the static methods to creating various scenes for use in the raytracer.
 * scene1() is included as an example. You can add more static methods (for example scene2(),
 * scene3(), etc.) to create different scenes without affecting scene1.
 *
 * @author Ben Farrar
 * @version 2019.05.22
 */
public class SceneCreator {
    public static Scene scene1(double xResolution, double yResolution){
        Camera cam = new Camera(new Point(0,0,0),       // camera location
                                new Vector(0,0,-1),     // forward vector/view direction
                                new Vector(0,1,0),      // up vector
                                20,                     // field of view
                                xResolution/yResolution); // aspect ratio
        Scene s = new Scene(cam);
        
        //Each sphere takes a Point (its center), the radius, and a material.
        //For now, since we have not implemented the Material classes, we simply say they are null.
        // Surface s1 = new Sphere(new Point(0,0,-20),3, null);
        // s.addSurface(s1);
        // Surface s2 = new Sphere(new Point(0,4,-15),1, null);
        // s.addSurface(s2);
        // Surface s3 = new Sphere(new Point(5,0,-20),1.5, null);
        // s.addSurface(s3);
        //Each triangle takes 3 Points (its vertexes), and a material.
        Surface t1 = new Triangle(new Point(-3.5,-1,-15), new Point(-3.5,1,-15), new Point(-5,0,-16), null);
        s.addSurface(t1);
        Surface floor = new Triangle(new Point(0,-5,0), new Point(3000,-5,-1000), new Point(-3000,-5,-1000), null);
        s.addSurface(floor);
        
        return s;
    }
    public static Scene scene2(double xResolution, double yResolution){
        Camera cam = new Camera(new Point(0,0.5,0),       // camera location
                                new Vector(0,0,-1),     // forward vector/view direction
                                new Vector(0,1,0),      // up vector
                                20,                     // field of view
                                xResolution/yResolution ); // aspect ratio
        Scene s = new Scene(cam);
        Color grey = new Color (0.5,0.5,0.5);
        Color white = new Color (1.1,1.1,1.1);
        Color black = new Color (0,0,0);
        Color red = new Color (1,0,0);
        Color green = new Color (0,1,0);
        Color blue = new Color (0,0,1);
        
        Material m1 = new Lambert(red);
        Material m2 = new Lambert(grey);
        Material m3 = new Lambert(black);
        
        Material m4 = new MirrorPhong(grey,black,10,10);
        Material m5 = new MirrorPhong(grey,white,10,10);
        Material m6 = new Phong(grey,white,10);
        
        Material m7 = new Lambert(green);
        Material m8 = new Lambert(blue);
        Material m9 = new Phong(green,white,10);
        
        Light l1 = new LightBulb(white,new Point(0,3,-10),0.5,0.5,0.5);
        s.addLight(l1);
        Vector v = new Vector(0,0,0);
        
        Surface s1 = new Sphere(new Point(0,-3,-25),2, m6,v);
        s.addSurface(s1);
       
        
        
        
        
        
        
        Surface wall1 = new Triangle(new Point(-50,-20,-100),new Point(-50,30,-100),new Point(50,30,-100),m2);
        s.addSurface(wall1);
        Surface wall2 = new Triangle(new Point(-50,-20,-100),new Point(50,-20,-100),new Point(50,30,-100),m2);
        s.addSurface(wall2);
        
        
        
        Surface floor = new Triangle(new Point(0,-5,0), new Point(30000,-5,-10000), new Point(-30000,-5,-10000), m2);
        s.addSurface(floor);
        
        return s;
    }
}