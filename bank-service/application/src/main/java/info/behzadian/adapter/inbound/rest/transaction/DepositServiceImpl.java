package info.behzadian.adapter.inbound.rest.transaction;

import info.behzadian.domain.Card;
import info.behzadian.domain.CardTransaction;
import info.behzadian.domain.CardTransactionType;
import info.behzadian.dto.card.deposit.DepositCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;
import info.behzadian.exception.CardNotFountException;
import info.behzadian.mapper.CardTransactionMapper;
import info.behzadian.port.inbound.rest.transaction.DepositService;
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
public class DepositServiceImpl implements DepositService {

    private final CardRepository cardRepository;
    private final CardTransactionRepository cardTransactionRepository;
    private final CardTransactionMapper cardTransactionMapper;

    @Override
    @Transactional
    public CardTransactionResponse deposit(DepositCommand command) {
        log.debug("DepositService.deposit");
        log.debug("Command: {}", command);

        log.debug("check if card exists");
        Card card = cardRepository.findByCardNumber(command.getCardNumber())
                .orElseThrow(CardNotFountException::new);
        log.debug("Card: {}", card);

        CardTransaction cardTransaction = CardTransaction.builder()
                .card(card)
                .amount(command.getAmount())
                .beforeBalance(card.getBalance())
                .afterBalance(card.getBalance().add(command.getAmount()))
                .createDateTime(Instant.now())
                .transactionType(CardTransactionType.DEPOSIT)
                .build();

        cardTransactionRepository.save(cardTransaction);

        log.debug("CardTransaction saved: {}", cardTransaction);

        card.setBalance(card.getBalance().add(command.getAmount()));
        cardRepository.save(card);
        log.debug("card balance updated");

        return cardTransactionMapper.from(cardTransaction);
    }
}
