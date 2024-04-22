package org.example.repository;

import org.example.model.FilledService;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface FilledServiceRepository extends KeyValueRepository<FilledService, String> {
}
