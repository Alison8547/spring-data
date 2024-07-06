package com.br.springdata.service;

import com.br.springdata.dtos.AuthorRecordDto;
import com.br.springdata.exception.BusinessException;
import com.br.springdata.models.AuthorModel;
import com.br.springdata.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public AuthorModel createAuthor(AuthorRecordDto authorRecordDto) {
        AuthorModel author = new AuthorModel();
        author.setName(authorRecordDto.name());

        authorRepository.save(author);

        return author;
    }

    public List<AuthorModel> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<AuthorModel> getAllAuthorsById(Set<UUID> ids) {
        return authorRepository.findAllById(ids);

    }

    public AuthorModel findAuthorById(UUID id) {
        return authorRepository.findById(id).orElseThrow(() -> new BusinessException("No author found with id: " + id));
    }

}
