package com.example.firstapp.model;

public class Rating {
    private String nameFood;
    private String imageFood;
    private String avatar;
    private String name;
    private Double rating;
    private String review;

    public Rating(String nameFood, String imageFood, String avatar, String name, Double rating, String review) {
        this.nameFood = nameFood;
        this.imageFood = imageFood;
        this.avatar = avatar;
        this.name = name;
        this.rating = rating;
        this.review = review;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getImageFood() {
        return imageFood;
    }

    public void setImageFood(String imageFood) {
        this.imageFood = imageFood;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
