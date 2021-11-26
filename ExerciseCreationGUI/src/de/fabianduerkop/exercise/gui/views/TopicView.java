package de.fabianduerkop.exercise.gui.views;

import de.fabianduerkop.exercise.gui.components.ExercisePacketListItem;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class TopicView extends BorderPane{
    private ListView<ExercisePacketListItem> exercisePacketList;
    
    public TopicView() {
        this.exercisePacketList = new ListView<>();
        this.exercisePacketList.setPadding(Insets.EMPTY);
        this.setLeft(this.exercisePacketList);
    }

    public ListView<ExercisePacketListItem> getExercisePacketList() {
        return exercisePacketList;
    }
    
}
