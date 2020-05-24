/**
 * 
 */
package com.mycomp.prodcons.framework.client;

import com.mycomp.prodcons.framework.event.util.EventUtils;

/**
 * @author ashok
 *
 */
public class EventSimulator {

	public static void simulateEvent(String actionEventName, Object eventObject) {

		System.out.println("Starting Event execution " + actionEventName + " Event " + eventObject.hashCode());
		try {

			Thread.sleep(EventUtils.getRandomInteger());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Completed Event execution " + actionEventName + " Event " + eventObject.hashCode());
	}

	public static void simulateUndo(String actionEventName, Object eventObject) {

		System.out.println("Starting Event Undo " + actionEventName + " Event " + eventObject.hashCode());
		try {

			Thread.sleep(EventUtils.getRandomInteger());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Completed Event Undo " + actionEventName + " Event " + eventObject.hashCode());
	}

}
