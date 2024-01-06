package com.mecorp.backend.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "activity")
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "occurrence_date")
    private String occurrenceDate;

    @Column(name = "jira_link")
    private String jiraLink;

    @Column(name = "description")
    private String description;

    @Column(name = "spent_hours")
    private String spentHours;
}
