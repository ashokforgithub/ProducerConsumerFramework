/**
 * 
 */
package com.mycomp.prodcons.framework.event.store;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import com.mycomp.prodcons.framework.event.ActionEvent;

/**
 * @author ashok
 *
 */
public class EventStore {
	
	private static EventStore eventStore;
	
	private BlockingQueue< ActionEvent> inputQ = new LinkedBlockingQueue<ActionEvent>();
	
	private static ReentrantLock startLock = new ReentrantLock(true);
	
	//Hiding Constructor
	private EventStore()
	{
		
	}
	
	public static EventStore getInstance()
	{
		try {
			startLock.lock();
			
			if(null == eventStore)
			{
				eventStore =  new EventStore();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if(startLock.isLocked())
				startLock.unlock();
		}
		
		return eventStore;
	}
	
	
	public void putInQueue(ActionEvent actionEvent)
	{
		try {
			
			inputQ.put(actionEvent);
			System.out.println(actionEvent+ " put in Queue");
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	
	public ActionEvent getFromQueue()
	{
		ActionEvent actionEvent = null;
		
		try {
			
			actionEvent = inputQ.take();
			System.out.println(actionEvent+ " taken from Queue");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return  actionEvent;
	}

}
