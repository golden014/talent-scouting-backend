package org.enrichment.talent_scouting_backend.api.model;

import jakarta.persistence.*;
import org.enrichment.talent_scouting_backend.api.model.id.JobApplyID;

@Entity
public class JobApply {

    @EmbeddedId
    private JobApplyID jobApplyPK;

    @JoinColumn(name = "job_vacancy_id", insertable = false, updatable = false)
    @OneToOne
    private JobVacancy jobVacancy;

    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @OneToOne
    private Student student;

    @Column
    private String status;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String notes;

    public JobApplyID getJobApplyPK() {
        return jobApplyPK;
    }

    public void setJobApplyPK(JobApplyID jobApplyPK) {
        this.jobApplyPK = jobApplyPK;
    }

    public JobVacancy getJobVacancy() {
        return jobVacancy;
    }

    public void setJobVacancy(JobVacancy jobVacancy) {
        this.jobVacancy = jobVacancy;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
