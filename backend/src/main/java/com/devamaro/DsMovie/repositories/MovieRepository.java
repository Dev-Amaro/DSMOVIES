package com.devamaro.DsMovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devamaro.DsMovie.entitis.Movies;

public interface MovieRepository extends JpaRepository<Movies, Long> {

}
