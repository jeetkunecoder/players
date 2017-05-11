package com.admios.players.model;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

public class Player {
	
	public static final String PLAYER_NAME = "name";
	
	@MongoId
	@MongoObjectId
	private String id;
	private String name;
	private int age;
	private String position;
	private String skill;
	
	public Player() {}
	
	public Player(String name, int age, String position, String skill) {
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.skill = skill;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
