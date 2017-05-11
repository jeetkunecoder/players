package com.admios.players.controller;

import com.admios.players.config.PlayersApplication;
import com.admios.players.model.Player;
import com.admios.players.service.PlayerService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = PlayersApplication.API_V1, produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayersController {
	
	public static final String ENDPOINT = "players";
	
	@Autowired
	private PlayerService service;

	@ApiOperation(value = "Register a new player", nickname = "Register a new player",
			notes = "Endpoint to register a new player. If the player already exists, the info will be updated"
					+ " with the submitted data.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpEntity<Player> registerPlayer(final @Validated @RequestBody Player player) {
		return new ResponseEntity<>(service.registerPlayer(player), HttpStatus.OK);
	}

	@ApiOperation(value = "Find the player details", nickname = "Find the player details",
			notes = "It will retrieve the player details")
	@RequestMapping(value = ENDPOINT + "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<Player> getPlayerDetails(@PathVariable String name) {
		Player player = service.findPlayerByName(name);
		return new ResponseEntity<>(player, player != null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Delete the specified player", nickname = "Delete the specified player",
			notes = "It will delete the player specified in the request.")
	@RequestMapping(value = ENDPOINT + "/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	public HttpEntity<Void> deleteCompany(@PathVariable String name) {
		return new ResponseEntity<>(service.deleteCompany(name) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
}