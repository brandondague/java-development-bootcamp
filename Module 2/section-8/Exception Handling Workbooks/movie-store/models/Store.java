package models;

import java.util.ArrayList;

public class Store {

    private ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public void action(String name, String action) {
        if (this.movies.isEmpty()) {
            throw new IllegalStateException("store is empty cannot execute an action");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        if (!action.equalsIgnoreCase("sell") && !action.equalsIgnoreCase("rent") && !action.equalsIgnoreCase("return")) {
            throw new IllegalArgumentException("actions can only be sell/rent/return");
        }
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                if (action.equalsIgnoreCase("sell")) {
                    if (movie.isAvailable()) {
                        this.movies.remove(movie);
                        break;
                    } else {
                        throw new IllegalStateException("cannot sell movie that is already rented");
                    }
                }
                if (action.equalsIgnoreCase("rent")) {
                    if (movie.isAvailable()) {
                        movie.setAvailable(false);
                        break;
                    }
                }
                if (action.equalsIgnoreCase("return")) {
                    if (!movie.isAvailable()) {
                        movie.setAvailable(true);
                        break;
                    }
                }
                System.out.println("That action is not available at this time.");
            }
        }
    }

    public String toString() {
        String temp = "";
        for (Movie movie : movies) {
            temp += movie.toString();
            temp += "\n\n";
        }
        return temp;
    }
}
