/**
 * 
 */
package com.mycomp.prodcons.framework.event;

import java.io.Serializable;

/**
 * @author ashok
 *
 */
public interface ActionEvent extends Serializable {
	
	public void execute();
	
	public void undo();
	
	public Object getState();

}
