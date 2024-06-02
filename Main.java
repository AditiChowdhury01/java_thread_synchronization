class IncrementThread extends Thread{
private Counter counter;
private int incrementsPerThread;

public IncrementThread(Counter counter,int incrementsPerThread){
this.counter = counter;
this.incrementsPerThread = incrementsPerThread;
}

public void run(){
for(int i = 0;i<incrementsPerThread;i++){
counter.increment();

}
}
}

class Counter{
private int count = 0;

public synchronized void increment(){
count = count +1;
}
public int getCount(){
return count;
}
}

public class Main{
public static void main(String[]args){
Counter counter = new Counter();
int numThreads =6;
int incrementsPerThread = 10000;
IncrementThread[] threads = new IncrementThread[numThreads];

for(int i =0;i<numThreads;i++){
threads[i] = new IncrementThread(counter,incrementsPerThread);
threads[i].start();
}

try{
for(IncrementThread thread:threads){
thread.join();
}
}
catch(InterruptedException e){
System.out.println(e);

}

System.out.println("final count:"+counter.getCount());
}

}