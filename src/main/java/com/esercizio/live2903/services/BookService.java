package com.esercizio.live2903.services;

import com.esercizio.live2903.dto.BookDTO;
import com.esercizio.live2903.entites.Book;
import com.esercizio.live2903.entites.enums.RecordStatusEnum;
import com.esercizio.live2903.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        return convertToDTO(bookRepository.save(book));
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getAllBooksActive() {
        return bookRepository.findByActiveTrue().stream() // Modifica per selezionare solo utenti attivi
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(this::convertToDTO).orElse(null);
    }

    public BookDTO getBookByIdActive(Long id) {
        Optional<Book> optionalBook = bookRepository.findByIdAndActiveTrue(id); // Modifica per selezionare solo utenti attivi
        return optionalBook.map(this::convertToDTO).orElse(null);
    }


    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            BeanUtils.copyProperties(bookDTO,existingBook);
            return convertToDTO(bookRepository.save(existingBook));
        }
        return null;
    }


    public void deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.ifPresent(book-> {
            book.setRecordStatusEnum(RecordStatusEnum.NOAVAILABLE); // Modifica dello stato dell'utente a inattivo
            bookRepository.save(book);
        });
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO);
        return bookDTO;
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        return book;
    }



}
