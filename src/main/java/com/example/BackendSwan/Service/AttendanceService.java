package com.example.BackendSwan.Service;

import com.example.BackendSwan.Entity.Attendance;
import com.example.BackendSwan.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(String id) {
        return attendanceRepository.findById(id);
    }

    public Optional<Attendance> getAttendancesById(String id) {
        return attendanceRepository.findById(id);
    }




    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendancesByUsername(String username) {
        return attendanceRepository.findByUsername(username);
    }
}
