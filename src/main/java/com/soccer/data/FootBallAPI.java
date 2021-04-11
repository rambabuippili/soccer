package com.soccer.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.soccer.config.SoccerConfig;
import com.soccer.model.Country;
import com.soccer.model.League;
import com.soccer.model.Standings;
import com.soccer.model.Team;

@Service
public class FootBallAPI {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private SoccerConfig footBallAPIConfig;

	public List<Country> getCountries() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(footBallAPIConfig.getHost())
				.queryParam("action", footBallAPIConfig.getCountries()).queryParam("APIkey", footBallAPIConfig.getKey());

		ResponseEntity<List<Country>> countries = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Country>>() {
				});

		return countries.getBody();
	}

	public List<League> getLeageForCountry(String country) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(footBallAPIConfig.getHost())
				.queryParam("action", footBallAPIConfig.getLeagues()).queryParam("country_id", country)
				.queryParam("APIkey", footBallAPIConfig.getKey());

		ResponseEntity<List<League>> leagues = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<League>>() {
				});

		return leagues.getBody();
	}

	public List<Standings> getStandingForCountry(String league) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(footBallAPIConfig.getHost())
				.queryParam("action", footBallAPIConfig.getStandings()).queryParam("league_id", league)
				.queryParam("APIkey", footBallAPIConfig.getKey());

		ResponseEntity<List<Standings>> countries = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Standings>>() {
				});

		return countries.getBody();
	}

	public List<League> getLeagues() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(footBallAPIConfig.getHost())
				.queryParam("action", footBallAPIConfig.getLeagues()).queryParam("APIkey", footBallAPIConfig.getKey());

		ResponseEntity<List<League>> countries = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<League>>() {
				});

		return countries.getBody();

	}

	public List<Team> getTeamsForLeague(String league_id) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(footBallAPIConfig.getHost())
				.queryParam("action", footBallAPIConfig.getTeams()).queryParam("league_id", league_id)
				.queryParam("APIkey", footBallAPIConfig.getKey());

		ResponseEntity<List<Team>> leagues = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Team>>() {
				});

		return leagues.getBody();
	}
}
