package dao;

import com.mongodb.*;
import factory.ConnectionFactory;
import soap.ws.Key;
import mapper.KeyMapper;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KeyDao {

	public List<Key> getAllKeys() throws UnknownHostException {
		List<Key> keyList = new ArrayList<>();
		DB database = ConnectionFactory.getConnection().getDatabase();
		Set<String> collectionNames = database.getCollectionNames();
		for (String item : collectionNames){
			DBCursor cursor = database.getCollection(item).find();
			if(cursor.hasNext()){
				BasicDBObject obj = (BasicDBObject) cursor.next();
				keyList.add(KeyMapper.toBean(obj));
				cursor.close();
			}
		}
		return keyList;
	}

	public Key getKey(String keyValue) throws UnknownHostException {
		DB database = ConnectionFactory.getConnection().getDatabase();
		DBCollection collection = database.getCollection(keyValue);
		DBObject result = collection.findOne();
		Key item = KeyMapper.toBean(result);
		return  item;
	}

	public int addKey(Key item) throws UnknownHostException {
		DB database = ConnectionFactory.getConnection().getDatabase();
		DBCollection collection = database.getCollection(item.getName());
		DBObject obj = KeyMapper.toDBObject(item);
		try{
			collection.insert(obj);
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public int updateKey(Key item) throws UnknownHostException {
		DB database = ConnectionFactory.getConnection().getDatabase();
		DBCollection collection = database.getCollection(item.getName());
		DBObject result = collection.findOne();
		DBObject obj = KeyMapper.toDBObject(item);
		try{
			collection.update(result, obj);
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public int deleteKey(String keyValue) throws UnknownHostException {
		DB database = ConnectionFactory.getConnection().getDatabase();
		DBCollection collection = database.getCollection(keyValue);
		try{
			collection.drop();
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
}