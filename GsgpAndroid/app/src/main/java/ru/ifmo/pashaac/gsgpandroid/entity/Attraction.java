package ru.ifmo.pashaac.gsgpandroid.entity;

/**
 * Created by Pavel Asadchiy
 * on 22:38 06.05.17.
 */
public class Attraction {

    private Long id;
    private String name;
    private String type;
    private String address;
    private double rating;
    private Marker location;

    public Attraction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Marker getLocation() {
        return location;
    }

    public void setLocation(Marker location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Attraction{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
