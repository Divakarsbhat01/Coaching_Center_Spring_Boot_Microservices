package com.divakar.microservice.api_gateway.filters;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator
{
    public static final List<String> openApiEndpoints=List.of(
            "/security-service/user_login",
            "/user-details-service/status",
            "/user-details-service/UserDetails_Create",
            "/eureka"
    );
    public Predicate<ServerHttpRequest>isSecured=
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri->request.getURI().getPath().contains(uri));
}
