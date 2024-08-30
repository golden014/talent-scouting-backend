package org.enrichment.talent_scouting_backend.api.model;

import jakarta.persistence.*;
import org.enrichment.talent_scouting_backend.api.model.id.JobVacancySkillID;

@Entity
public class JobVacancySkill {
    @EmbeddedId
    private JobVacancySkillID jobVacancySkillPK;

    @MapsId("jobVacancySkillId")
    @JoinColumn(name = "job_vacancy_skill_id")
    @OneToOne
    private JobVacancySkill jobVacancySkill;

    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    @OneToOne
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

    public JobVacancySkill getJobVacancySkill() {
        return jobVacancySkill;
    }

    public void setJobVacancySkill(JobVacancySkill jobVacancySkill) {
        this.jobVacancySkill = jobVacancySkill;
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
