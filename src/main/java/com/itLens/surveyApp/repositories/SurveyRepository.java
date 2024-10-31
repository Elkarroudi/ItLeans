package com.itLens.surveyApp.repositories;

import com.itLens.surveyApp.models.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, String> {
}

