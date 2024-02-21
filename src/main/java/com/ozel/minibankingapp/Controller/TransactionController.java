package com.ozel.minibankingapp.Controller;
import com.ozel.minibankingapp.Dto.RetrieveTransactionDto;
import com.ozel.minibankingapp.Dto.TransferMoneyDto;
import com.ozel.minibankingapp.Service.Interface.ITransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@AllArgsConstructor
@Tag(name = "Transaction Controller")
public class TransactionController {
  private final ITransactionService transactionService;

  @Operation(summary = "Transfer money one account to another account for authenticated user")
  @PostMapping("/transfer")
  public ResponseEntity<RetrieveTransactionDto> transferMoney(HttpServletRequest request, @RequestBody TransferMoneyDto transferMoneyDto)
      throws Exception {
    return new ResponseEntity<>(transactionService.transferMoney(request.getRemoteUser(), transferMoneyDto), HttpStatus.OK);
  }

  @Operation(summary = "Get specific account history for authenticated user")
  @GetMapping("/account/{accountId}")
  public ResponseEntity<List<RetrieveTransactionDto>> retrieveHistory(HttpServletRequest request, @PathVariable UUID accountId) {

    return new ResponseEntity<>(transactionService.retrieveHistory(request.getRemoteUser(), accountId), HttpStatus.OK);
  }

}