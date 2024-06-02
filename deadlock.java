/*import java.io.*;
import java.util.*;

class A{
public synchronized void last(){
System.out.println("inside A,last() meyhod");
}
public synchronized void d1(B b){
System.out.println("thtead start execution of d1() ,method");

try{
Thread.sleep(2000);
}

catch(InterruptedException e){
System.out.println(e);
}

System.out.println("Thred trying to call B's last() method");
b.last();
}
}

class B{
public synchronized void last(){
System.out.println("inside B,last() meyhod");
}
public synchronized void d2(A a){
System.out.println("thtead start execution of d1() ,method");

try{
Thread.sleep(2000);
}

catch(InterruptedException e){
System.out.println(e);
}

System.out.println("Thred trying to call A's last() method");
a.last();
}
}

public class deadlock extends Thread{
A a = new A();
B b = new B();

public void m1(){
this.start();
a.d1(b);
}

public void run(){
b.d2(a);
}

public static void main(String[] args){
deadlock dead = new deadlock();
dead.m1();
}
}
*/

import java.io.*;
import java.util.*;


class A{
public synchronized void last(){
System.out.println("inside A,last() meyhod");
}
public synchronized void d1(B b){
System.out.println("thtead start execution of d1() ,method");

try{
Thread.sleep(2000);
}

catch(InterruptedException e){
System.out.println(e);
}

System.out.println("Thred trying to call B's last() method");
b.last();
}
}

class B{
public void last(){
System.out.println("inside B,last() meyhod");
}
public void d2(A a){
System.out.println("thtead start execution of d1() ,method");

try{
Thread.sleep(2000);
}

catch(InterruptedException e){
System.out.println(e);
}

System.out.println("Thred trying to call A's last() method");
a.last();
}
}

public class deadlock extends Thread{
A a = new A();
B b = new B();

public void m1(){
this.start();
a.d1(b);
}

public void run(){
b.d2(a);
}

public static void main(String[] args){
deadlock dead = new deadlock();
dead.m1();
}
}

