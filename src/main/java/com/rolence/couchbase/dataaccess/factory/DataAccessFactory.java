package com.rolence.couchbase.dataaccess.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rolence.couchbase.dataaccess.DataAccessAPI;

@Component
public class DataAccessFactory {
	static Map<String, DataAccessAPI> supportedDatabase = new HashMap<>();
	
	public enum SupportedDatabase{
		COUCHBASESERVER
	}
	
	public void register(SupportedDatabase type, DataAccessAPI dataAccessAPI) {
		supportedDatabase.put(type.name(), dataAccessAPI);
	}
	
	public DataAccessAPI getPlatformDatabase() {
		String database = "COUCHBASESERVER";
		
		if(database.equalsIgnoreCase(SupportedDatabase.COUCHBASESERVER.name())) {
			return supportedDatabase.get(SupportedDatabase.COUCHBASESERVER.name());
		}
		return null;
	}
}
