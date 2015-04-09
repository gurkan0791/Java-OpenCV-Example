/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opencv.fark;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.StyleConstants;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author sony
 */
public class ResimSecMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form ResimSecMainFrame
     */
    private static Mat resim1;
    private static Mat resim2;
    private Mat element;
    Graphics g;
    Graphics g1;
    Graphics g2;
    Thread t1;
    Thread t2;
    public ResimSecMainFrame() {
        initComponents();
        g = jPanel1.getGraphics();
        g1 =  jPanel2.getGraphics();
        
        element =  Imgproc.getStructuringElement(Imgproc.MORPH_RECT,new Size(2,2));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonFarkBul = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        jButton1.setText("RESİM SEÇ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RESİM SEÇ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Karsilastir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonFarkBul.setText("Fark");
        jButtonFarkBul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFarkBulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonFarkBul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFarkBul)
                        .addGap(30, 30, 30)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF & BMP Images", "jpg", "gif");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(null);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getName()+chooser.getSelectedFile().getPath());
       String url = null;
           try {
                url = chooser.getSelectedFile().getPath();
                System.out.println(url);
             resim1 =   Highgui.imread(url.toString());
//                BufferedImage b = ImageIO.read(url);
//                BufferedImage b1 = new BufferedImage(b.getWidth(), b.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
//                b1=b;
//               byte [] pixels = ((DataBufferByte)b1.getRaster().getDataBuffer()).getData();
//               
//                resim1 = new Mat(b1.getHeight(),b1.getWidth(),CvType.CV_8UC3);
//                resim1.put(0, 0, pixels);
//                System.out.println(resim1.cols());
//                g.drawImage(b, 0, 0,b.getWidth(),b.getHeight(), null);
             
            MatToBufImg c= new MatToBufImg();
            c.setMatrix(resim1, ".jpg");
             g.drawImage(c.getBufferedImage(), 0, 0, null);
           } catch(Exception e){}
          
    }
 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF & BMP Images", "jpg", "gif");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(this);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getName()+chooser.getSelectedFile().getPath());
       String url = null;
           try {
               
               url = chooser.getSelectedFile().getPath();
               resim2 = Highgui.imread(url);
//                BufferedImage b = ImageIO.read(url);
//                BufferedImage b1 = new BufferedImage(b.getWidth(), b.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
//                b1=b;
//               byte [] pixels = ((DataBufferByte)b1.getRaster().getDataBuffer()).getData();
//               
//                resim2 = new Mat(b1.getHeight(),b1.getWidth(),CvType.CV_8UC3);
//                resim2.put(0, 0, pixels);
//                System.out.println(resim2.cols());
////                g.drawImage(b, 0, 0,b.getWidth(),b.getHeight(), null);
//                g1.drawImage(b, 0, 0,b.getWidth(),b.getHeight(), null);
//               
               MatToBufImg c= new MatToBufImg();
            c.setMatrix(resim2, ".jpg");
             g1.drawImage(c.getBufferedImage(), 0, 0, null);
           } 
           catch(Exception E){}
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Mat sonuc = new Mat(resim1.rows(),resim1.cols(),CvType.CV_8UC1);
        Mat gray1 = new Mat(resim1.rows(),resim1.cols(),CvType.CV_8UC1);
        Mat gray2 = new Mat(resim1.rows(),resim1.cols(),CvType.CV_8UC1);
        
        Imgproc.cvtColor(resim1, gray1, Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(resim2, gray2, Imgproc.COLOR_BGR2GRAY);
        
       MatToBufImg matToBufImage = new MatToBufImg();
        
        
        
        matToBufImage.setMatrix(gray1, ".jpg");
        g.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
        
        matToBufImage.setMatrix(gray2, ".jpg");
        g1.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
       
        
        Core.absdiff(gray1, gray2, sonuc);
        Imgproc.blur(sonuc, sonuc, new Size(10,10));
        Imgproc.threshold(sonuc, sonuc, 15, 255, Imgproc.THRESH_BINARY);
        Imgproc.erode(sonuc, sonuc, element);
        
        Imgproc.cvtColor(sonuc, sonuc,Imgproc.COLOR_GRAY2BGR);
        
        Core.bitwise_and(resim2, sonuc, sonuc);
                            
                          
        matToBufImage.setMatrix(sonuc, ".jpg");
        g1.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonFarkBulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFarkBulActionPerformed
      Thread t = new Thread(){
          @Override
          public void run(){
                Mat sonuc = new Mat(resim1.rows(),resim1.cols(),CvType.CV_8UC1);
                Mat gray1 = new Mat(resim1.rows(),resim1.cols(),CvType.CV_8UC1);
                Mat gray2 = new Mat(resim1.rows(),resim1.cols(),CvType.CV_8UC1);
                System.out.println(gray1.channels());
                Imgproc.cvtColor(resim1, gray1, Imgproc.COLOR_BGR2GRAY);
                Imgproc.cvtColor(resim2, gray2, Imgproc.COLOR_BGR2GRAY);
        
          for (int i = 0; i < gray1.rows(); i++) {
            for (int j = 0; j < gray1.cols(); j++) {
                
                double [] kresim1 = gray1.get(i, j);
                double [] kresim2 = gray2.get(i, j);
                //System.out.println(resim1[0]+" "+resim2[0]);
                if (kresim1[0] != kresim2[0]) {
                   // System.out.println(kresim1[0]);
                    g1.setFont(new Font("TimesRoman", Font.PLAIN, 2)); 
                   // g1.drawString("*", j, i);
                    
                    
                    gray2.put(i, j, kresim2[0]*255);
                    
                }
            }
            
            jProgressBar1.setValue(i);
        }
          MatToBufImg matToBufImage = new MatToBufImg();
          matToBufImage.setMatrix(gray2, ".jpg");
        g1.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
          }
      };t.start();
       
        
        
        
    }//GEN-LAST:event_jButtonFarkBulActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResimSecMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResimSecMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResimSecMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResimSecMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResimSecMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonFarkBul;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
