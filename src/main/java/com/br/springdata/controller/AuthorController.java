package com.br.springdata.controller;

import com.br.springdata.dtos.AuthorRecordDto;
import com.br.springdata.models.AuthorModel;
import com.br.springdata.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/author")
@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<AuthorModel> create(@RequestBody AuthorRecordDto authorRecordDto) {
        return new ResponseEntity<>(authorService.createAuthor(authorRecordDto), HttpStatus.CREATED);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<AuthorModel>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }
}
