package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.domain.Card;
import info.behzadian.domain.CardTransaction;
import info.behzadian.dto.card.transactions.CardTransactionsCommand;
import info.behzadian.dto.card.transactions.CardTransactionsResponse;
import info.behzadian.exception.CardNotFountException;
import info.behzadian.mapper.CardTransactionMapper;
import info.behzadian.port.inbound.rest.card.CardTransactionsService;
import info.behzadian.port.outbound.persistence.CardRepository;
import info.behzadian.port.outbound.persistence.CardTransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardTransactionsServiceImpl implements CardTransactionsService {

    private final CardRepository cardRepository;
    private final CardTransactionRepository cardTransactionRepository;
    private final CardTransactionMapper cardTransactionMapper;

    @Override
    @Transactional(readOnly = true)
    public CardTransactionsResponse cardTransactions(CardTransactionsCommand command) {
        log.debug("CardTransactionsService.cardTransactions");
        log.debug("Command: {}", command);

        log.debug("check if card exists");
        Card card = cardRepository.findByCardNumber(command.getCardNumber())
                .orElseThrow(CardNotFountException::new);
        log.debug("Card: {}", card);

        List<CardTransaction> transactions;
        if(command.getFrom() != null && command.getTo() != null) {
            transactions = cardTransactionRepository.findTransactionsInTimeRange(command.getCardNumber(), command.getFrom(), command.getTo());
        } else {
            transactions = cardTransactionRepository.findTransactions(command.getCardNumber());
        }

        log.debug("number of transactions: {}", transactions.size());

        CardTransactionsResponse response = CardTransactionsResponse.builder()
                .from(command.getFrom())
                .to(command.getTo())
                .transactionsCount(transactions.size())
                .transactions(transactions.stream().map(cardTransactionMapper::from).collect(Collectors.toList()))
                .build();

        return response;
    }
}
