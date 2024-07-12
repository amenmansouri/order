package kn.studio.order.mappers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<Entity, Dto> {
    Dto entityToDto(Entity entity);
    Entity dtoToEntity(Dto dto);
    /*
        default <C extends Collection<Dto>> C entitiesToDtos(Collection<Entity> entities, C targetCollection) {
            return entities.stream()
                    .map(this::entityToDto)
                    .collect(Collectors.toCollection(() -> instantiateCollection(targetCollection)));
        }

        default <C extends Collection<Entity>> C dtosToEntities(Collection<Dto> entities, C targetCollection) {
            return entities.stream()
                    .map(this::dtoToEntity)
                    .collect(Collectors.toCollection(() -> instantiateCollection(targetCollection)));
        }

       */
    default Page<Dto> pageEntitiesToPageDtos(Page<Entity> pageEntities) {
        List<Dto> dtos = pageEntities.getContent().stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageEntities.getPageable(), pageEntities.getTotalElements());
    }

    default Page<Entity> pageDtosToPageEntities(Page<Dto> pageEntities) {
        List<Entity> entities = pageEntities.getContent().stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());

        return new PageImpl<>(entities, pageEntities.getPageable(), pageEntities.getTotalElements());
    }
    @SuppressWarnings("unchecked")
    private <C extends Collection<?>> C instantiateCollection(C targetCollection) {
        try {
            return (C) targetCollection.getClass().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating collection", e);
        }
    }
}
