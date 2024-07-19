package com.example.BackendSwan.Controller;

import com.example.BackendSwan.Entity.Attendance;
import com.example.BackendSwan.Entity.Visit;
import com.example.BackendSwan.Service.AttendanceService;
import com.example.BackendSwan.Service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private VisitService visitService;

    @PostMapping("/attendance")
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        String username = getUsernameFromAuthentication();
        attendance.setUsername(username);
        return attendanceService.saveAttendance(attendance);
    }

    @PostMapping("/visit")
    public Visit addVisit(@RequestBody Visit visit) {
        String username = getUsernameFromAuthentication();
        visit.setUsername(username);
        return visitService.saveVisit(visit);
    }

    @GetMapping("/attendance")
    public List<Attendance> getAttendance() {
        String username = getUsernameFromAuthentication();
        return attendanceService.getAttendancesByUsername(username);
    }

    @GetMapping("/visit")
    public List<Visit> getVisits() {
        String username = getUsernameFromAuthentication();
        return visitService.getVisitsByUsername(username);
    }

    private String getUsernameFromAuthentication() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}
