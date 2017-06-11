package ru.ifmo.pashaac.gsgpandroid.entity;

/**
 * Created by Pavel Asadchiy
 * on 22:34 06.05.17.
 */
public class Marker {

    private double latitude;
    private double longitude;

    public Marker(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Marker() {
        this(0.0, 0.0);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
