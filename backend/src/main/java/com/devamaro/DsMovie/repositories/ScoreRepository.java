package com.devamaro.DsMovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devamaro.DsMovie.entitis.Score;
import com.devamaro.DsMovie.entitis.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
