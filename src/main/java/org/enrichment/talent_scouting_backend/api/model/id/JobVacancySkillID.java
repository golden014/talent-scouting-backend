package org.enrichment.talent_scouting_backend.api.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobVacancySkillID {
    @Column
    private long jobVacancyId;

    @Column
    private long skillId;

    public JobVacancySkillID() {}

    public JobVacancySkillID(long jobVacancyId, long skillId) {
        this.jobVacancyId = jobVacancyId;
        this.skillId = skillId;
    }

    public long getJobVacancyId() {
        return jobVacancyId;
    }

    public void setJobVacancyId(long jobVacancyId) {
        this.jobVacancyId = jobVacancyId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }
}
