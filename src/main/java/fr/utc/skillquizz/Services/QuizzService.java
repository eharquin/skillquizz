package fr.utc.skillquizz.services;

import fr.utc.skillquizz.dto.QuizzDto;
import fr.utc.skillquizz.models.Quizz;
import fr.utc.skillquizz.repositories.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuizzService {

    @Autowired
    private final QuizzRepository quizzRepository;

    public QuizzService(QuizzRepository quizzRepository) {

        this.quizzRepository = quizzRepository;
    }

    public Quizz getQuizz(long quizzId){

        return this.quizzRepository.findById(quizzId).orElse(null);
    }

    public void deleteQuizz(Long quizzId){
        this.quizzRepository.findById(quizzId);
        this.quizzRepository.deleteQuizzById(quizzId);
    }

    public Quizz createQuizz(Quizz quizz){
        System.out.println("Answer name : " + quizz.getId());
        return this.quizzRepository.save(quizz);
    }

    public Quizz updateQuizz(long quizzToUpdateId, Quizz quizz){
        System.out.println("Answer name : " + quizz.getId());
        Quizz quizzToUpdate = getQuizz(quizzToUpdateId);
        quizzToUpdate.setActive(quizz.isActive());
        quizzToUpdate.setSkill(quizz.getSkill());
        quizzToUpdate.setUser(quizz.getUser());

        return this.quizzRepository.save(quizzToUpdate);
    }

    public List<Quizz> getQuizzesList() {
        return this.quizzRepository.findAll();
    }
}
