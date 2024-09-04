package org.enrichment.talent_scouting_backend.api.model.id;

//composite key (jobvacancy ID and Student ID)

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobApplyID {

    @Column(name = "job_vacancy_id")
    private Long jobVacancyId;

    @Column(name = "student_id")
    private Long studentId;

    public JobApplyID() {}

    public JobApplyID(Long jobVacancyId, Long studentId) {
        this.jobVacancyId = jobVacancyId;
        this.studentId = studentId;
    }

    public Long getJobVacancyId() {
        return jobVacancyId;
    }

    public void setJobVacancyId(Long jobVacancyId) {
        this.jobVacancyId = jobVacancyId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
