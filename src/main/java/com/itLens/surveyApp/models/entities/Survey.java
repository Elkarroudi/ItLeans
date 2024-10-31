package com.itLens.surveyApp.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(
            name = "title",
            unique = true,
            nullable = false
    )
    private String title;

    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "ownerId",
            nullable = false
    )
    private Owner owner;

    @OneToMany(
            mappedBy = "survey",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL

    )
    private List<SurveyEdition> editions;

}
