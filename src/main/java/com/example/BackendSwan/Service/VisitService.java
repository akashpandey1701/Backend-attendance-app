package com.example.BackendSwan.Service;

import com.example.BackendSwan.Entity.Visit;
import com.example.BackendSwan.Repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public Optional<Visit> getVisitById(String id) {
        return visitRepository.findById(id);
    }

    public Optional<Visit> getVisitsById(String id) {
        return visitRepository.findById(id);
    }

    public Visit saveVisit(Visit visit) {
        return visitRepository.save(visit);
    }


    public List<Visit> getVisitsByUsername(String username) {
        return visitRepository.findByUsername(username);
    }
}
