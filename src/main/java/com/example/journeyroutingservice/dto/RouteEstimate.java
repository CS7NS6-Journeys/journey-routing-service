package com.example.journeyroutingservice.dto;



public class RouteEstimate {
    private double distanceKm;
    private int estimatedTimeMinutes;
    // Encoded polyline representing the route geometry
    private String geometry;

    public RouteEstimate() {}

    public RouteEstimate(double distanceKm, int estimatedTimeMinutes, String geometry) {
        this.distanceKm = distanceKm;
        this.estimatedTimeMinutes = estimatedTimeMinutes;
        this.geometry = geometry;
    }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }

    public int getEstimatedTimeMinutes() { return estimatedTimeMinutes; }
    public void setEstimatedTimeMinutes(int estimatedTimeMinutes) { this.estimatedTimeMinutes = estimatedTimeMinutes; }

    public String getGeometry() { return geometry; }
    public void setGeometry(String geometry) { this.geometry = geometry; }
}
