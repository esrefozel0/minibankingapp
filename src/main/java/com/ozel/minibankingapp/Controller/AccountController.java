package com.ozel.minibankingapp.Controller;
import com.ozel.minibankingapp.Dto.AccountRequestDto;
import com.ozel.minibankingapp.Dto.AccountResponseDto;
import com.ozel.minibankingapp.Dto.RetrieveAccountDto;
import com.ozel.minibankingapp.Dto.SearchAccountDto;
import com.ozel.minibankingapp.Exceptions.UserDoesNotExist;
import com.ozel.minibankingapp.Exceptions.UsersAccountDoesNotExist;
import com.ozel.minibankingapp.Service.Interface.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
@Tag(name = "Account Controller")
public class AccountController {

  private final IAccountService accountService;

  @Operation(summary = "Create a account for authenticated user")
  @PostMapping
  public ResponseEntity<AccountResponseDto> createAccount(HttpServletRequest request, @RequestBody AccountRequestDto accountRequestDto)
      throws UserDoesNotExist {

    AccountResponseDto accountResponseDto = accountService.createAccount(request.getRemoteUser(),
        accountRequestDto);
    return new ResponseEntity<>(accountResponseDto, HttpStatus.OK);
  }

  @Operation(summary = "Search accounts for authenticated user")
  @GetMapping()
  public ResponseEntity<List<RetrieveAccountDto>> searchAccount(HttpServletRequest request, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "number", required = false) String number)
      throws UserDoesNotExist {

    List<RetrieveAccountDto> retrieveAccountDtoList = accountService.searchAccount(request.getRemoteUser(),
        new SearchAccountDto(name, number));
    return new ResponseEntity<>(retrieveAccountDtoList, HttpStatus.OK);
  }

  @Operation(summary = "Update account for authenticated user")
  @PutMapping(value = "/{id}")
  public ResponseEntity<AccountResponseDto> updateAccount(HttpServletRequest request, @PathVariable UUID id, @RequestBody AccountRequestDto accountRequestDto)
      throws UsersAccountDoesNotExist, UserDoesNotExist {

    AccountResponseDto updateAccountResponseDto = accountService.updateAccount(request.getRemoteUser(), accountRequestDto, id);
    return new ResponseEntity<>(updateAccountResponseDto, HttpStatus.OK);
  }
  @Operation(summary = "Delete account for authenticated user")
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<String> deleteAccount(HttpServletRequest request, @PathVariable UUID id)
      throws UsersAccountDoesNotExist, UserDoesNotExist {

    String response = accountService.deleteAccount(request.getRemoteUser(), id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Operation(summary = "Retrieves details of a specific account for authenticated user")
  @GetMapping(value = "/{id}")
  public ResponseEntity<RetrieveAccountDto> retrieveAccount(HttpServletRequest request, @PathVariable UUID id)
      throws UsersAccountDoesNotExist, UserDoesNotExist {

    RetrieveAccountDto response = accountService.retrieveAccount(request.getRemoteUser(), id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}