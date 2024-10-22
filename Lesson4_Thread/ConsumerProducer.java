
package Lesson4_Thread;
class SharedData{
    int data;
    boolean produced = false;
    public synchronized void produce(int data) throws InterruptedException{
        if(produced) this.wait();
        this.data = data;
        System.out.println("Produce: " + data);
        produced = true;
        this.notify();
    }
    public synchronized void consume() throws InterruptedException{
        if(!produced) this.wait();
        System.out.println("Consume: " + data);
        this.data = 0;
        produced = false;
        this.notify();
    }
}
class Consumer implements Runnable{
    SharedData sd;
    public Consumer(SharedData sd) {
        this.sd = sd;
    }
    public void run(){
        for(int i = 0;i<5;i++){
            try {
                sd.consume();
            } catch (Exception e) {
            }
        }
    }
}
class Producer extends Thread{
    SharedData sd;
    public Producer(SharedData sd) {
        this.sd = sd;
    }
    public void run(){
        for(int i = 0;i<5;i++){
            try {
                sd.produce((int)(Math.random()*100));
            } catch (Exception e) {
            }
        }
    }
}
public class ConsumerProducer {
    public static void main(String[] args) {
        SharedData sd = new SharedData();
        new Producer(sd).start();//ex
        new Thread(new Consumer(sd)).start();//imp
        
    }
}
