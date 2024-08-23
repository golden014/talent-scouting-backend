package org.enrichment.talent_scouting_backend.api.controller;


import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.service.job_apply.JobApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobApplyController {

    @Autowired
    JobApplyService jobApplyService;

    @PostMapping("/addJobApply")
    public ResponseEntity<JobApply> addJobApply(@RequestBody JobApply jobApply) {
        if (jobApplyService.save(jobApply) != null) {
            return ResponseEntity.ok(jobApply);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getJobApplyById")
    public ResponseEntity<JobApply> getJobApplyById(@RequestParam("jobApplyId") Long jobApplyId) {
        JobApply out = jobApplyService.getJobApply(jobApplyId);

        if (out != null) {
            return ResponseEntity.ok(out);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getJobApplyByVacancyId")
    public List<JobApply> getJobApplyByVacancyId(long job_vacancyId) {
        return jobApplyService.getAllJobApplys(job_vacancyId);
    }
}