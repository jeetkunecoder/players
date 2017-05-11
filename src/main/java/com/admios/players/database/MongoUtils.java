package com.admios.players.database;

import com.mongodb.MongoClient;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoUtils {

	public static String filterToString(Bson filter) {
		return filter.toBsonDocument(Document.class, MongoClient.getDefaultCodecRegistry()).toJson();
	}
}
