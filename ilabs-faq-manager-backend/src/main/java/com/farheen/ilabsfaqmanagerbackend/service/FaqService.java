package com.farheen.ilabsfaqmanagerbackend.service;

import com.farheen.ilabsfaqmanagerbackend.dto.FaqDTO;
import com.farheen.ilabsfaqmanagerbackend.model.Faq;

import java.util.List;
import java.util.Optional;

public interface FaqService {
    FaqDTO createFaq(FaqDTO faqDTO);
    List<FaqDTO> findAllFaq();
    Optional<Faq> findFaqByQuestionTitle(String questionTitle);
    boolean deleteFaq(int id);
}
