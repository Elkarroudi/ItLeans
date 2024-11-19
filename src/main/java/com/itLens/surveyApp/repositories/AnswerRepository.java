package com.itLens.surveyApp.repositories;

import com.itLens.surveyApp.models.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {

    List<Answer> getAllByQuestionId(String questionId);
}

