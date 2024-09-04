package org.enrichment.talent_scouting_backend.api.controller;

import org.enrichment.talent_scouting_backend.api.model.ExtrasInfo;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.model.JobVacancyResponsibility;
import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;
import org.enrichment.talent_scouting_backend.api.request.InsertJobVacancy;
import org.enrichment.talent_scouting_backend.service.extras_info.ExtrasInfoService;
import org.enrichment.talent_scouting_backend.service.job_vacancy.JobVacancyService;
import org.enrichment.talent_scouting_backend.service.job_vacancy_responsibility.JobVacancyResponsibilityService;
import org.enrichment.talent_scouting_backend.service.job_vacancy_skill.JobVacancySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobVacancyController {

    @Autowired
    JobVacancyService jobVacancyService;

    @Autowired
    JobVacancySkillService jobVacancySkillService;

    @Autowired
    JobVacancyResponsibilityService jobVacancyResponsibilityService;;

    @Autowired
    ExtrasInfoService extrasInfoService;

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

    @PostMapping("/addJobVacancySkills")
    public List<JobVacancySkill> addJobVacancySkills(@RequestBody List<JobVacancySkill> jobVacancySkills) {
        return jobVacancySkillService.addSkills(jobVacancySkills);
    }

    @PostMapping("/addJobResponsibilites")
    public List<JobVacancyResponsibility> addJobResponsibilites(@RequestBody List<JobVacancyResponsibility> jobResponsibilites) {
        return jobVacancyResponsibilityService.addJobVacancyResponsibilites(jobResponsibilites);
    }

    @PostMapping("/addExtrasInfo")
    public List<ExtrasInfo> addExtrasInfo(@RequestBody List<ExtrasInfo> extrasInfos) {
        return extrasInfoService.addExtrasInfos(extrasInfos);
    }

}


