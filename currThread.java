public class currThread{
public static void main(String[] args){
Thread currentThread = Thread.currentThread();

System.out.println("thread name:"+currentThread.getName());
System.out.println("thread id:"+currentThread.getId());
System.out.println("thread priority:"+currentThread.getPriority());
System.out.println("thread state:"+currentThread.getState());
System.out.println("thread daemon:"+currentThread.isDaemon());
System.out.println("thread alive:"+currentThread.isAlive());
System.out.println("thread interrupted:"+currentThread.isInterrupted());

}
}