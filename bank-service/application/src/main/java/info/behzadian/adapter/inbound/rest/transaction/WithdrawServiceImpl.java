package info.behzadian.adapter.inbound.rest.transaction;

import info.behzadian.domain.Card;
import info.behzadian.domain.CardTransaction;
import info.behzadian.domain.CardTransactionType;
import info.behzadian.dto.card.withdraw.WithdrawCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;
import info.behzadian.exception.CardNotFountException;
import info.behzadian.exception.InsufficientBalanceException;
import info.behzadian.mapper.CardTransactionMapper;
import info.behzadian.port.inbound.rest.transaction.WithdrawService;
import info.behzadian.port.outbound.persistence.CardRepository;
import info.behzadian.port.outbound.persistence.CardTransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class WithdrawServiceImpl implements WithdrawService {

    private final CardRepository cardRepository;
    private final CardTransactionRepository cardTransactionRepository;
    private final CardTransactionMapper cardTransactionMapper;

    @Override
    @Transactional
    public CardTransactionResponse withdraw(WithdrawCommand command) {
        log.debug("WithdrawService.withdraw");
        log.debug("Command: {}", command);

        log.debug("check if card exists");
        Card card = cardRepository.findByCardNumber(command.getCardNumber())
                .orElseThrow(CardNotFountException::new);
        log.debug("Card: {}", card);

        if(card.getBalance().compareTo(command.getAmount()) < 0) {
            throw new InsufficientBalanceException();
        }

        CardTransaction cardTransaction = CardTransaction.builder()
                .card(card)
                .amount(command.getAmount())
                .beforeBalance(card.getBalance())
                .afterBalance(card.getBalance().add(command.getAmount()))
                .createDateTime(Instant.now())
                .transactionType(CardTransactionType.WITHDRAWAL)
                .build();

        cardTransactionRepository.save(cardTransaction);

        log.debug("CardTransaction saved: {}", cardTransaction);

        card.setBalance(card.getBalance().subtract(command.getAmount()));
        cardRepository.save(card);
        log.debug("card balance updated");

        return cardTransactionMapper.from(cardTransaction);
    }
}
