package com.andrewsdosreis.rockpaperscissors.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.repository.RoundRepository;

public class RoundDataSource implements RoundRepository {
    
    private Map<String, List<Round>> data = new ConcurrentHashMap<>();

    @Override
    public void save(String key, Round round) {
        List<Round> rounds = find(key);
        rounds.add(round);
        data.merge(key, rounds, (v1, v2) -> v1 = v2);
    }

    @Override
    public List<Round> find(String key) {
        return data.getOrDefault(key, new ArrayList<>());
    }

    @Override
    public void delete(String key) {
        data.remove(key);
    }
}
