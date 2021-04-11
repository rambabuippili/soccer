package com.soccer.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Team {

	@JsonProperty("team_name")
	private String teamName;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	
	
}
