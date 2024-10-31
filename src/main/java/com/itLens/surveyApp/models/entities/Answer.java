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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private String id;

    @NotBlank
    @Size(max = 255)
    @Column(
            name = "answer",
            unique = true,
            nullable = false
    )
    private String answer;

    @Column(
            name = "selectionCount"
    )
    private int selectionCount;

    @NotBlank
    @ManyToOne
    @JoinColumn(
            name = "questionId",
            nullable = false
    )
    private Question question;

    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
