package com.example.journeyroutingservice.dto;

import java.util.List;

public class OSRMResponse {
    private String code;
    private List<Route> routes;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public List<Route> getRoutes() { return routes; }
    public void setRoutes(List<Route> routes) { this.routes = routes; }

    public static class Route {
        private double distance; // in meters
        private double duration; // in seconds
        private String geometry; // encoded polyline

        public double getDistance() { return distance; }
        public void setDistance(double distance) { this.distance = distance; }

        public double getDuration() { return duration; }
        public void setDuration(double duration) { this.duration = duration; }

        public String getGeometry() { return geometry; }
        public void setGeometry(String geometry) { this.geometry = geometry; }
    }
}
