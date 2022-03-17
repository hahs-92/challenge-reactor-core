package com.example.repository;

import com.example.model.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPlayerRepository extends ReactiveCrudRepository<Player,String> {

    Flux<Player> findAllByName(int age);

}
