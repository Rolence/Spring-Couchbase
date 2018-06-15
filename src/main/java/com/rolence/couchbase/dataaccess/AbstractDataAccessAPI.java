package com.rolence.couchbase.dataaccess;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.rolence.couchbase.dataaccess.factory.DataAccessFactory;
import com.rolence.couchbase.dataaccess.factory.DataAccessFactory.SupportedDatabase;

//import com.couchbase.dataaccess.factory.DataAccessFactory;
//import com.couchbase.dataaccess.factory.DataAccessFactory.SupporedDatabase;

public abstract class AbstractDataAccessAPI implements DataAccessAPI
{

   @Autowired
   DataAccessFactory dataAccessFactory;

   /**
    * @return SupporedDatabase
    */
   public abstract SupportedDatabase type();

   /**
    * @return void
    */
   @PostConstruct
   public void registerBean()
   {
      dataAccessFactory.register(type(), this);
   }
}