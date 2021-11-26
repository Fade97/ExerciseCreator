package de.fabianduerkop.exercise.exercises;

public interface Exercise {
	public ExercisePacket createExercise(int difficulty);
	public String getDisplayName();
	public String getUuid();
}
