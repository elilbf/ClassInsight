package br.com.edu.classinsight.service;

import br.com.edu.classinsight.dto.FeedbackDTO;
import br.com.edu.classinsight.entity.Feedback;
import br.com.edu.classinsight.repository.FeedbackRepository;
import br.com.edu.classinsight.enums.Urgencia;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Slf4j
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void criarAvaliacao(FeedbackDTO dto){
    log.info("Salvando nova avaliacao: descricao='{}' nota={}", dto.descricao(), dto.nota());
        Feedback feedback = new Feedback();
        feedback.setDescricao(dto.descricao());
        feedback.setNota(dto.nota());
        feedback.setUrgencia(Urgencia.fromNota(dto.nota()).asString());
        feedback.setCriadoEm(LocalDateTime.now());

        feedbackRepository.save(feedback);
        log.info("Avaliacao salva com sucesso: id={}", feedback.getId());
    }

}
