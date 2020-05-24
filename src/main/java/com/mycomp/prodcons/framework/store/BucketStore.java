/**
 * 
 */
package com.mycomp.prodcons.framework.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mycomp.prodcons.framework.vo.Bucket;

/**
 * @author ashok
 *
 */
public class BucketStore {
	
	private BucketStore store;
	
	private Map<String, Bucket> mapBuckets = new ConcurrentHashMap<String, Bucket>();
	
	private static class BucketStoreHelper{
		private static BucketStore store = new BucketStore();
	}
	
	//Hiding Constructor
	private BucketStore()
	{
		
	}
	
	private static BucketStore getInstance()
	{
		return BucketStoreHelper.store;
	}
	
	public Bucket fetchBucket(String bucketKey) {
		
		return mapBuckets.get(bucketKey);
	}
	
	public Bucket putBucket(Bucket bucket)
	{
		return mapBuckets.put(bucket.getBucketId(), bucket);
	}
	
	
	public boolean isBucketAvailable(String bucketKey)
	{
		return mapBuckets.containsKey(bucketKey);
	}

}
