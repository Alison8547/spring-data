package com.br.springdata.controller;

import com.br.springdata.dtos.PublisherRecordDto;
import com.br.springdata.models.PublisherModel;
import com.br.springdata.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/publisher")
@RestController
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;


    @PostMapping("/create")
    public ResponseEntity<PublisherModel> createPublisher(@RequestBody PublisherRecordDto publisherRecordDto) {
        return new ResponseEntity<>(publisherService.createPublisher(publisherRecordDto), HttpStatus.CREATED);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<PublisherModel>> findAllPublisher() {
        return new ResponseEntity<>(publisherService.getAllPublisher(), HttpStatus.OK);
    }

}
