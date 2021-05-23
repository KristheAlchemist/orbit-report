package org.javaportfolio.quizapp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractQuestion {

    @Id
    @GeneratedValue
    private int questionId;

    @NotNull(message="Question is required.")
    @NotBlank(message="Question is required.")
    private String questionText;

    @NotNull(message="Answer is required.")
    @NotBlank(message="Answer is required.")
    private String correctAnswer;
}
