package plataforma_academica.plataforma_academica.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CrudService <T, ID>{
    List<T> findAll() throws Exception;
    Optional<T> findById(ID id) throws Exception;  // Cambiado a Optional
    T save(T t) throws Exception;
    T update(T t) throws Exception;
    void deleteById(ID id) throws Exception;
    void deleteAll() throws Exception;

}