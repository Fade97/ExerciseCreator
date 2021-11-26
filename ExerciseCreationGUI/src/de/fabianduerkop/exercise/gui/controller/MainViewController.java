package de.fabianduerkop.exercise.gui.controller;

import de.fabianduerkop.exercise.gui.views.MainView;

public class MainViewController {
    private MainView mainView;
    
    public MainViewController() {
        this.mainView = new MainView();
    }
    
    public MainView getMainView() {
        return this.mainView;
    }
}
