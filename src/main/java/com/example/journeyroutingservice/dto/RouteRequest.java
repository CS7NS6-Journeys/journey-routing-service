package com.example.journeyroutingservice.dto;



public class RouteRequest {
    private double originLat;
    private double originLng;
    private double destinationLat;
    private double destinationLng;

    public double getOriginLat() { return originLat; }
    public void setOriginLat(double originLat) { this.originLat = originLat; }

    public double getOriginLng() { return originLng; }
    public void setOriginLng(double originLng) { this.originLng = originLng; }

    public double getDestinationLat() { return destinationLat; }
    public void setDestinationLat(double destinationLat) { this.destinationLat = destinationLat; }

    public double getDestinationLng() { return destinationLng; }
    public void setDestinationLng(double destinationLng) { this.destinationLng = destinationLng; }
}
