package de.fabianduerkop.exercise.gui.views;

import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ExerciseView extends BorderPane {
    private TextArea explanation;
    private TextArea answer;
    private Button checkResultBtn;
    
    public ExerciseView() {
        this.explanation = new TextArea();
        this.answer = new TextArea();
        this.checkResultBtn = new Button("Check Answer");
        
        this.explanation.setEditable(false);
        this.answer.setPrefHeight(99999);
        this.checkResultBtn.setPrefHeight(30);
        this.explanation.setWrapText(true);
        this.answer.setWrapText(true);
        
        this.explanation.setText("Explanation");
        this.answer.setPromptText("Answer");
        
        
        VBox answerVbox = new VBox(this.answer, this.checkResultBtn);
        SplitPane split = new SplitPane(this.explanation, answerVbox);
        split.setDividerPositions(0.3, 0.7);
        this.setCenter(split);
        this.answer.requestFocus();
    }

    public TextArea getExplanation() {
        return explanation;
    }

    public TextArea getAnswer() {
        return answer;
    }

    public Button getCheckResultBtn() {
        return checkResultBtn;
    }
    
    
}
