package org.enrichment.talent_scouting_backend.service.admin;

import org.enrichment.talent_scouting_backend.api.model.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> get();

    Admin login(String username, String password);

    Admin save(Admin admin);

}
