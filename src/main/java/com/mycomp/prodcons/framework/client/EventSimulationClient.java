/**
 * 
 */
package com.mycomp.prodcons.framework.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mycomp.prodcons.framework.event.DeleteEvent;
import com.mycomp.prodcons.framework.event.ReadEvent;
import com.mycomp.prodcons.framework.event.UpdateEvent;
import com.mycomp.prodcons.framework.event.store.EventStore;
import com.mycomp.prodcons.framework.event.util.EventUtils;

/**
 * @author ashok
 * 
 * A Simulator Class to Test Event Driven Approach.
 */
public class EventSimulationClient {

	static class Producer implements Runnable {

		private EventStore eventStore = EventStore.getInstance();

		public void run() {
			int choice = EventUtils.getRandomInteger();
			System.out.println(" Random Choice " + choice + " After modulus, Choice=" + (choice % 4));

			switch (choice % 4) {
			case 0:
				eventStore.putInQueue(new ReadEvent());
				break;
			case 1:
				eventStore.putInQueue(new UpdateEvent());
				break;
			case 2:
				eventStore.putInQueue(new DeleteEvent());
				break;
			case 3:
				eventStore.putInQueue(new UpdateEvent());
				break;
			default:
				System.out.println("Not a good choice");
			}
		}

	}

	static class Consumer implements Runnable {
		private EventStore eventStore = EventStore.getInstance();

		public void run() {
			// TODO Auto-generated method stub
			eventStore.getFromQueue().execute();

			try {

				Thread.sleep(EventUtils.getRandomInteger());

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}
	
	
	public static void main(String[] args) {
		
		ExecutorService producerExecutorService  = Executors.newFixedThreadPool(10);
		Producer producer = new Producer();
		
		for (int i = 0; i <15 ; i++) {
			producerExecutorService.execute(producer);
			
		}

		
		ExecutorService consumerExecutorService  = Executors.newFixedThreadPool(10);
		Consumer consumer = new Consumer();
		
		for (int i = 0; i <15 ; i++) {
			consumerExecutorService.execute(consumer);
			
		}

		producerExecutorService.shutdown();
		consumerExecutorService.shutdown();
	}
	

	
	
	
}















