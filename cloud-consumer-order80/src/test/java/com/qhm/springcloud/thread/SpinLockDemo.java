package com.qhm.springcloud.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @author Administrator
 *
 */
public class SpinLockDemo {

	AtomicReference<Thread> atomicReference = new AtomicReference<>();
	
	public static void main(String[] args) {
		// 实例化一个spinlockdemo类
		SpinLockDemo spinLockDemo = new SpinLockDemo();
		
		// 新的线程AA
		new Thread(() -> {
			spinLockDemo.myLock();
			// 暂停一会
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			spinLockDemo.myUnLock();
		}, "AA").start();
		
		// 等待几秒
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 新的线程BB
		new Thread(()->{
			spinLockDemo.myLock();
			spinLockDemo.myUnLock();
		}, "BB").start() ;
		
	}
	
	// 锁
	public void myLock() {
		Thread thread = Thread.currentThread();
		System.out.println(Thread.currentThread().getName() + "\t" + "come in");
		// 循环判断
		while(!atomicReference.compareAndSet(null, thread)){
			
		}
	}
	
	// 解锁
	public void myUnLock() {
		Thread thread = Thread.currentThread();
		atomicReference.compareAndSet(thread, null);
		System.out.println(Thread.currentThread().getName() + "\t" + "invocked myUnLock()");
	}

}
