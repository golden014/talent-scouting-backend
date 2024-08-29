package org.enrichment.talent_scouting_backend.api.model;

import jakarta.persistence.*;

@Entity
public class ExtrasInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String extrasTitle;

    @ManyToOne
    @JoinColumn(name = "job_vacancy_id", nullable = false)
    private JobVacancy jobVacancy;


    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String extrasDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtrasTitle() {
        return extrasTitle;
    }

    public void setExtrasTitle(String extrasTitle) {
        this.extrasTitle = extrasTitle;
    }

    public String getExtrasDescription() {
        return extrasDescription;
    }

    public void setExtrasDescription(String extrasDescription) {
        this.extrasDescription = extrasDescription;
    }

    public JobVacancy getJobVacancy() {
        return jobVacancy;
    }

    public void setJobVacancy(JobVacancy jobVacancy) {
        this.jobVacancy = jobVacancy;
    }
}
