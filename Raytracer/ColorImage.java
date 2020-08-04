
public class ColorImage{
  private Color[][] image;
  public ColorImage(int newWidth, int newHeight){
    image = new Color[newWidth][newHeight];
    for(int i = 0; i < newWidth; i++){
        for(int j = 0; j < newHeight; j++){
            Color c = new Color(0.99,0.99,0.99);
            image[i][j] = (c);
        }  
    }    
  } 
  public int getWidth(){return image.length;}
  public int getHeight(){return image[0].length;}
  public Color getColor (int col, int row){return image[col][row];}    
  public void setColor (int col, int row, Color c){
      image[col][row] = c;
    }    
}
