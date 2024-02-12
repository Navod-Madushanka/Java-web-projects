package middleware;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import util.JwtTokenUtil;

import java.io.IOException;

public class JwtValidationFilter implements ContainerRequestFilter {
    @Inject
    private JwtTokenUtil tokenUtil;
    @Context
    private HttpServletRequest request;
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("JWTValidationFilter");
    }
}
