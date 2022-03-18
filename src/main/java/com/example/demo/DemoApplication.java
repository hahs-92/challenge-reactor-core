package com.example.demo;

import com.example.service.PlayerService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PlayerService2 service2 = new PlayerService2();

		//obtener jugadores menores de 34 años
		service2.getPlayersGreaterThan34Age()
				.subscribe(p -> log.info("[JUGADORES MAYORES DE 34 AÑOS]: " + p.toString()));

		//obtener jugadores por club
		service2.getPlayerByClub("FC Barcelona")
				.subscribe(p -> log.info("[JUGADORES POR CLUB]: " + p));

		//obter nacionalidades
		service2.getNationalities()
				.subscribe(n -> log.info("[NATIONALITIES]: " + n));

		//obtener jugadores por nacionalidad
		service2.getPlayersByNationality("Colombia")
				.subscribe(p -> log.info("[JUGADORES POR NACIONALIDAD]: " + p.toString()));

		//obtener los 10 jugadores mas ganadores por nacionalidad
		service2.getTopTenWinnersByNationality("Colombia")
				.subscribe(p -> log.info("[WINNERS_BY_NATIONALITY: ]" + p.toString()));


		//obtener los 10 jugadores mas ganadores
		service2.getTopTenWinners()
				.subscribe(p -> log.info("[WINNERS: ]" + p.toString()));


	}
}
