package com.rolence.couchbase.persistence.provider.couchbase.server;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Bucket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

import com.couchbase.client.java.Bucket;

@Configuration
public class CouchbaseServerPersistenceProvider {
	static final String COUCHBASE_SERVER_HOST_NAME = "127.0.0.1";
	static final String COUCHBASE_SERVER_BUCKET_NAME = "course";
	static final String COUCHBASE_SERVER_BUCKET_PASS = "admin123";
	
	@Bean
	public Bucket getBucket() {
		Bucket secureBucket = null;
		
		Cluster cluster = CouchbaseCluster.create(Arrays.asList(COUCHBASE_SERVER_HOST_NAME));
		
		if(COUCHBASE_SERVER_BUCKET_PASS.isEmpty()) {
			secureBucket = cluster.openBucket(COUCHBASE_SERVER_BUCKET_NAME, 30L, TimeUnit.SECONDS);
		}
		else {
			secureBucket = cluster.openBucket(COUCHBASE_SERVER_BUCKET_NAME, COUCHBASE_SERVER_BUCKET_PASS, 30L, TimeUnit.SECONDS);
		}
		return secureBucket;
	}
}
