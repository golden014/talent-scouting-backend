package org.enrichment.talent_scouting_backend.service.admin;

import org.enrichment.talent_scouting_backend.api.dao.admin.AdminDAO;
import org.enrichment.talent_scouting_backend.api.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional
    public List<Admin> get() {
        return adminDAO.get();
    }

    @Override
    @Transactional
    public Admin login(String name, String password) {
        return adminDAO.get(name, password);
    }

    @Override
    @Transactional
    public Admin save(Admin admin) {
        return adminDAO.save(admin);
    }
}
