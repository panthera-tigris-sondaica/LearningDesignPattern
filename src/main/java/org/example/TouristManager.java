package org.example;

import java.util.Random;

public class TouristManager extends Thread {
    public TouristManager(int id){
        super(String.format("T-%03d",id));
    }
    @Override
    public void run(){
        try{
            Scooty scooty= ReceptionistManager.getInstance().scootyBorrow();
            System.out.println("Thread"+Thread.currentThread().getName()+"borrowed Scooty Client id"+scooty.id);
            Thread.sleep(new Random().nextInt(10)*1000);
            ReceptionistManager.getInstance().scootyReturn(scooty);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}