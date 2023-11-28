package com.example.firstapp.model;

public class Product {
    private int id;
    private String image;
    private String name;
    private double price;
    private Double rating;

    public Product(int id, String image, String name, double price, double rating) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.price = rating;
    }
}
