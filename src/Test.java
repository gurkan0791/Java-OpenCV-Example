
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sony
 */
public class Test {
    
    private static Point staticdeger ;
    private static Point normal;
    
    public Test(){
        staticdeger = new Point(4, 3);
    }
    
    public static void main(String[] args) {
        
        new Test();
        
        normal = staticdeger;
        normal.x ++;
        normal.y ++;
        
        System.out.println(staticdeger.x+ " "+staticdeger.y);
        
    }
}
