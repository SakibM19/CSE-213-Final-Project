package com.example.cse213finalproject.sakibModelClass;

import java.io.Serializable;

public class FavouriteVehicle implements Serializable {
    private String favouriteID;

    public FavouriteVehicle(String favouriteID) {
        this.favouriteID = favouriteID;
    }

    public String getFavouriteID() {
        return favouriteID;
    }

    public void setFavouriteID(String favouriteID) {
        this.favouriteID = favouriteID;
    }

    public FavouriteVehicle() {
    }

    @Override
    public String toString() {
        return "FavouriteVehicle{" +
                "favouriteID='" + favouriteID + '\'' +
                '}';
    }
}
