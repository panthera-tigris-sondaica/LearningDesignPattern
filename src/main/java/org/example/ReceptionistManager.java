package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ReceptionistManager {
    private static final ReceptionistManager rec=new ReceptionistManager();
    private static final int total_scooty=5;
    private  Queue<Scooty> list_pool;

    public static ReceptionistManager getInstance(){
       return rec;
    }
    private ReceptionistManager(){
        list_pool=new LinkedList<>();
        for(int i=0;i<total_scooty;i++){
            list_pool.offer(new Scooty(i));
        }

    }

    public Scooty scootyBorrow() throws InterruptedException{
        System.out.println("Thread" +Thread.currentThread().getName()+"waiting for getting sccoty object from pool");
        synchronized (rec.list_pool){
            while(rec.list_pool.isEmpty()) rec.list_pool.wait();
            return rec.list_pool.poll();
        }

    }
    public void scootyReturn(Scooty scooty) {
        System.out.println("Thread"+Thread.currentThread().getName()+"returning object to pool");
        synchronized (rec.list_pool){
            rec.list_pool.offer(scooty);
            rec.list_pool.notifyAll();
        }
    }


}
