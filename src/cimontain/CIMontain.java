/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cimontain;
import java.io.*;
import sun.audio.*;
/**
 *
 * @author Famil
 */
public class CIMontain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    throws Exception
    {
        String sonido="C:/Users/Famil/OneDrive/Escritorio/Sistema/Sistema/output_free-_1_.wav";
        InputStream in = new FileInputStream(sonido);
        AudioStream audio = new AudioStream(in);
        AudioPlayer.player.start(audio);
        Splahs w = new Splahs();
        w.setVisible(true);
    }
    
}
