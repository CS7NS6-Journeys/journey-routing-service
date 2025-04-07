package com.example.journeyroutingservice.controller;

import com.example.journeyroutingservice.dto.RouteEstimate;
import com.example.journeyroutingservice.dto.RouteRequest;
import com.example.journeyroutingservice.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/estimate")
    public ResponseEntity<RouteEstimate> estimateRoute(@RequestBody RouteRequest request) {
        RouteEstimate estimate = routeService.estimateRoute(request);
        return ResponseEntity.ok(estimate);
    }
}
