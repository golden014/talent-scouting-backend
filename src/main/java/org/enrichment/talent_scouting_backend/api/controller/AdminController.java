package org.enrichment.talent_scouting_backend.api.controller;

import org.enrichment.talent_scouting_backend.api.model.Admin;
import org.enrichment.talent_scouting_backend.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Admin login(String username, String password) {
        return adminService.login(username, password);
    }

    @PostMapping("/save")
    public Admin insertAdmin(Admin admin) {
        return adminService.save(admin);
    }
}
