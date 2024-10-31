package com.itLens.surveyApp.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private String id;

    @NotBlank
    @Size(max = 255)
    @Column(
            name = "title",
            unique = true,
            nullable = false
    )
    private String title;

    @NotBlank
    @ManyToOne
    @JoinColumn(
            name = "surveyEditionId",
            nullable = false
    )
    private SurveyEdition surveyEdition;

    @OneToMany(
            mappedBy = "subject",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Question> questions;

    @OneToMany(
            mappedBy = "parentSubject",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Subject> subSubjects;

    @NotBlank
    @ManyToOne
    @JoinColumn(
            name = "parentSubjectId"
    )
    private Subject parentSubject;

    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
