package com.farheen.ilabsfaqmanagerbackend.repository;

import com.farheen.ilabsfaqmanagerbackend.dto.FaqDTO;
import com.farheen.ilabsfaqmanagerbackend.model.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface FaqRepo extends JpaRepository<Faq, Integer> {

    Optional<Faq> findByQuestionTitle(String questionTitle);
}
