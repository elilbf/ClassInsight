package br.com.edu.classinsight.controller;

import br.com.edu.classinsight.dto.FeedbackDTO;
import br.com.edu.classinsight.service.FeedbackService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    private final FeedbackService feedbackService;

    public AvaliacaoController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Void> criarAvaliacao(@Valid @RequestBody FeedbackDTO feedback){
        log.info("Recebendo nova avaliacao: descricao='{}' nota={}", feedback.descricao(), feedback.nota());
        feedbackService.criarAvaliacao(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("ok");
    }

}
