package de.fabianduerkop.exercise.gui.components;

import de.fabianduerkop.exercise.exercises.ExercisePacket;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ExercisePacketListItem extends VBox {
    private ExercisePacket packet;
    private int maxPreviewLength = 20;
    Label previewLbl = new Label();

    public ExercisePacketListItem(ExercisePacket packet) {

        this.packet = packet;
        Label uidLbl = new Label("Level: " + packet.getLevel());
        String preview = "";
        for (String line : this.getPacket().getExerciseText()) {
            preview += line;
            if (preview.length() > this.maxPreviewLength) {
                preview = preview.substring(0, maxPreviewLength);
                preview += "...";
                break;
            }
        }
        previewLbl.setTextOverrun(OverrunStyle.ELLIPSIS);
        previewLbl.setText(preview);
        this.getChildren().addAll(uidLbl, previewLbl);
        this.setPadding(Insets.EMPTY);
    }

    public void setPacket(ExercisePacket packet) {
        this.packet = packet;
    }

    public ExercisePacket getPacket() {
        return packet;
    }
    
    public void setBackground(Color color) {
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
