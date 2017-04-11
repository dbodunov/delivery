package io.delivery.service;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentService {

    /**
     * Receive all documents from db
     *
     * @return  document list
     */
    List<Document> getDocumentList();

    /**
     * Find documents by name in database
     * @param name - value name of document
     * @return document
     */
    List<Document> findByName(String name);

    /**
     * Create entity in database
     *
     * @param document - current document for creation
     * @return created document
     */
    Document create(Document document);
}
