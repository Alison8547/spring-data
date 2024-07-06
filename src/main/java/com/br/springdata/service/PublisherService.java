package com.br.springdata.service;

import com.br.springdata.dtos.PublisherRecordDto;
import com.br.springdata.exception.BusinessException;
import com.br.springdata.models.PublisherModel;
import com.br.springdata.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Transactional
    public PublisherModel createPublisher(PublisherRecordDto publisherRecordDto) {

        if (publisherRepository.existsByNameContainingIgnoreCase(publisherRecordDto.name())) {
            throw new BusinessException("Name Publisher already exists!");
        }

        PublisherModel publisher = new PublisherModel();
        publisher.setName(publisherRecordDto.name());

        publisherRepository.save(publisher);

        return publisher;
    }

    public List<PublisherModel> getAllPublisher() {
        return publisherRepository.findAll();
    }

    public PublisherModel findPublisherById(UUID id) {
        return publisherRepository.findById(id).orElseThrow(() -> new BusinessException("No publisher found with id: " + id));
    }
}
