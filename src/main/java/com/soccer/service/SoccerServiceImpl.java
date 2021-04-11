package com.soccer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccer.data.FootBallAPI;
import com.soccer.model.Country;
import com.soccer.model.League;
import com.soccer.model.StandingDetails;
import com.soccer.model.Standings;
import com.soccer.model.Team;

@Service
public class SoccerServiceImpl implements SoccerService {

	@Autowired
	private FootBallAPI footballApiService;

	@Override
	public StandingDetails getStandings(String countryName, String leagueName, String teamName) {
		StandingDetails standingDetails = new StandingDetails();
		try {
		
			Country country = findCountryByName(countryName);

			standingDetails.setCountryInfo(country.getCountryId()+"-"+country.getCountryName());
			

			League league = findLeagueByCountryId(country.getCountryId());

			standingDetails.setLeagueInfo(league.getLeagueId()+"-"+league.getLeagueName());

			List<Standings> standings = findStandingForTeam(league.getLeagueId());

			standings = standings.stream().filter(
					standing -> standing.getCountryName().equals(countryName) && standing.getTeamName().equals(teamName))
					.collect(Collectors.toList());

			Standings standing = standings.get(0);

			standingDetails.setTeamInfo(standing.getTeamId()+"-"+standing.getTeamName());
			standingDetails.setOverallPosition(standing.getOverallLeaguePosition());


		} catch (Exception e) {
			standingDetails.setTeamInfo("No Data found for this Request");
		}
		
		
		return standingDetails;
	}

	public Country findCountryByName(String name) {
		List<Country> allCountries = footballApiService.getCountries();

		Optional<Country> countryPrd = allCountries.stream().filter(country -> name.equals(country.getCountryName()))
				.findFirst();
		return countryPrd.isPresent() ? countryPrd.get() : null;
	}

	public League findLeagueByCountryId(String countryId) {
		List<League> allLeagues = footballApiService.getLeageForCountry(countryId);

		Optional<League> leaguePrd = allLeagues.stream().filter(league -> countryId.equals(league.getCountryId()))
				.findFirst();
		return leaguePrd.isPresent() ? leaguePrd.get() : null;
	}

	public List<League> findLeaguesByCountryId(String countryId) {
		List<League> allLeagues = footballApiService.getLeageForCountry(countryId);

		return allLeagues;
	}

	public List<Standings> findStandingForTeam(String leagueId) {
		return footballApiService.getStandingForCountry(leagueId);
	}

	@Override
	public List<League> getLeagues(String country_id) {
		// TODO Auto-generated method stub
		return footballApiService.getLeageForCountry(country_id);
	}

	@Override
	public List<Team> getTeams(String league_id) {
		// TODO Auto-generated method stub
		return footballApiService.getTeamsForLeague(league_id);
	}

	@Override
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		return footballApiService.getCountries();
	}

}
