package org.enrichment.talent_scouting_backend.api.model;

import jakarta.persistence.*;

@Entity
public class JobApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;




}
