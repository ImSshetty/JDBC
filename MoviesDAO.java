package com.mindtree.feb.dao;

import java.util.Collection;

import com.mindtree.feb.dto.MoviesDTO;

// to achieve abstraction

public interface MoviesDAO {

	boolean insertMovie(MoviesDTO dto);

	boolean updateMovieBudgetByMovieName(String movieName, String budget);

	boolean deleteMovieByMovieName(String movieName);

	Collection<MoviesDTO> getAllMovies();

	MoviesDTO getMovieByMovieID(int id);
}
