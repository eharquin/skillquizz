package fr.utc.skillquizz.services;

import fr.utc.skillquizz.models.Question;
import fr.utc.skillquizz.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        System.out.println("Question name : " + questionId);
        Question questionToUpdate = getQuestion(questionId);
        questionToUpdate.setOrder(question.getOrder());
        questionToUpdate.setText(question.getText());
        questionToUpdate.setActive(question.isActive());
        questionToUpdate.setVersion(question.getVersion());
        return this.questionRepository.save(questionToUpdate);
    }

    public List<Question> getList() {
       return  questionRepository.findAll();
    }

    public Question getById(long questionId) {
       return  questionRepository.findById(questionId).orElseThrow();
    }
}
