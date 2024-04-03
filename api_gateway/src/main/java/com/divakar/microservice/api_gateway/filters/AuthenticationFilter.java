package com.divakar.microservice.api_gateway.filters;

import com.divakar.microservice.api_gateway.Error_Control.Exceptions.badCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>
{
    @Autowired
    private RouteValidator routeValidator;
    @Autowired
    private JwtService jwtService;
    public AuthenticationFilter()
    {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config)
    {
        return ((exchange, chain) ->
        {
            if(routeValidator.isSecured.test(exchange.getRequest()))
            {
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
                {
                    try {
                        throw new badCredentialsException("bad Credentials");
                    } catch (badCredentialsException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                String authHeader= exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(authHeader!=null && authHeader.startsWith("Bearer "))
                {
                    authHeader=authHeader.substring(7);
                }
                try
                {

                    jwtService.validateToken(authHeader);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

            }
            return chain.filter(exchange);
        });
    }

    public static class Config
    {

    }
}
