package com.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soccer.model.Country;
import com.soccer.model.StandingDetails;
import com.soccer.model.League;
import com.soccer.model.Team;
import com.soccer.service.SoccerService;

@RestController
@RequestMapping("/soccer")
public class SoccerController {

	@Autowired
	SoccerService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/getCountries", produces = "application/JSON")
	public List<Country> getCountries() {
		return service.getCountries();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getLeagues", produces = "application/JSON")
	public List<League> getLeagues(@RequestParam String country_id) {
		return service.getLeagues(country_id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getTeams", produces = "application/JSON")
	public List<Team> getTeams(@RequestParam String league_id) {
		return service.getTeams(league_id);
	}
	

	@RequestMapping(method = RequestMethod.GET, path = "/standings", produces = "application/JSON")
	public StandingDetails getTeamStandings(@RequestParam String countryName, @RequestParam String leagueName,
			@RequestParam String teamName) {
		StandingDetails response = new StandingDetails();
		response = service.getStandings(countryName, leagueName, teamName);

		return response;
	}


}