package com.soccer.service;



import java.util.List;

import com.soccer.model.Country;
import com.soccer.model.StandingDetails;
import com.soccer.model.League;
import com.soccer.model.Team;

public interface SoccerService {
	public StandingDetails getStandings(String countryName, String leagueName, String teamName);
	
	public List<Country> getCountries();
	public List<League> getLeagues(String countryName);
	public List<Team> getTeams(String countryName);
}
