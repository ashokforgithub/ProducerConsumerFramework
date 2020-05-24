/**
 * 
 */
package com.mycomp.prodcons.framework.vo;

import java.nio.file.Path;
import java.util.Set;

/**
 * @author ashok
 *
 */
public class Bucket {
	
	private String bucketId;
	
	private Set<Path> files;
	
	
	

	/**
	 * @param bucketId
	 * @param files
	 */
	public Bucket(String bucketId, Set<Path> files) {
		super();
		this.bucketId = bucketId;
		this.files = files;
	}

	/**
	 * @return the bucketId
	 */
	public String getBucketId() {
		return bucketId;
	}

	/**
	 * @param bucketId the bucketId to set
	 */
	public void setBucketId(String bucketId) {
		this.bucketId = bucketId;
	}

	/**
	 * @return the files
	 */
	public Set<Path> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(Set<Path> files) {
		this.files = files;
	}
	
	

}
