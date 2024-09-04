package org.enrichment.talent_scouting_backend.api.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobVacancySkillID {
    @Column
    private Long jobVacancyId;

    @Column
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
}
