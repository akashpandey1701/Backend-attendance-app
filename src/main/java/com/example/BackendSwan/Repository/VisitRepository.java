package com.example.BackendSwan.Repository;

import com.example.BackendSwan.Entity.Visit;
import com.example.BackendSwan.Entity.Visit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VisitRepository extends MongoRepository<Visit, String> {
    List<Visit> findByUsername(String username);
}
