package org.example.repository;

import org.example.model.FilledService;
import org.example.model.FilledServiceStep;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface FilledServiceStepRepository extends KeyValueRepository<FilledServiceStep, String> {
}
