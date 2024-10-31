package com.itLens.surveyApp.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surveyEditions")
public class SurveyEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(
            name = "creationDate",
            nullable = false
    )
    private LocalDate creationDate;

    @Column(
            name = "startDate",
            nullable = false
    )
    private LocalDate startDate;

    @Column(
            name = "endDate",
            nullable = false
    )
    private LocalDate endDate;

    @Column(
            name = "year",
            nullable = false
    )
    private String year;

    @ManyToOne
    @JoinColumn(
            name = "surveyId",
            nullable = false
    )
    private Survey survey;

    @OneToMany(
            mappedBy = "surveyEdition",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Subject> subjects;

}
