package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.domain.Card;
import info.behzadian.dto.card.verify.CardVerificationCommand;
import info.behzadian.dto.card.verify.CardVerificationResponse;
import info.behzadian.exception.CardNotFountException;
import info.behzadian.mapper.CardMapper;
import info.behzadian.port.inbound.rest.card.VerifyCardService;
import info.behzadian.port.outbound.persistence.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VerifyCardServiceImpl implements VerifyCardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    @Transactional(readOnly = true)
    public CardVerificationResponse verifyCard(CardVerificationCommand command) {
        log.debug("VerifyCardService.verifyCard");
        log.debug("Command: {}", command);

        log.debug("check if card exists");
        Card card = cardRepository.findByCardNumber(command.getCardNumber())
                .orElseThrow(CardNotFountException::new);
        log.debug("Card: {}", card);

        return cardMapper.from(card);
    }
}
