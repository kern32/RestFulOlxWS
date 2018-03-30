package factory;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by kernel32 on 30.03.2018.
 */
public class ConnectionFactory {
   private static ConnectionFactory instance;
   private DB database;

   private ConnectionFactory() throws UnknownHostException {
       MongoClient client = new MongoClient( "185.65.246.6" , 27017 );
       database = client.getDB("keywords");
   }

   public static ConnectionFactory getConnection() throws UnknownHostException {
       ConnectionFactory localInstance = instance;
       if(localInstance == null){
           synchronized (ConnectionFactory.class){
               localInstance = instance;
               if(localInstance == null){
                   instance = localInstance = new ConnectionFactory();
               }
           }
       }
       return instance;
   }

    public DB getDatabase() {
        return database;
    }
}
