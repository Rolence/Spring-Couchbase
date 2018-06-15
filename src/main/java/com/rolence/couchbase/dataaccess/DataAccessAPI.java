package com.rolence.couchbase.dataaccess;

public interface DataAccessAPI {
	public String save(String object)throws Exception;
	public void delete(String documentId)throws Exception;
	public Long getAutoIncrementedValue() throws Exception;
	public String getFilteredResultsById(String id)throws Exception;
}
