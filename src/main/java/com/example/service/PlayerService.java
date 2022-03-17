package com.example.service;

import com.example.model.Player;
import com.example.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlayerService {
    @Autowired
    private IPlayerRepository iPlayerRepository;

    public Mono<Player> save(Player player) {
        return iPlayerRepository.save(player);
    }

    public Flux<Player> saveAll(Flux<Player> players) {
        return iPlayerRepository.saveAll(players);
    }

    public Flux<Player> getAll() {
        return iPlayerRepository.findAll();
    }

    public Mono<Player> getById(String id) {
        return iPlayerRepository.findById(id);
    }

    public Flux<Player> getPlayerGreaterThan35() {
        return iPlayerRepository.findAll()
                .filter(player -> player.getAge() > 35);
    }

    public Mono<Void> deleteById(String id) {
        return iPlayerRepository.deleteById(id);
    }

}
