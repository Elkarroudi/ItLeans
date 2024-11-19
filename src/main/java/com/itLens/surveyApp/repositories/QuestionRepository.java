package com.itLens.surveyApp.repositories;

import com.itLens.surveyApp.models.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {

    List<Question> getAllBySubjectId(String subjectId);
}

