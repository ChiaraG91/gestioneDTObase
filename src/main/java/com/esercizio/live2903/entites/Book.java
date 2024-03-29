package com.esercizio.live2903.entites;

import com.esercizio.live2903.entites.enums.RecordStatusEnum;
import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String isbn;

    @Enumerated
    @Column(nullable = false)
    private RecordStatusEnum recordStatusEnum;

    public Book(Long id, String title, String author, String isbn, RecordStatusEnum recordStatusEnum) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.recordStatusEnum = RecordStatusEnum.AVAILABLE;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }
}


