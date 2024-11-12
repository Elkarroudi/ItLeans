package com.itLens.surveyApp.repositories;

import com.itLens.surveyApp.models.entities.SurveyEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyEditionRepository extends JpaRepository<SurveyEdition, String> {

    List<SurveyEdition> getAllBySurveyId(String surveyId);
}

