package org.enrichment.talent_scouting_backend.api.controller;

import org.enrichment.talent_scouting_backend.api.dto.JobVacancyAllAttributes;
import org.enrichment.talent_scouting_backend.api.model.*;
import org.enrichment.talent_scouting_backend.api.dto.SingleIDRequest;
import org.enrichment.talent_scouting_backend.api.dto.InsertJobVacancy;
import org.enrichment.talent_scouting_backend.api.dto.JobVacancyFilter;
import org.enrichment.talent_scouting_backend.service.extras_info.ExtrasInfoService;
import org.enrichment.talent_scouting_backend.service.job_vacancy.JobVacancyService;
import org.enrichment.talent_scouting_backend.service.job_vacancy_responsibility.JobVacancyResponsibilityService;
import org.enrichment.talent_scouting_backend.service.job_vacancy_skill.JobVacancySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        for (JobVacancySkill skill: jobVacancySkills) {
            System.out.println("Received JobVacancySkill: " + skill);
            System.out.println("JobVacancySkillPK: " + skill.getJobVacancySkillPK().getJobVacancyId());
            System.out.println("JobVacancySkillPK: " + skill.getJobVacancySkillPK().getSkillId());
        }
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

    // @GetMapping("/job-vacancies")
    //    public List<JobVacancy> getJobVacancies(
    //            @RequestParam(required = false) String location,
    //            @RequestParam(required = false) String jobPosition,
    //            @RequestParam(required = false) Long jobTypeId) {
    //        return jobVacancyService.getFilteredJobVacancies(location, jobPosition, jobTypeId);
    //    }

    @PostMapping("/getJobVacancyWithFilter")
    public List<JobVacancy> getJobVacancyWithFilter(@RequestBody JobVacancyFilter jobVacancyFilter) {
        return jobVacancyService.getJobVacanciesByFilters(jobVacancyFilter);
    }

    @PostMapping("/getJobVacancyByCompanyId")
    public List<JobVacancy> getJobVacanciesByCompanyId(@RequestBody SingleIDRequest data) {
        System.out.println(data.getId());
        return jobVacancyService.getJobVacancyByCompanyId(data.getId());
    }

    @GetMapping("/getJobVacancyById")
    public ResponseEntity<JobVacancyAllAttributes> getJobVacancyById(@RequestParam("jobVacancyId") Long jobVacancyId) {
        JobVacancyAllAttributes out = jobVacancyService.getJobVacancyById(jobVacancyId);

        if (out != null) {
            return ResponseEntity.ok(out);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getPopularJobVacancy")
    public ResponseEntity<List<JobVacancy>> getJobPopularJobVacancy(@RequestParam("topCount") Long topCount) {
        List<JobVacancy> output = jobVacancyService.getTopJobVacancy(topCount);
        if (output != null) {
            return ResponseEntity.ok(output);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getLatestJobByCompanyId")
    public ResponseEntity<List<JobVacancy>> getLatestJobByCompanyId(@RequestParam("companyId") Long companyId, @RequestParam("latestCount") Long latestCount) {
        List<JobVacancy> output = jobVacancyService.getLatestJobVacancyByCompanyId(companyId, latestCount);
        if (output != null) {
            return ResponseEntity.ok(output);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getJobVacancyLocations")
    public ResponseEntity<List<String>> getJobVacancyLocations() {
        List<String> output = jobVacancyService.getJobVacancyLocations();
        if (output != null) {
            return ResponseEntity.ok(output);
        }
        return ResponseEntity.badRequest().build();
    }
}


