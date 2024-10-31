package com.itLens.surveyApp.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surveys")
public class Survey {

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
    @Size(max = 255)
    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @NotBlank
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

    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
