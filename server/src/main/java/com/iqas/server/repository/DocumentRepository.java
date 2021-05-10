package com.iqas.server.repository;

import com.iqas.server.model.DocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<DocumentModel, Integer> {
}
