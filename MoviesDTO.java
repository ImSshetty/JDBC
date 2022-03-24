package com.mindtree.feb.dto;

public class MoviesDTO {
	// encapsulating parameters
	private int movieID;
	private String movieName;
	private String movieBudget;
	private String leadActor;
	private String leadActorfee;
	
// to assign values for these parameter
	
	public MoviesDTO(int movieID, String movieName, String movieBudget, String leadActor, String leadActorfee) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
		this.movieBudget = movieBudget;
		this.leadActor = leadActor;
		this.leadActorfee = leadActorfee;
	}
	
	// to makes the class as read only write only

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieBudget() {
		return movieBudget;
	}

	public void setMovieBudget(String movieBudget) {
		this.movieBudget = movieBudget;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	public String getLeadActorfee() {
		return leadActorfee;
	}

	public void setLeadActorfee(String leadActorfee) {
		this.leadActorfee = leadActorfee;
	}

	// to print these parameters accordingly
	
	@Override
	public String toString() {
		return "MoviesDTO [movieID=" + movieID + ", movieName=" + movieName + ", movieBudget=" + movieBudget
				+ ", leadActor=" + leadActor + ", leadActorfee=" + leadActorfee + "]";
	}

}
