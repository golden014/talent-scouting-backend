package org.enrichment.talent_scouting_backend.api.controller;

import org.enrichment.talent_scouting_backend.api.model.Admin;
import org.enrichment.talent_scouting_backend.api.dto.AdminLogin;
import org.enrichment.talent_scouting_backend.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public List<Admin> getAllAdmins() {
        return adminService.get();
    }

    @PostMapping("/login")
    public Admin login(@RequestBody AdminLogin adminLogin) {
        return adminService.login(adminLogin.getName(), adminLogin.getPassword());
    }

    @PostMapping("/save")
    public Admin insertAdmin(Admin admin) {
        return adminService.save(admin);
    }
}
