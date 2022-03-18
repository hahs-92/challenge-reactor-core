package com.example.service;

import com.example.demo.CsvUtilFile;
import com.example.demo.Player;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;


public class PlayerService2 {

    public Flux<Player> getPlayersGreaterThan34Age() {
        List<Player> players = CsvUtilFile.getPlayers();

        return Flux.fromIterable(players)
                .filter(p -> p.getAge() > 34);
    }

    public Flux<Player> getPlayerByClub(String club) {
        List<Player> players = CsvUtilFile.getPlayers();

        return Flux.fromIterable(players)
                .filter(p -> Objects.equals(p.getClub(), club));
    }
}
