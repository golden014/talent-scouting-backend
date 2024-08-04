package org.enrichment.talent_scouting_backend.api.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class JobVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToOne
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

    @Column
    private Date timeStamp;

    @Column
    private String jobPosition;

    @Column
    private Date endDateTime;

    @Column
    private String jobDescription;

    @Column
    private String location;

    @Column
    private String salaryRange;

    @Column
    private String workTimeType;
}
