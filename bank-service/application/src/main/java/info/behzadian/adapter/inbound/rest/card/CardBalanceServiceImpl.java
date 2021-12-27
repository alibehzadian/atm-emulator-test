package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.domain.Card;
import info.behzadian.dto.card.balance.CardBalanceCommand;
import info.behzadian.dto.card.balance.CardBalanceResponse;
import info.behzadian.exception.CardNotFountException;
import info.behzadian.mapper.CardMapper;
import info.behzadian.port.inbound.rest.card.CardBalanceService;
import info.behzadian.port.outbound.persistence.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardBalanceServiceImpl implements CardBalanceService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public CardBalanceResponse cardBalance(CardBalanceCommand command) {
        log.debug("CardBalanceService.cardBalance");
        log.debug("Command: {}", command);

        log.debug("check if card exists");
        Card card = cardRepository.findByCardNumber(command.getCardNumber())
                .orElseThrow(CardNotFountException::new);
        log.debug("Card: {}", card);

        var result = cardMapper.cardBalanceResponse(card);
        log.debug("Result: {}", result);

        return result;
    }
}
