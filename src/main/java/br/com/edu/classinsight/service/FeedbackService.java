package br.com.edu.classinsight.service;

import br.com.edu.classinsight.dto.FeedbackDTO;
import br.com.edu.classinsight.entity.Feedback;
import br.com.edu.classinsight.repository.FeedbackRepository;
import br.com.edu.classinsight.enums.Urgencia;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void criarAvaliacao(FeedbackDTO dto){

        Feedback feedback = new Feedback();
        feedback.setDescricao(dto.descricao());
        feedback.setNota(dto.nota());
        feedback.setUrgencia(Urgencia.fromNota(dto.nota()).asString());
        feedback.setCriadoEm(LocalDateTime.now());

        feedbackRepository.save(feedback);
    }

}
