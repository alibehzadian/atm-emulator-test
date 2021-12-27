package info.behzadian.port.inbound.rest;

import info.behzadian.dto.card.withdraw.WithdrawCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;

public interface WithdrawService {

    CardTransactionResponse withdraw(WithdrawCommand command);
}
