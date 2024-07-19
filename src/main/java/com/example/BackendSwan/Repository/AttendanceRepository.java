package com.example.BackendSwan.Repository;

import com.example.BackendSwan.Entity.Attendance;
import com.example.BackendSwan.Entity.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByUsername(String username);
}
