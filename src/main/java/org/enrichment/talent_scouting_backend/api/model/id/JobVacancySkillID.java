package org.enrichment.talent_scouting_backend.api.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.model.Skill;

import java.util.Objects;

@Embeddable
public class JobVacancySkillID {
    @Column(name = "job_vacancy_id")
    private Long jobVacancyId;

    @Column(name = "skill_id")
    private Long skillId;

    public JobVacancySkillID() {}

    public JobVacancySkillID(Long jobVacancyId, Long skillId) {
        this.jobVacancyId = jobVacancyId;
        this.skillId = skillId;
    }

    public Long getJobVacancyId() {
        return jobVacancyId;
    }

    public void setJobVacancyId(Long jobVacancyId) {
        this.jobVacancyId = jobVacancyId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobVacancySkillID that = (JobVacancySkillID) o;
        return Objects.equals(jobVacancyId, that.jobVacancyId) &&
                Objects.equals(skillId, that.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobVacancyId, skillId);
    }
}
