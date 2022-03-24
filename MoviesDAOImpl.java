package com.mindtree.feb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.mindtree.feb.dto.MoviesDTO;

// to give implementation for the methods which are in interface

public class MoviesDAOImpl implements MoviesDAO {
	static Connection con;

// insert operation
	@Override
	public boolean insertMovie(MoviesDTO dto) {
		if (dto != null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "Sushsuh@1999");
				String sql = "insert into movie values(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setObject(1, dto.getMovieID());
				ps.setObject(2, dto.getMovieName());
				ps.setObject(3, dto.getMovieBudget());
				ps.setObject(4, dto.getLeadActor());
				ps.setObject(5, dto.getLeadActorfee());

				return ps.executeUpdate() > 0 ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return false;
	}

	// update operation

	@Override
	public boolean updateMovieBudgetByMovieName(String movieName, String budget) {
		if (movieName != null && budget != null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "Sushsuh@1999");

				String sql = "update movie set movieBudget = ? where movieName = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setObject(1, budget);
				ps.setObject(2, movieName);

				return ps.executeUpdate() > 0 ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	// delete operation

	@Override
	public boolean deleteMovieByMovieName(String movieName) {
		if (movieName != null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "Sushsuh@1999");

				String sql = "delete from movie where MovieName = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setObject(1, movieName);

				return ps.executeUpdate() > 0 ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	// to fetch all movie details

	@Override
	public Collection<MoviesDTO> getAllMovies() {
		MoviesDTO movies = null;
		Collection<MoviesDTO> moviesCol = new ArrayList<MoviesDTO>();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "Sushsuh@1999");

			String sql = "select * from movie";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				movies = new MoviesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				moviesCol.add(movies);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return moviesCol;
	}

	// to get a particular movie by id

	@Override
	public MoviesDTO getMovieByMovieID(int id) {
		MoviesDTO movies = null;
		if (id > 0) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "Sushsuh@1999");

				String sql = "select * from movie where Movieid = "+ id;
				PreparedStatement ps = con.prepareStatement(sql);
				//ps.setObject(1, id);

				ResultSet rs = ps.executeQuery(sql);
				
				while (rs.next()) {
					movies = new MoviesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5));
				}
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return movies;
	}

}
