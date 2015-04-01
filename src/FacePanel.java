
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sony
 */
public class FacePanel extends JPanel{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
       
	private BufferedImage image;
	    int count = 0;
	    private int x, y, width,height;
	    public FacePanel(){
	        super();
              

	    }
	    //daireSet
	    public void setRectParameter(int x1, int y1,int width1, int height1){
	        x = x1;
	        y = y1;
	        width = width1;
	        height = height1;
	    }
	    public void setFace(BufferedImage img){
	        image = img;
	    }
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        if (this.image == null) {
	            System.out.println("Görüntü hazır değil !");
	            return;
	        }
	        g.drawImage(this.image, 10, 10, this.image.getWidth(),this.image.getHeight(),null);
	        g.setColor(Color.green);
	        g.drawRect(x, y, width, height);
	        System.out.println("(x,y) ="+ x+", "+y);
	        g.setFont(new Font("arial", 2, 20));
	        g.drawString("Resim Sayısı : "+ (count++),50, 50);
	    }
}
