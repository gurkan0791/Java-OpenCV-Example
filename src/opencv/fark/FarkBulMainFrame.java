/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opencv.fark;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.opencv.core.Core;
import org.opencv.core.CvException;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author sony
 */
public class FarkBulMainFrame extends javax.swing.JFrame implements MouseListener, MouseMotionListener{

    /**
     * Creates new form FarkBulMainFrame
     */
    
    private static Mat web_cam;
    private static Mat reference_section;
    private static Mat temp;
    private static Mat element;
    private static Graphics g;
    private static Graphics g1;
    private static Graphics g2;
    private static Graphics g3;
    private static BufferedImage image;
    Thread t;
    boolean threadDurum;
    boolean drag;
    VideoCapture videoCapture;
    private static Point first_point;
    private static Point second_point;
    private int reference_value;
    private static Point staticFirstPoint;
    private static Point staticSecondPoint;
    public FarkBulMainFrame() {
        initComponents();
        
        
        threadDurum = false;
        drag = false;
        videoCapture = null;
        t = null;
        g = jPanelWebCamShow.getGraphics();
        g1 = jPanelRefCapture.getGraphics();
        g2 = jPanelComCapture.getGraphics();
        g3 = jPanelfark.getGraphics();
        reference_value = 0;
        reference_section = new Mat();
        temp = new Mat();
        element =  Imgproc.getStructuringElement(Imgproc.MORPH_RECT,new Size(2,2));
        this.addWindowListener(new WindowAdapter() {
             @Override
            public void windowClosing(WindowEvent e) {
                    if (videoCapture!=null&&videoCapture.isOpened()) {
                     t.stop();
                     videoCapture.release();
                     t.interrupt();
                 }
                   System.exit(0);
            }
             
            });
//        this.addMouseListener(this);
        jPanelWebCamShow.addMouseListener(this);
        jPanelWebCamShow.addMouseMotionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanelWebCamShow = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTBWebCamOpen = new javax.swing.JToggleButton();
        jButtonRefConfirm = new javax.swing.JButton();
        jButtonKarsilastir = new javax.swing.JButton();
        jPanelRefCapture = new javax.swing.JPanel();
        jPanelComCapture = new javax.swing.JPanel();
        jPanelfark = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelWebCamShowLayout = new javax.swing.GroupLayout(jPanelWebCamShow);
        jPanelWebCamShow.setLayout(jPanelWebCamShowLayout);
        jPanelWebCamShowLayout.setHorizontalGroup(
            jPanelWebCamShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanelWebCamShowLayout.setVerticalGroup(
            jPanelWebCamShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTBWebCamOpen.setText("Kamera Aç");
        jTBWebCamOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBWebCamOpenActionPerformed(evt);
            }
        });

