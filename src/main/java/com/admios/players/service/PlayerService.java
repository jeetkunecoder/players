package com.admios.players.service;

import static com.admios.players.model.Player.PLAYER_NAME;
import static com.mongodb.client.model.Filters.eq;
import static com.admios.players.database.MongoUtils.filterToString;

import com.admios.players.database.MongoRepository;
import com.admios.players.model.Player;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PlayerService {

	private static final String COLLECTION = "players";
	
	@Autowired
	private MongoRepository repository;
	private MongoCollection players;
	
	@PostConstruct
	public void init() { players = repository.getCollection(COLLECTION); }
	
	public Player registerPlayer (Player player) {
		player.setId(null);
		Player dbPlayer = findPlayerByName(player.getName());
		
		if(dbPlayer == null) {
			players.save(player);
		} else {
			players.update(new ObjectId(dbPlayer.getId())).with(player);
			player.setId(dbPlayer.getId());
		}
		return player;
	}
	
	public Player findPlayerById(String id) { return players.findOne(new ObjectId(id)).as(Player.class); }
	
	public Player findPlayerByName(String name) {
		return players.findOne(filterToString(eq(PLAYER_NAME, name))).as(Player.class);
	}

	public boolean deleteCompany(String name) {
		Player player = findPlayerByName(name);
		if (player != null) {
			players.remove(new ObjectId(player.getId()));
			return true;
		}
		return false;
	}
}
