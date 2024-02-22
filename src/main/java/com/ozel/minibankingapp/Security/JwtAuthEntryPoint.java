package com.ozel.minibankingapp.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozel.minibankingapp.Dto.ErrorDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
  private final ObjectMapper objectMapper;

  @Override
  public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException {

    HttpStatus error = HttpStatus.UNAUTHORIZED;
    res.setContentType(MediaType.APPLICATION_JSON_VALUE);
    res.setStatus(error.value());

    ErrorDto errorDto = ErrorDto.builder()
        .withTitle("Authenticate Error")
        .withDetail(new ArrayList<>(List.of(authException.getMessage())))
        .withStatus(error.value())
        .withError(error.getReasonPhrase())
        .withErrorCode(1001)
        .build();

    objectMapper.writeValue(res.getOutputStream(), errorDto);
  }
}