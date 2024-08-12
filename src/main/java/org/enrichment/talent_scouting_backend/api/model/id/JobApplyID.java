package org.enrichment.talent_scouting_backend.api.model.id;

//composite key (jobvacancy ID and Student ID)

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobApplyID {

    @Column
    private long jobVacancyId;

    @Column
    private long studentId;

    public JobApplyID() {}

    public JobApplyID(long jobVacancyId, long studentId) {
        this.jobVacancyId = jobVacancyId;
        this.studentId = studentId;
    }

    public long getJobVacancyId() {
        return jobVacancyId;
    }

    public void setJobVacancyId(long jobVacancyId) {
        this.jobVacancyId = jobVacancyId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
