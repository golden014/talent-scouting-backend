package org.enrichment.talent_scouting_backend.api.model;

import jakarta.persistence.*;
import org.enrichment.talent_scouting_backend.api.model.id.JobVacancySkillID;

@Entity
public class JobVacancySkill {
    @EmbeddedId
    private JobVacancySkillID jobVacancySkillPK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_vacancy_id", insertable=false, updatable=false)
    private JobVacancy jobVacancy;

    @OneToOne
    @JoinColumn(name = "skill_id", insertable=false, updatable=false)
    private Skill skill;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String skillDetail;

    public JobVacancySkillID getJobVacancySkillPK() {
        return jobVacancySkillPK;
    }

    public void setJobVacancySkillPK(JobVacancySkillID jobVacancySkillPK) {
        this.jobVacancySkillPK = jobVacancySkillPK;
    }

    public JobVacancy getJobVacancy() {
        return jobVacancy;
    }

    public void setJobVacancy(JobVacancy jobVacancy) {
        this.jobVacancy = jobVacancy;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getSkillDetail() {
        return skillDetail;
    }

    public void setSkillDetail(String skillDetail) {
        this.skillDetail = skillDetail;
    }
}
