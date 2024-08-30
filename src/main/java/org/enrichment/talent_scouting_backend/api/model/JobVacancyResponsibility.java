package org.enrichment.talent_scouting_backend.api.model;

import jakarta.persistence.*;

@Entity
public class JobVacancyResponsibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_vacancy_id", nullable = false)
    private JobVacancy jobVacancy;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String responsibilityDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponsibilityDetail() {
        return responsibilityDetail;
    }

    public void setResponsibilityDetail(String responsibilityDetail) {
        this.responsibilityDetail = responsibilityDetail;
    }
}
