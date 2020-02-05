/**
 * 
 */
package com.mycomp.prodcons.framework.event.store;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import com.mycomp.prodcons.framework.event.ActionEvent;

/**
 * @author Ashok
 *
 */
public class EventStore {
	
	private static ReentrantLock lock = new ReentrantLock();
	
	private static EventStore eventStore;	
	
	private BlockingQueue<ActionEvent> inputQueue= new LinkedBlockingQueue<>();
	

	/**
	 *  Hidding Constructor
	 */
	private EventStore() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return
	 */
	public static EventStore getStore()
	{
		try {
			lock.lock();
			if (null == eventStore) {				
				eventStore = new EventStore();				
			} 
			lock.unlock();
		} finally {
			// TODO: handle finally clause
			
			if(lock.isLocked()) lock.unlock();
		}
		
		return eventStore;
		
	}
	
	/**
	 * @param actionEvent
	 */
	public void putInQueue(ActionEvent actionEvent) {
		
		try {
			this.inputQueue.put(actionEvent);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return
	 */
	public ActionEvent getFromQueue() {
		ActionEvent actionEvent=null;

		try {
			actionEvent= this.inputQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  actionEvent;
	}
	

}
