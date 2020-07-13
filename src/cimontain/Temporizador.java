package cimontain;


import javax.swing.JProgressBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Famil
 */
public class Temporizador extends Thread{
    JProgressBar proceso;
    public Temporizador(JProgressBar progreso){
        super();
        this.proceso=progreso;
    }
    @Override
    public void run(){
       for(int i=0;i<=100;i++){
          proceso.setValue(i);
          pausa(200);
       } 
    }
    public void pausa(int mlSeg){
        try{
            Thread.sleep(mlSeg);
        }catch(Exception e){
            
        }
    }
}
