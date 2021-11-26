package de.fabianduerkop.exercise.gui.controller;

import java.util.List;
import java.util.stream.Collectors;

import de.fabianduerkop.exercise.ExerciseGenerator;
import de.fabianduerkop.exercise.exercises.Exercise;
import de.fabianduerkop.exercise.exercises.ExercisePacket;
import de.fabianduerkop.exercise.gui.components.ExercisePacketListItem;
import de.fabianduerkop.exercise.gui.views.TopicView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

public class TopicViewController {
    private TopicView topicView;
    private Exercise exercise;
    private ExerciseViewController exerciseViewController;

    public TopicViewController(String exerciseUUID) {
        this.topicView = new TopicView();
        List<ExercisePacket> packets = ExerciseGenerator.instance().getExercisePackets(exerciseUUID, 10, 1);

        this.topicView.getExercisePacketList().setMaxWidth(200);
        packets.forEach(e -> {
            ExercisePacketListItem packetItem = new ExercisePacketListItem(e);
            this.topicView.getExercisePacketList().getItems().add(packetItem);
        });
        this.topicView.getExercisePacketList().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            createExerciseView(
                    this.topicView.getExercisePacketList().getSelectionModel().getSelectedItem().getPacket());
        });
    }

    private void createExerciseView(ExercisePacket packet) {
        this.exerciseViewController = new ExerciseViewController(packet);

        this.exerciseViewController.solvedProperty().addListener((sObservable, sOldValue, sNewValue) -> {
            if (sNewValue.intValue() == 1) {
                this.topicView.getExercisePacketList().getSelectionModel().getSelectedItem()
                        .setBackground(Color.PALEGREEN);
                this.topicView.getExercisePacketList().getSelectionModel().selectNext();
            } else if (sNewValue.intValue() == 2) {
                this.topicView.getExercisePacketList().getSelectionModel().getSelectedItem()
                        .setBackground(Color.PALEVIOLETRED);
            }

        });

        this.topicView.setCenter(this.exerciseViewController.getExerciseView());
        this.exerciseViewController.getExerciseView().requestFocus();
    }

    public TopicView getTopicView() {
        return this.topicView;
    }
}
