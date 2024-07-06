package com.br.springdata.controller;

import com.br.springdata.dtos.BookRecordDto;
import com.br.springdata.models.BookModel;
import com.br.springdata.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/book")
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookModel> createBook(@RequestBody BookRecordDto bookRecordDto) {
        return new ResponseEntity<>(bookService.createBook(bookRecordDto), HttpStatus.CREATED);
    }
}
