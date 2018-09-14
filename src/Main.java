import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Iterator;

public class Main {

//            public static void main(String[] args) {
//
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("dbtest");
//        MongoCollection<Document> collection = mongoDatabase.getCollection("users");
//        for (int i = 0; i < 1000000; i++) {
//            Document document = new Document();
//            document.append("name", "white" + i);
//            document.append("age", i);
//            document.append("sex", i % 2);
//            document.append("money", i * 10);
//            // insert into users(....)
//            collection.insertOne(document);
//        }
//        mongoClient.close();
//    }

    public static void showData(Iterable result) {
        Integer i = 0;
        Iterator it = result.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println(i++);
        }
    }

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("dbtest");
        MongoCollection<Document> collection = db.getCollection("users");
//         select * from user
//        showData(collection.find());
        // select top 1 * from user where name = 'white11'
//        FindIterable<Document> age = collection.find(Filters.and(
//                Filters.eq("age", 88888),
//                Filters.eq("sex", 0)
//        ));
//        showData(age);
//         select * from user where age < 10
//        FindIterable<Document> age = collection.find(Filters.gte("age", 10));
//        showData(age);
        // select * from user where age>= 70 and age<=100
        showData(collection.find(Filters.and(Filters.lte("age", 100), Filters.gte("age", 70))));

        mongoClient.close();
    }

//    public static void main(String[] args) {
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("dbtest");
//        mongoDatabase.createCollection("user");
//    }
}
