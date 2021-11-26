package de.fabianduerkop.exercise.gui.views;

import de.fabianduerkop.exercise.ExerciseGenerator;
import de.fabianduerkop.exercise.exercises.Exercise;
import de.fabianduerkop.exercise.gui.controller.TopicViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {

    public MainView() {
        createMenu();
    }
    
    private void createMenu() {
        MenuBar menuBar = new MenuBar();
        final Menu file = new Menu("Datei");
        
        final Menu exercises = new Menu("Übungen");
        for(final Exercise e : ExerciseGenerator.instance().getExercises()) {
            final MenuItem exercise = new MenuItem(e.getDisplayName());
            exercise.setOnAction(ev ->{
                MainView.this.setCenter(new TopicViewController(e.getUuid()).getTopicView());
            });
            exercises.getItems().add(exercise);
        }
        
        menuBar.getMenus().addAll(file, exercises);
        this.setTop(menuBar);
    }

}
