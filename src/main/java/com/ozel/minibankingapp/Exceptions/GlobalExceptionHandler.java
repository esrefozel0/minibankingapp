package com.ozel.minibankingapp.Exceptions;

import com.ozel.minibankingapp.Dto.ErrorDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(UserDoesNotExist.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(final UserDoesNotExist exception) {
        HttpStatus error = HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(
                ErrorDto.builder()
                        .withTitle("User Does Not Exists")
                        .withDetail(new ArrayList<>(List.of(exception.getMessage())))
                        .withStatus(error.value())
                        .withError(error.getReasonPhrase())
                        .withErrorCode(1001)
                        .build(),
                error
        );
    }

    @ExceptionHandler(UsersAccountDoesNotExist.class)
    public ResponseEntity<ErrorDto> handleUsersAccountNotFoundException(final UsersAccountDoesNotExist exception) {
        HttpStatus error = HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(
            ErrorDto.builder()
                .withTitle("Users Account Does Not Exists")
                .withDetail(new ArrayList<>(List.of(exception.getMessage())))
                .withStatus(error.value())
                .withError(error.getReasonPhrase())
                .withErrorCode(1002)
                .build(),
            error
        );
    }

    @ExceptionHandler(AccountDoesNotExist.class)
    public ResponseEntity<ErrorDto> handleAccountNotFoundException(final AccountDoesNotExist exception) {
        HttpStatus error = HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(
            ErrorDto.builder()
                .withTitle("Account Does Not Exists")
                .withDetail(new ArrayList<>(List.of(exception.getMessage())))
                .withStatus(error.value())
                .withError(error.getReasonPhrase())
                .withErrorCode(1003)
                .build(),
            error
        );
    }
}
