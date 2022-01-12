package com.devamaro.DsMovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devamaro.DsMovie.dto.MovieDTO;
import com.devamaro.DsMovie.dto.ScoreDTO;
import com.devamaro.DsMovie.entitis.Movies;
import com.devamaro.DsMovie.entitis.Score;
import com.devamaro.DsMovie.entitis.User;
import com.devamaro.DsMovie.repositories.MovieRepository;
import com.devamaro.DsMovie.repositories.ScoreRepository;
import com.devamaro.DsMovie.repositories.UserRepository;

@Service
public class ScoreService {
	@Autowired
	private MovieRepository movierepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private ScoreRepository scorerepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userrepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userrepository.saveAndFlush(user);
		}
		
		Movies movies = movierepository.findById(dto.getMoveId()).get();
		
		Score score = new Score();
		score.setMovies(movies);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scorerepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movies.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movies.getScores().size();
		
		movies.setScore(avg);
		movies.setCount(movies.getScores().size());
		
		movies = movierepository.save(movies);
		
		return new MovieDTO(movies);
	}
}