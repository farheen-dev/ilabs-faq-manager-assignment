package com.farheen.ilabsfaqmanagerbackend.controller;

import com.farheen.ilabsfaqmanagerbackend.dto.FaqDTO;
import com.farheen.ilabsfaqmanagerbackend.model.Faq;
import com.farheen.ilabsfaqmanagerbackend.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/faq")
public class FaqController {

    @Autowired
    private FaqService faqService;

    @PostMapping(path="/saveFaq")
    public FaqDTO createFaq(@RequestBody FaqDTO faqDTO) {
        return faqService.createFaq(faqDTO);
    }

    @GetMapping(path="/getFaqs")
    public List<FaqDTO> getAllFaq() {
        return faqService.findAllFaq();
    }

    @GetMapping(path = "/getFaq/{questionTitle}")
    public Optional<Faq> check(@PathVariable("questionTitle") String questionTitle) {
        Optional<Faq> faq = faqService.findFaqByQuestionTitle(questionTitle);
        return faq;
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteFaq(@PathVariable int id) {
        return faqService.deleteFaq(id);
    }
}
