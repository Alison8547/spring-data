package com.br.springdata.repository;

import com.br.springdata.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}