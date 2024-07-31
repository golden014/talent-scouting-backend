package org.enrichment.talent_scouting_backend.service;

import org.enrichment.talent_scouting_backend.api.dao.admin.AdminDAO;
import org.enrichment.talent_scouting_backend.api.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin login(String username, String password) {
        return adminDAO.get(username, password);
    }

    @Override
    public Admin save(Admin admin) {
        return adminDAO.save(admin);
    }
}
