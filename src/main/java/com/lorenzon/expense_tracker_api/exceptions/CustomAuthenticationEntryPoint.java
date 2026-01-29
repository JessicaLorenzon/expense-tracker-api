package com.lorenzon.expense_tracker_api.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lorenzon.expense_tracker_api.exceptions.dto.ProblemDetailsDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ProblemDetailsDTO detailsDTO = new ProblemDetailsDTO(
                HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized",
                "User unauthorized",
                "https://expense-tracker-api.com/errors/user-unauthorized",
                request.getRequestURI()
        );

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write(
                new ObjectMapper().writeValueAsString(detailsDTO)
        );
    }
}
