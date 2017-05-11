package com.admios.players.database;

import com.mongodb.DB;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MongoRepository {

	@Autowired
	private MongoDbFactory mongoDbFactory;
	private Jongo jongo;
	private DB db;
	
	@PostConstruct
	private void init() {
		db = mongoDbFactory.getDb();
		jongo = new Jongo(db);
	}
	
	public MongoCollection getCollection(String name) { return jongo.getCollection(name); }
}