        jButtonRefConfirm.setText("Referans Onay");
        jButtonRefConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefConfirmActionPerformed(evt);
            }
        });

        jButtonKarsilastir.setText("Karsilastir");
        jButtonKarsilastir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKarsilastirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRefConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTBWebCamOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonKarsilastir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTBWebCamOpen)
                .addGap(18, 18, 18)
                .addComponent(jButtonRefConfirm)
                .addGap(18, 18, 18)
                .addComponent(jButtonKarsilastir)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelRefCaptureLayout = new javax.swing.GroupLayout(jPanelRefCapture);
        jPanelRefCapture.setLayout(jPanelRefCaptureLayout);
        jPanelRefCaptureLayout.setHorizontalGroup(
            jPanelRefCaptureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelRefCaptureLayout.setVerticalGroup(
            jPanelRefCaptureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelComCaptureLayout = new javax.swing.GroupLayout(jPanelComCapture);
        jPanelComCapture.setLayout(jPanelComCaptureLayout);
        jPanelComCaptureLayout.setHorizontalGroup(
            jPanelComCaptureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelComCaptureLayout.setVerticalGroup(
            jPanelComCaptureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelfarkLayout = new javax.swing.GroupLayout(jPanelfark);
        jPanelfark.setLayout(jPanelfarkLayout);
        jPanelfarkLayout.setHorizontalGroup(
            jPanelfarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelfarkLayout.setVerticalGroup(
            jPanelfarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelWebCamShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRefCapture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelComCapture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelfark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelWebCamShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelRefCapture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelComCapture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelfark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTBWebCamOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBWebCamOpenActionPerformed
        t = new Thread(){
            @Override
            public  void  run(){
             MatToBufImg matToBufferedImageConverter = new MatToBufImg(); //Utility class to convert Mat to Java's BufferedImage
                
                
                
                videoCapture = new VideoCapture("D:\\colorTest.mp4");
                if (!videoCapture.isOpened()) {
                    System.out.println("Kamera Açık Değil..!");
                }else System.out.println("Kamera Açıldı --> "+videoCapture.toString());
            
                web_cam = new Mat(480,640,CvType.CV_8UC3);
                
                if (videoCapture.isOpened()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        
                    }
                    
                    while (true) {
                        try {
                            videoCapture.read(web_cam);
                        } catch (Exception e) {
                            System.out.println("Web Cam Kapalı !");
                        }
                        
                        if (!web_cam.empty()) {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                
                            }
                            if (drag&&reference_value==0&&first_point!=null && second_point!=null) {
                                 Core.rectangle(web_cam,first_point,second_point, new Scalar(0, 0, 255));
                            }
                            if (reference_value == 1) {
                                Core.rectangle(web_cam, staticFirstPoint, staticSecondPoint, new Scalar(255, 0, 0));
                            }
                            
                            matToBufferedImageConverter.setMatrix(web_cam, ".jpg");
                            image =matToBufferedImageConverter.getBufferedImage();
                            g.drawImage(image, 0, 0,web_cam.cols(),web_cam.rows(), null);
                        }else{
                            
                            System.out.println("Görüntü yok!");
                            break;
                        }
                    }
                }  
            }
        };t.start();
        
    }//GEN-LAST:event_jTBWebCamOpenActionPerformed
  
    private void jButtonRefConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefConfirmActionPerformed
//        reference_section = temp;
        System.out.println("Referens 1  yap");
        reference_value = 1;
        try {
          Highgui.imwrite("D:\\resim2.jpg", reference_section);     
        } catch (CvException e) {
        }
    }//GEN-LAST:event_jButtonRefConfirmActionPerformed

    private void jButtonKarsilastirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKarsilastirActionPerformed
        
        System.out.println("");
         Highgui.imwrite("D:\\resim2.jpg", reference_section);
        if (reference_value == 1) {
            System.out.println("Karşılaştır");
            Rect r = new Rect(staticFirstPoint, staticSecondPoint);
           temp = web_cam.submat(r);
            MatToBufImg matToBufImage = new MatToBufImg();
           matToBufImage.setMatrix(temp, ".jpg");
           g2.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
            Highgui.imwrite("D:\\resim1.jpg", temp);
             
            theDifferenceBetweenTheTwoImages(reference_section,temp);
        }
    }//GEN-LAST:event_jButtonKarsilastirActionPerformed

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
            java.util.logging.Logger.getLogger(FarkBulMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarkBulMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarkBulMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarkBulMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FarkBulMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonKarsilastir;
    private javax.swing.JButton jButtonRefConfirm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelComCapture;
    private javax.swing.JPanel jPanelRefCapture;
    private javax.swing.JPanel jPanelWebCamShow;
    private javax.swing.JPanel jPanelfark;
    private javax.swing.JToggleButton jTBWebCamOpen;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
//        System.out.println(first_point);
        if (reference_value==0) {
            System.out.println("burdayım");
            first_point = new Point(me.getX(), me.getY());
            jPanelRefCapture.repaint();
        }     
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("mouse bırakıldı");
        
        
        if (drag && reference_value==0) {
            System.out.println("içerdeyim");
            try{
            Rect r1 = new Rect(first_point, second_point);
            Mat ref = new Mat();
            web_cam.copyTo(ref);
            reference_section = ref.submat(r1);
        
         
                MatToBufImg matToBufImage = new MatToBufImg();
        matToBufImage.setMatrix(reference_section, ".jpg");
        g1.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
        Highgui.imwrite("D:\\refResim.jpg", reference_section);
            } catch (CvException e) {
                System.out.println(" OpenCV Sorun Oluştu");
            }catch(Exception ex){
                System.out.println("Java sorun Oluştu");
            }
        
        
         staticFirstPoint = first_point;
         staticSecondPoint = second_point;
       
        
        first_point = null;
        second_point = null;
        
        }
        drag = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        drag = true;
       second_point = new Point(me.getX(), me.getY());
//        System.out.println(second_point);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    private static void theDifferenceBetweenTheTwoImages(Mat ref, Mat tem) {
        
        Mat sonuc = new Mat(tem.rows(),tem.cols(),CvType.CV_8UC1);
        Mat gray1 = new Mat(tem.rows(),tem.cols(),CvType.CV_8UC1);
        Mat gray2 = new Mat(reference_section.rows(),reference_section.cols(),CvType.CV_8UC1);
        
        Imgproc.cvtColor(tem, gray1, Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(ref, gray2, Imgproc.COLOR_BGR2GRAY);
        
       MatToBufImg matToBufImage = new MatToBufImg();
        
        
        
        matToBufImage.setMatrix(gray2, ".jpg");
        g1.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
        
        matToBufImage.setMatrix(gray1, ".jpg");
        g2.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
       
        
        Core.absdiff(gray1, gray2, sonuc);
        Imgproc.blur(sonuc, sonuc, new Size(10,10));
        Imgproc.threshold(sonuc, sonuc, 15, 255, Imgproc.THRESH_BINARY);
        Imgproc.erode(sonuc, sonuc, element);
        int sayac = 0;
        float boyut = sonuc.cols()*sonuc.rows();
        for (int i = 0; i < sonuc.cols(); i++) {
            for (int j = 0; j < sonuc.rows(); j++) {
                double a [] = sonuc.get(j, i);
                if (a[0] == 255) {
                    sayac++;
                }
            }
        }
        System.out.println();
        float hata= (sayac/boyut)*100;
        System.out.println("Bozukluk oranı % :" +hata);
//        Imgproc.cvtColor(sonuc, sonuc, Imgproc.COLOR_GRAY2BGR);
//        Core.bitwise_and(sonuc, tem, sonuc);
        
        matToBufImage.setMatrix(sonuc, ".jpg");
        g3.drawImage(matToBufImage.getBufferedImage(), 0, 0, null);
//        Highgui.imwrite("D:\\farkResim.jpg",sonuc);
    }
}
