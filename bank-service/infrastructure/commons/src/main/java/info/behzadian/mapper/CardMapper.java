package info.behzadian.mapper;

import info.behzadian.domain.Card;
import info.behzadian.dto.card.balance.CardBalanceResponse;
import info.behzadian.dto.card.verify.CardVerificationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EntityToIdMapper.class)
public interface CardMapper {

    CardVerificationResponse from(Card card);

    CardBalanceResponse cardBalanceResponse(Card card);

}
