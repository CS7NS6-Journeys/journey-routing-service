package com.example.journeyroutingservice.service;


import com.example.journeyroutingservice.dto.OSRMResponse;
import com.example.journeyroutingservice.dto.RouteEstimate;
import com.example.journeyroutingservice.dto.RouteRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RouteService {

    private final WebClient webClient;

    public RouteService(@Value("${routing.osrm.base-url}") String osrmBaseUrl, WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(osrmBaseUrl).build();
    }

    public RouteEstimate estimateRoute(RouteRequest request) {
        // OSRM API: Coordinates are in lon,lat order.
        // 'overview=full' returns the full geometry, and 'geometries=polyline' returns an encoded polyline.
        String urlTemplate = "/route/v1/driving/{lon1},{lat1};{lon2},{lat2}?overview=full&geometries=polyline";

        Mono<OSRMResponse> responseMono = webClient.get()
                .uri(urlTemplate,
                        request.getOriginLng(), request.getOriginLat(),
                        request.getDestinationLng(), request.getDestinationLat())
                .retrieve()
                .bodyToMono(OSRMResponse.class);

        // Block for simplicity (in production, consider a reactive approach)
        OSRMResponse osrmResponse = responseMono.block();
        if (osrmResponse != null && "Ok".equals(osrmResponse.getCode()) &&
                osrmResponse.getRoutes() != null && !osrmResponse.getRoutes().isEmpty()) {
            OSRMResponse.Route osrmRoute = osrmResponse.getRoutes().get(0);
            double distanceKm = osrmRoute.getDistance() / 1000.0;
            int estimatedTimeMinutes = (int) Math.ceil(osrmRoute.getDuration() / 60.0);
            String geometry = osrmRoute.getGeometry();
            return new RouteEstimate(distanceKm, estimatedTimeMinutes, geometry);
        } else {
            throw new IllegalStateException("Failed to obtain a route estimate from OSRM.");
        }
    }
}
