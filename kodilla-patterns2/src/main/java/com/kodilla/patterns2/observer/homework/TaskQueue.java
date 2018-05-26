package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements Observable {
    private String studentname;
    private List<String> exercises;
    private List<Observer> observers;

    public TaskQueue(String studentname) {
        this.studentname = studentname;
        exercises = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addExercise(String title) {
        exercises.add(title);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    public String getStudentname() {
        return studentname;
    }

    public List<String> getExercises() {
        return exercises;
    }
}
