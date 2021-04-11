package com.soccer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("football-api")
public class SoccerConfig {
	private String host;
	private String key;
	private String countries;
	private String leagues;
	private String teams;
	private String standings;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCountries() {
		return countries;
	}
	public void setCountries(String countries) {
		this.countries = countries;
	}
	public String getLeagues() {
		return leagues;
	}
	public void setLeagues(String leagues) {
		this.leagues = leagues;
	}
	public String getTeams() {
		return teams;
	}
	public void setTeams(String teams) {
		this.teams = teams;
	}
	public String getStandings() {
		return standings;
	}
	public void setStandings(String standings) {
		this.standings = standings;
	}

	
}
