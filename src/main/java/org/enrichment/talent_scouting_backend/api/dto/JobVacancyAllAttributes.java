package org.enrichment.talent_scouting_backend.api.dto;

import org.enrichment.talent_scouting_backend.api.model.ExtrasInfo;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.model.JobVacancyResponsibility;
import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;

import java.util.List;

public class JobVacancyAllAttributes {
    private JobVacancy jobVacancy;
    private List<JobVacancySkill> skills;
    private List<JobVacancyResponsibility> jobResponsibilities;
    private List<ExtrasInfo> extrasInfo;

    public JobVacancyAllAttributes(JobVacancy jobVacancy, List<JobVacancySkill> skills, List<JobVacancyResponsibility> jobResponsibilities, List<ExtrasInfo> extrasInfo) {
        this.jobVacancy = jobVacancy;
        this.skills = skills;
        this.jobResponsibilities = jobResponsibilities;
        this.extrasInfo = extrasInfo;
    }

    public JobVacancy getJobVacancy() {
        return jobVacancy;
    }

    public void setJobVacancy(JobVacancy jobVacancy) {
        this.jobVacancy = jobVacancy;
    }

    public List<JobVacancySkill> getSkills() {
        return skills;
    }

    public void setSkills(List<JobVacancySkill> skills) {
        this.skills = skills;
    }

    public List<JobVacancyResponsibility> getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(List<JobVacancyResponsibility> jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

    public List<ExtrasInfo> getExtrasInfo() {
        return extrasInfo;
    }

    public void setExtrasInfo(List<ExtrasInfo> extrasInfo) {
        this.extrasInfo = extrasInfo;
    }
}
