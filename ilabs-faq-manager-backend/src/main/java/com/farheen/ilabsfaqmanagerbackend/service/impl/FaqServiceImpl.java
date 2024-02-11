package com.farheen.ilabsfaqmanagerbackend.service.impl;

import com.farheen.ilabsfaqmanagerbackend.dto.FaqDTO;
import com.farheen.ilabsfaqmanagerbackend.model.Faq;
import com.farheen.ilabsfaqmanagerbackend.repository.FaqRepo;
import com.farheen.ilabsfaqmanagerbackend.service.FaqService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaqServiceImpl implements FaqService {

    @Autowired
    private FaqRepo faqRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FaqDTO createFaq(FaqDTO faqDTO) {
        faqRepo.save(modelMapper.map(faqDTO,Faq.class));
        return faqDTO;
    }

    @Override
    public List<FaqDTO> findAllFaq() {
        List<Faq> faqList= faqRepo.findAll();
        return modelMapper.map(faqList, new TypeToken<List<FaqDTO>>(){}.getType());
    }

    @Override
    public Optional<Faq> findFaqByQuestionTitle(String questionTitle) {
        Optional<Faq> faqSearch = faqRepo.findByQuestionTitle(questionTitle);
        return modelMapper.map(faqSearch, new TypeToken<Optional<FaqDTO>>(){}.getType());
    }

    @Override
    public boolean deleteFaq(int id) {
        faqRepo.deleteById(id);
        return true;
    }
}
