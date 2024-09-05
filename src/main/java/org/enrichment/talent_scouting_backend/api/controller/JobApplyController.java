package org.enrichment.talent_scouting_backend.api.controller;


import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.request.SingleIDRequest;
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

        System.out.println("Received JobApply JobVacancyId: " + jobApply.getJobApplyPK().getJobVacancyId());
        System.out.println("Received JobApply student ID:" + jobApply.getJobApplyPK().getStudentId());
        System.out.println("Notes: " + jobApply.getNotes());

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
    public List<JobApply> getJobApplyByVacancyId(Long jobVacancyId) {
        return jobApplyService.getAllJobApplys(jobVacancyId);
    }

    @PostMapping("/updateJobApply")
    public ResponseEntity<JobApply> updateJobApply(@RequestBody JobApply jobApply) {
        if (jobApplyService.updateJobApply(jobApply) != null) {
            return ResponseEntity.ok(jobApply);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/getJobApplyByCompanyId")
    public List<JobApply> getJobApplyByStudentId(@RequestBody SingleIDRequest data) {
        return jobApplyService.getJobApplyByStudentId(data.getId());
    }
}
