package com.br.springdata.service;

import com.br.springdata.dtos.BookRecordDto;
import com.br.springdata.models.BookModel;
import com.br.springdata.models.ReviewModel;
import com.br.springdata.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    @Transactional
    public BookModel createBook(BookRecordDto bookRecordDto) {

        for (UUID id : bookRecordDto.authorIds()) {
            authorService.findAuthorById(id);
        }

        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherService.findPublisherById(bookRecordDto.publisherId()));
        book.setAuthors(new HashSet<>(authorService.getAllAuthorsById(bookRecordDto.authorIds())));

        ReviewModel review = new ReviewModel();
        review.setComment(bookRecordDto.reviewComment());
        review.setBook(book);

        book.setReview(review);

        bookRepository.save(book);

        return book;
    }
}
