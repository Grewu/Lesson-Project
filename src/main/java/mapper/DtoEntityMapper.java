package mapper;

public interface DtoEntityMapper<E, D> {
    E toEntity(D dto);

    D toDto(E entity);
}
