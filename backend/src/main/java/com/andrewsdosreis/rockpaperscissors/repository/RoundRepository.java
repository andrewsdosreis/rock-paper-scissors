package com.andrewsdosreis.rockpaperscissors.repository;

import java.util.List;

import com.andrewsdosreis.rockpaperscissors.model.Round;

import org.springframework.stereotype.Repository;

@Repository("roundRepository")
public interface RoundRepository {

    void save(String key, Round round);

    List<Round> find(String key);

    void delete(String key);

}
