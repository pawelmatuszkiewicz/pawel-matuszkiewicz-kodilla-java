package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int notifyCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        System.out.println("Mentor " + mentorName + ": New exercise to review from " +
            taskQueue.getStudentname() + " [total #" + taskQueue.getExercises().size() + "]");
        notifyCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getNotifyCount() {
        return notifyCount;
    }
}
