package com.example.admin.starbuzzz.model;

public class Fruit {

    public String name;
    public boolean favourite;

    public Fruit(String name, boolean favourite) {
        this.name = name;
        this.favourite = favourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

}
