package com.example.BackendSwan.Controller;

import com.example.BackendSwan.Entity.Attendance;
import com.example.BackendSwan.Entity.User;
import com.example.BackendSwan.Entity.Visit;
import com.example.BackendSwan.Service.AttendanceService;
import com.example.BackendSwan.Service.UserService;
import com.example.BackendSwan.Service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/employee")
    public User createEmployee(@RequestBody User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userService.saveEmployee(user);
    }

    @PutMapping("/employee/{id}")
    public User updateEmployee(@PathVariable String id, @RequestBody User updatedUser) {
        return userService.updateEmployee(id, updatedUser);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable String id) {
        userService.deleteEmployeeById(id);
    }

    @GetMapping("/employee")
    public List<User> getAllEmployees() {
        return userService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Optional<User> getEmployeeById(@PathVariable String id) {
        return userService.findEmployeeById(id);
    }


    @GetMapping("/visit")
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @GetMapping("/visit/{id}")
    public Optional<Visit> getVisitById(@PathVariable String id) {
        return visitService.getVisitById(id);
    }


    @GetMapping("/attendance")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/attendance/{id}")
    public Optional<Attendance> getAttendanceById(@PathVariable String id) {
        return attendanceService.getAttendanceById(id);
    }
}
