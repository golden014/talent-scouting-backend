package org.enrichment.talent_scouting_backend.api.controller;

import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.request.InsertJobVacancy;
import org.enrichment.talent_scouting_backend.service.job_vacancy.JobVacancyService;
import org.enrichment.talent_scouting_backend.service.job_vacancy_skill.JobVacancySkillService;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobVacancyController {

    @Autowired
    JobVacancyService jobVacancyService;

    @PostMapping("/addVacancy")
    public ResponseEntity<JobVacancy> addVacancy(@RequestBody JobVacancy jobVacancy) {
        if (jobVacancyService.addJobVacancy(jobVacancy) != null) {
            return ResponseEntity.ok(jobVacancy);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/deleteVacancy")
    public void deleteVacancy(@RequestBody JobVacancy jobVacancy) {
        jobVacancyService.deleteJobVacancy(jobVacancy);
    }

    @PostMapping("/addJobVacancy")
    public JobVacancy addJobVacancy(@RequestBody InsertJobVacancy data) {
        return jobVacancyService.addJobVacancy(data);
    }
}


