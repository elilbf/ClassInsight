package br.com.edu.classinsight.controller;

import br.com.edu.classinsight.dto.FeedbackDTO;
import br.com.edu.classinsight.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    private final FeedbackService feedbackService;

    public AvaliacaoController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Void> criarAvaliacao(@RequestBody FeedbackDTO feedback){
        feedbackService.criarAvaliacao(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
