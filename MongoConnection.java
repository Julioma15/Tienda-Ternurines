/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.administration;
/**
 *
 * @author Usuario
 */
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class MongoConnection {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "Sylvanian_orders";
    private static final String COLLECTION_NAME = "orders";

    public static List<Object[]> fetchData() {
    List<Object[]> data = new ArrayList<>();

    try (MongoClient mongoClient = new MongoClient(HOST, PORT)) {
        System.out.println("Conexión exitosa a MongoDB");

        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        List<Document> documents = collection.find().into(new ArrayList<>());

        for (Document doc : documents) {
            String id = doc.getObjectId("_id").toString();
            String userName = doc.getString("user_name");
            String email = doc.getString("email");
            String phone = doc.getString("phone");
            List<Integer> itemsId = (List<Integer>) doc.get("items_id");
            String itemsStr = itemsId.toString();
            String status = doc.getString("status");
            String orderDate = doc.getString("order_date");

            data.add(new Object[]{id, userName, email, phone, itemsStr, status, orderDate});
        }

    } catch (Exception e) {
        System.err.println("Error al conectar a MongoDB: " + e.getMessage());
    }

    return data;
}

    public static List<Document> searchByItemName(int itemId) {
        List<Document> results = new ArrayList<>();

        try (MongoClient mongoClient = new MongoClient(HOST, PORT)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            results = collection.find(new Document("items_id", itemId)).into(new ArrayList<>());
        } catch (Exception e) {
            System.err.println("Error al buscar por ID de artículo: " + e.getMessage());
        }

        return results;
    }

    public static List<Document> searchByUserName(String userName) {
        List<Document> results = new ArrayList<>();

        try (MongoClient mongoClient = new MongoClient(HOST, PORT)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            // Usar una expresión regular para buscar nombres que contengan la subcadena
            results = collection.find(new Document("user_name", new Document("$regex", userName).append("$options", "i"))).into(new ArrayList<>());
        } catch (Exception e) {
            System.err.println("Error al buscar por nombre de usuario: " + e.getMessage());
        }

        return results;
}

    public static void eraseOrder(String orderId) {
        try (MongoClient mongoClient = new MongoClient(HOST, PORT)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            collection.deleteOne(new Document("_id", new ObjectId(orderId)));
        } catch (Exception e) {
            System.err.println("Error al eliminar la orden: " + e.getMessage());
        }
    }
}