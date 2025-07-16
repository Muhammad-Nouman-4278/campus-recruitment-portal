package com.hhtechhub.campus_recruitment.Admin.Controller;



import com.hhtechhub.campus_recruitment.Admin.Model.AdminStatsResponse;
import com.hhtechhub.campus_recruitment.Admin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/stats")
    public ResponseEntity<AdminStatsResponse> getStats() {
        return ResponseEntity.ok(adminService.getDashboardStats());
    }
}
