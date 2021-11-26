package de.fabianduerkop.exercise.exercises;

import java.util.List;

public interface ProvableExercise extends Exercise {
	public ResultPacket checkAnswer(String uID, List<String> answer);
}
