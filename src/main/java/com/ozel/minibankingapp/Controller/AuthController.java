package com.ozel.minibankingapp.Controller;
import com.ozel.minibankingapp.Dto.LoginRequestDto;
import com.ozel.minibankingapp.Dto.LoginResponseDto;
import com.ozel.minibankingapp.Dto.RegisterDto;
import com.ozel.minibankingapp.Service.Interface.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Tag(name = "Auth Controller")
public class AuthController {
  private final IAuthService authService;

  @Operation(summary = "Login with username and password")
  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
    return new ResponseEntity<>(authService.login(loginRequestDto), HttpStatus.OK);
  }
  @Operation(summary = "Register with username, password and email")
  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
    return authService.register(registerDto);
  }
}