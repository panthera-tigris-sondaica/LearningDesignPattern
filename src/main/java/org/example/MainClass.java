package org.example;

public class MainClass {
    public static void main(String[] args) {
       for(int i=0;i<10;i++){
           System.out.println("main calling" +i);
           new TouristManager(i).start();}
    }
}
