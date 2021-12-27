package info.behzadian.mapper;

import info.behzadian.domain.CardTransaction;
import info.behzadian.dto.transaction.CardTransactionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EntityToIdMapper.class)
public interface CardTransactionMapper {

    CardTransactionResponse from(CardTransaction transaction);

}
