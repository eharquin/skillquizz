package fr.utc.skillquizz.services;

import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class AnswerService {

    @Autowired
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer getAnswer(Long channelId){
        return this.answerRepository.findById(channelId).orElseThrow();
    }

    public void deleteAnswer(Long answerId){
        this.answerRepository.findById(answerId);
        this.answerRepository.deleteAnswerById(answerId);
    }

    public Answer createAnswer(Answer answer){
        System.out.println("Answer name : " + answer.getId());
        return this.answerRepository.save(answer);
    }

}
