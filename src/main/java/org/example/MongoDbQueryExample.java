package org.example;

import com.mongodb.client.*;

import org.bson.Document;

import javax.print.Doc;

public class MongoDbQueryExample {
    public static void exampleRunner() {
        String connectionString = "mongodb://root:examplepass@localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("the_hello_world_collection");

            Document filter = new Document("special_message", "Hello!");

            FindIterable<Document> documents = collection.find(filter);

            for (Document document : documents) {
                System.out.println(document.toJson());
            }

            System.out.println("finished");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
