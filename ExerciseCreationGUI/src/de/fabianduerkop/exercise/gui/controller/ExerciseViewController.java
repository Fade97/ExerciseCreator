package de.fabianduerkop.exercise.gui.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.fabianduerkop.exercise.ExerciseGenerator;
import de.fabianduerkop.exercise.exercises.ExercisePacket;
import de.fabianduerkop.exercise.exercises.ResultPacket;
import de.fabianduerkop.exercise.gui.views.ExerciseView;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ExerciseViewController {
    
    private ExerciseView exerciseView;
    private ExercisePacket packet;
    private ResultPacket result;
    private IntegerProperty solved = new SimpleIntegerProperty();

    public ExerciseViewController(ExercisePacket packet) {
        this.packet = packet;
        this.exerciseView = new ExerciseView();
        this.exerciseView.getExplanation().setText(this.packet.getExerciseText().stream().collect(Collectors.joining("\n")));
        this.exerciseView.getCheckResultBtn().setOnAction(e->{
            checkExercise();
        });
    }
    
    
    public ExerciseView getExerciseView() {
        return this.exerciseView;
    }
    
    private void checkExercise() {
        List<String> answer = Arrays.asList(this.exerciseView.getAnswer().getText().split("\n"));
        this.result = ExerciseGenerator.instance().checkExercisePacket(packet.getExerciseUID(), packet.getuID(), answer);
        if(result != null) {
            this.exerciseView.getExplanation().setText(this.result.explanation.stream().collect(Collectors.joining("\n")));
            this.solved.set(result.isCorrect ? 1 : 2);
        }
    }


    public IntegerProperty solvedProperty() {
        return solved;
    }

}
