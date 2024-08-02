package org.enrichment.talent_scouting_backend.api.dao.admin;

import org.enrichment.talent_scouting_backend.api.model.Admin;

import java.util.List;

public interface AdminDAO {

    List<Admin> get();

    Admin get(int id);

    Admin get(String username, String password);

    Admin save(Admin admin);

}
