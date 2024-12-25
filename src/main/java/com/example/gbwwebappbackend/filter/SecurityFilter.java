package com.example.gbwwebappbackend.filter;

import com.example.gbwwebappbackend.service.auth.JwtService;
import com.example.gbwwebappbackend.service.user.UserService;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserService userService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        try {
            String authorization = request.getHeader("authorization");

            if (authorization == null || !authorization.startsWith("Bearer ")) {

                filterChain.doFilter(request, response);

                return;
            }

            String token = authorization.substring(7);

            // validate token
            Jws<Claims> claimsJws = jwtService.validateToken(token);
            Claims payload = claimsJws.getPayload();
            List<SimpleGrantedAuthority> authorities =
                    payload.get("authorities", ArrayList.class)
                            .stream()
                            .map((authority) -> new SimpleGrantedAuthority((String) authority))
                            .toList();

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userService.findByUsername(payload.getSubject()),
                            null,
                            authorities
                    );


            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            sendError(response, "Token invalid");
            return;
        }

            filterChain.doFilter(request, response);


    }

    private void sendError(HttpServletResponse resp, String msg)  {
        resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        resp.setContentType("application/json");



        try {
            resp.getWriter().write("""
                    {
                    "errors": "%s"
                    }
                    """.formatted(msg));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
