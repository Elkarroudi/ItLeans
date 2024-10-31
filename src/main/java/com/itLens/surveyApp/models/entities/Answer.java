package com.itLens.surveyApp.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(
            name = "questionId",
            nullable = false
    )
    private Question question;

}
