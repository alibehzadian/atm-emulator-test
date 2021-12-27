package info.behzadian.mapper;

import info.behzadian.domain.base.BaseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class EntityToIdMapper {
    final Long toId(BaseEntity entity) {
        return entity.getId();
    }
}
