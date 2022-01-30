package com.andrewsdosreis.rockpaperscissors.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.andrewsdosreis.rockpaperscissors.model.Round;
import com.andrewsdosreis.rockpaperscissors.repository.RoundRepository;

public class RoundDataSource implements RoundRepository {
    
    static RoundDataSource instance = null;
    private Map<String, List<Round>> data = new ConcurrentHashMap<>();

    private RoundDataSource() {
    }

    public static RoundDataSource getInstance() {
        if (instance == null) {
            instance = new RoundDataSource();
        }
        return instance;
    }

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

    @Override
    public Integer count(String key) {
        return find(key).size();
    }
}
