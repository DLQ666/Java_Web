package com.dlq.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-19 13:32
 */
public class ThreadLocalTest {

    //public final static Map<String,Object> DATA= new ConcurrentHashMap<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    public final static Random RANDOM = new Random();

    public static class Task {

        public static void taskRun() {
            //在Run方法中，随机生成一个变量（线程要关联的数据)，然后以当前线程名为key保存到map
            Integer i = RANDOM.nextInt(1000); //取 0-999的随机数
            //取当前线程名
            //String name = Thread.currentThread().getName();
            System.out.println("线程["+Thread.currentThread().getName()+"]生成的随机数是"+i);
            threadLocal.set(i);

            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

            //在Run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
            Object name1 = threadLocal.get();
            System.out.println("在线程[" + Thread.currentThread().getName() +"]快结束时取出关联的数据是："+name1);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                Task.taskRun();
            }, String.valueOf(i)).start();
        }
    }
}
