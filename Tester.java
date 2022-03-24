package com.mindtree.feb;

import java.util.Collection;
import java.util.Scanner;

import com.mindtree.feb.dao.MoviesDAO;
import com.mindtree.feb.dao.MoviesDAOImpl;
import com.mindtree.feb.dto.MoviesDTO;

public class Tester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MoviesDAO dao = new MoviesDAOImpl();

		int choice;
		String text;
		do {
			System.out.println("Enter 1 to insert");
			System.out.println("Enter 2 to update");
			System.out.println("Enter 3 to delete");
			System.out.println("Enter 4 to getAlldetails");
			System.out.println("Enter 5 to get movie by id");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the details to add");
				MoviesDTO dto = new MoviesDTO(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
				System.out.println(dao.insertMovie(dto));
				break;
			case 2:
				System.out.println("Enter the new budget and movie name to update");
				System.out.println(dao.updateMovieBudgetByMovieName(sc.next(), sc.next()));
				break;
			case 3:
				System.out.println("Enter a movie name to delete the details");
				System.out.println(dao.deleteMovieByMovieName(sc.next()));
				break;
			case 4:
				Collection<MoviesDTO> col = dao.getAllMovies();
				for (MoviesDTO moviesDTO : col) {
					System.out.println(moviesDTO);
				}
				break;
			case 5:
				System.out.println("Enter the movie id to fetch the details");
				System.out.println(dao.getMovieByMovieID(sc.nextInt()));
				break;

			default:
				System.out.println("Invalid choice");
			}
			System.out.println("Do you want to continue ? Y or N");
			text = sc.next();
		} while (text.equalsIgnoreCase("Y"));
		System.out.println("Thank you");

	}

}
