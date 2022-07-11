package models;

public class Movie {

    private String name;
    private String format;
    private double rating;
    private boolean isAvailable;
    private String sellingPrice;
    private String rentalPrice;

    public Movie(String name, String format, double rating) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/empty");
        }
        if (!format.equalsIgnoreCase("blue-ray") && !format.equalsIgnoreCase("dvd")) {
            throw new IllegalArgumentException("format must be 'blue-ray' or 'dvd'");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("rating must be between 0 and 10");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.sellingPrice = (format.equalsIgnoreCase("blue-ray")) ? "$4.25" : "$2.25";
        this.rentalPrice = (format.equalsIgnoreCase("blue-ray")) ? "$1.99" : "$0.99";
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.isAvailable = source.isAvailable;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public String getRentalPrice() {
        return rentalPrice;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/empty");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if (!format.equalsIgnoreCase("blue-ray") && !format.equalsIgnoreCase("dvd")) {
            throw new IllegalArgumentException("format must be 'blue-ray' or 'dvd'");
        }
        this.format = format;
        setSellingPrice(format);
        setRentalPrice(format);
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("rating must be between 0 and 10");
        }
        this.rating = rating;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    private void setSellingPrice(String format) {
        this.sellingPrice = (format.equalsIgnoreCase("blue-ray")) ? "$4.25" : "$2.25";
    }

    private void setRentalPrice(String format) {
        this.rentalPrice = (format.equalsIgnoreCase("blue-ray")) ? "$1.99" : "$0.99";
    }

    public String toString() {
        String availability = this.isAvailable ? "in-stock" : "rented";
        return "\t Name: " + this.name + "\n" +
               "\t Format: " + this.format + "\n" +
               "\t Rating: " + this.rating + "\n" +
               "\t Selling price: " + this.sellingPrice + "\n" +
               "\t Rental price: " + this.rentalPrice + "\n" +
               "\t Availability: " + availability + "\n";
    }
    
}
