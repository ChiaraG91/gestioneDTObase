package com.esercizio.live2903.repositories;

import com.esercizio.live2903.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByActiveTrue(); // Metodo per trovare tutti gli utenti attivi
    Optional<Book> findByIdAndActiveTrue(Long id); // Metodo per trovare un utente per ID attivo
}
