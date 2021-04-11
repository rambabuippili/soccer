package com.soccer;

import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.soccer.model.StandingDetails;
import com.soccer.service.SoccerService;

@SpringBootTest
class SoccerApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private SoccerService service;

	@Test
	public void stndingsTest() throws Exception {
		StandingDetails model = new StandingDetails();
		Mockito.when(service.getStandings("England", "Championship", "Bournemouth")).thenReturn(model);
		assertTrue(Objects.nonNull(model));
	}
}
