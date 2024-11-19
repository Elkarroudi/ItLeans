package com.itLens.surveyApp.models.entities;

import com.itLens.surveyApp.models.enums.QuestionType;
import jakarta.persistence.*;
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
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(
            name = "question",
            unique = true,
            nullable = false
    )
    private String question;

    @Column(
            name = "questionType",
            nullable = false
    )
    private QuestionType questionType = QuestionType.SINGLE_CHOICE;

    @Column(name = "answerCount")
    private int answerCount;

    @ManyToOne
    @JoinColumn(
            name = "subjectId",
            nullable = false
    )
    private Subject subject;

    @OneToMany(
            mappedBy = "question",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Answer> answers;

    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
