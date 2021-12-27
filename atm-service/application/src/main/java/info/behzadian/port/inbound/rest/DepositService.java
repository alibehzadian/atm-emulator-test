package info.behzadian.port.inbound.rest;

import info.behzadian.dto.card.deposit.DepositCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;

public interface DepositService {
    CardTransactionResponse deposit(DepositCommand command);
}
