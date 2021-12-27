package info.behzadian.port.outbound.client.bankservice;

import info.behzadian.dto.card.auth.CardAuthenticateCommand;
import info.behzadian.dto.card.auth.CardAuthenticateResponse;
import info.behzadian.dto.card.balance.CardBalanceCommand;
import info.behzadian.dto.card.balance.CardBalanceResponse;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodCommand;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodResponse;
import info.behzadian.dto.card.deposit.DepositCommand;
import info.behzadian.dto.card.transactions.CardTransactionsCommand;
import info.behzadian.dto.card.transactions.CardTransactionsResponse;
import info.behzadian.dto.card.verify.CardVerificationCommand;
import info.behzadian.dto.card.verify.CardVerificationResponse;
import info.behzadian.dto.card.withdraw.WithdrawCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@FeignClient("bank-service-api")
public interface BankServiceClient {

    /**
     *
     * @param command
     * @return
     */
    @RequestMapping(value = "/v1/card/verify", method = GET)
    ResponseEntity<CardVerificationResponse> verifyCard(@SpringQueryMap CardVerificationCommand command);

    /**
     *
     * @param command
     * @return
     */
    @RequestMapping(value = "/v1/card/authenticate", method = GET)
    ResponseEntity<CardAuthenticateResponse> authenticateCard(@SpringQueryMap CardAuthenticateCommand command);

    /**
     *
     * @param command
     * @return
     */
    @RequestMapping(value = "/v1/card/balance", method = GET)
    ResponseEntity<CardBalanceResponse> balance(@SpringQueryMap CardBalanceCommand command);

    /**
     *
     * @param command
     * @return
     */
    @RequestMapping(value = "/v1/card/change-auth-method", method = PUT)
    ResponseEntity<CardChangeAuthenticationMethodResponse> changeAuthMethod(@RequestBody CardChangeAuthenticationMethodCommand command);

    /**
     *
     * @param command
     * @return
     */
    @RequestMapping(value = "/v1/card/transactions", method = GET)
    ResponseEntity<CardTransactionsResponse> transactions(@SpringQueryMap CardTransactionsCommand command);

    /**
     *
     * @param command
     * @return
     */
    @RequestMapping(value = "/v1/transaction/deposit", method = POST)
    ResponseEntity<CardTransactionResponse> deposit(@RequestBody DepositCommand command);

    /**
     *
     * @param command
     * @return
     */
    @RequestMapping(value = "/v1/transaction/withdraw", method = POST)
    ResponseEntity<CardTransactionResponse> withdraw(@RequestBody WithdrawCommand command);
}
