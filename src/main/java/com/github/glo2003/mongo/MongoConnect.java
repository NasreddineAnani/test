package com.github.glo2003.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MongoConnect {

    private MongoClient client;
    private Morphia morphia;
    private Datastore datastore;

    private static MongoConnect mongoConnectInstance = new MongoConnect();

    private final String dbName = "otto-schedule";

    public MongoConnect() {
    }

    public MongoClient getClient() {
        if (client == null) {

            MongoClientURI uri;
            uri = new MongoClientURI(String.format("mongodb://%s:%s@%s:%s/%s",
                    System.getenv("MONGO_USER"), System.getenv("MONGO_PASSWORD"), System.getenv("MONGO_HOST"),
                    System.getenv("MONGO_PORT"), System.getenv("MONGO_DATABASE")));


            client = new MongoClient(uri);
        }
        return client;
    }

    public Morphia getMorphia() {
        if (morphia == null) {
            morphia = new Morphia();
            morphia.mapPackage("com.github.glo2003.response");
        }
        return morphia;
    }

    public Datastore getDatastore() {
        if (datastore == null) {
            datastore = getMorphia().createDatastore(getClient(), dbName);
        }
        return datastore;
    }

    public static MongoConnect getInstance() {
        return mongoConnectInstance;
    }
}
