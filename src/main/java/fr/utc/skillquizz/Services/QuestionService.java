package fr.utc.skillquizz.services;

import fr.utc.skillquizz.models.Question;
import fr.utc.skillquizz.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestion(Long questionId){
        return this.questionRepository.findById(questionId).orElseThrow();
    }

    public void deleteQuestion(Long questionId){
        this.questionRepository.findById(questionId);
        this.questionRepository.deleteQuestionById(questionId);
    }

    public Question createQuestion(Question question){
        System.out.println("Question name : " + question.getId());
        return this.questionRepository.save(question);
    }

    public Question updateQuestion(Question question, Long questionId){
        System.out.println("Question name : " + question.getId());
        Question questionToUpdate = getQuestion(questionId);
        questionToUpdate.setOrder() = question.getOrder();
        questionToUpdate.setText() = question.getText();
        questionToUpdate.setActive() = question.getActive();
        questionToUpdate.setVersion() = question.getVersion();
        return this.questionRepository.save(questionToUpdate);
    }

}
