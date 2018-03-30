package mapper;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import soap.ws.Key;

import java.util.Date;

/**
 * Created by kernel32 on 30.03.2018.
 */
public class KeyMapper {
    public static Key toBean(DBObject item){
        String name = (String)item.get("name");
        Date from = (Date)item.get("from");
        Date to = (Date)item.get("to");
        return new Key(name, from, to);
    }
    public static DBObject toDBObject(Key item){
        DBObject obj = new BasicDBObject();
        obj.put("name", item.getName());
        obj.put("from", item.getFrom());
        obj.put("to", item.getEnd());
        return obj;
    }
}
