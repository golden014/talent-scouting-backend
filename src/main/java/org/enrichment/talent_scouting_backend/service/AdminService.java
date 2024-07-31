package org.enrichment.talent_scouting_backend.service;

import org.enrichment.talent_scouting_backend.api.model.Admin;

public interface AdminService {

    Admin login(String username, String password);

    Admin save(Admin admin);

}
