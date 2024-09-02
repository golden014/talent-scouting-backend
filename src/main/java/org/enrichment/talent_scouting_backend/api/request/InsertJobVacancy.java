package org.enrichment.talent_scouting_backend.api.request;

import org.enrichment.talent_scouting_backend.api.model.ExtrasInfo;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.model.JobVacancyResponsibility;
import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;

import java.util.List;

public class InsertJobVacancy {
    private JobVacancy jobVacancy;
    private List<JobVacancySkill> jobVacancySkills;
    private List<JobVacancyResponsibility> jobVacancyResponsibilities;
    private List<ExtrasInfo> extrasInfos;

    public JobVacancy getJobVacancy() {
        return jobVacancy;
    }

    public void setJobVacancy(JobVacancy jobVacancy) {
        this.jobVacancy = jobVacancy;
    }

    public List<JobVacancySkill> getJobVacancySkills() {
        return jobVacancySkills;
    }

    public void setJobVacancySkills(List<JobVacancySkill> jobVacancySkills) {
        this.jobVacancySkills = jobVacancySkills;
    }

    public List<JobVacancyResponsibility> getJobVacancyResponsibilities() {
        return jobVacancyResponsibilities;
    }

    public void setJobVacancyResponsibilities(List<JobVacancyResponsibility> jobVacancyResponsibilities) {
        this.jobVacancyResponsibilities = jobVacancyResponsibilities;
    }

    public List<ExtrasInfo> getExtrasInfos() {
        return extrasInfos;
    }

    public void setExtrasInfos(List<ExtrasInfo> extrasInfos) {
        this.extrasInfos = extrasInfos;
    }
}
