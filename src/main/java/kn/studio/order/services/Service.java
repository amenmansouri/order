package kn.studio.order.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Service <T>{
    T saveOrUpdate(T dto);
    Optional<T> findById(long id);
    Page<T> findAll(Pageable pageable);
    void deleteById(long id);
}
