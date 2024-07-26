package org.enrichment.talent_scouting_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter @Setter
public class Student {

    //generated value -> column ini akan tergenerate value nya, dengan cara increment satu per satu (identity)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String nim;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private Date dob;

    @Column
    private String major;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String picture_url;

    @Column
    private String description;

    @Column
    private String personal_url;


}
