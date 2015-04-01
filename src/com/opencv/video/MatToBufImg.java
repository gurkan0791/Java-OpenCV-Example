package com.opencv.video;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sony
 */
class MatToBufImg {
    Mat matrix;
    MatOfByte mob;
    String fileExten;

     public MatToBufImg(){}
     
//	public MatToBufImg(Mat amatrix, String fileExtension){
//		matrix = amatrix;
//		fileExten = fileExtension;
//		mob = new MatOfByte();
//	}
     
	public void setMatrix(Mat amatrix, String fileExt){
           matrix = amatrix;
           fileExten = fileExt;
           mob = new MatOfByte();
       }
	
       public BufferedImage getBufferedImage(){
		//convert the matrix into a matrix of bytes appropriate for
		//this file extension
		 Highgui.imencode(fileExten, matrix ,mob); 
		//convert the "matrix of bytes" into a byte array
		 byte[] byteArray = mob.toArray();
		         BufferedImage bufImage = null;
		 try {
		        InputStream in = new ByteArrayInputStream(byteArray);
		        bufImage = ImageIO.read(in);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 return bufImage;
	}
}
