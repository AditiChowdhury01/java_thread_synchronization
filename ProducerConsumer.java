import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer{
private static final int BUFFER_SIZE = 5;
private static final Queue<Integer>buffer = new LinkedList<>();

public static void main(String[] args){
Thread producerThread = new Thread(new Producer());
Thread consumerThread = new Thread(new Consumer());

producerThread.start();
consumerThread.start();
}

static class Producer implements Runnable{
public void run(){
int value = 0;
while(true){
synchronized(buffer){
while(buffer.size()==BUFFER_SIZE){
try{
buffer.wait();
}
catch(InterruptedException e){
System.out.println(e);
}

}

System.out.println("producer produced:"+value);
buffer.add(value++);

buffer.notify();

try{
Thread.sleep(1000);
}
catch(InterruptedException e){
System.out.println(e);
}

}
}
}
}

static class Consumer implements Runnable{
public void run(){
while(true){
synchronized(buffer){
while(buffer.isEmpty()){
try{
buffer.wait();
}
catch(InterruptedException e){
System.out.println(e);
}

}

int value = buffer.poll();
System.out.println("consumer consumed:"+value);

buffer.notify();

try{
Thread.sleep(1000);
}
catch(InterruptedException e){

System.out.println(e);
}
}
}
}
}
}