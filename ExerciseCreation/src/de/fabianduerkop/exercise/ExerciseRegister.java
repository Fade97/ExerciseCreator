package de.fabianduerkop.exercise;

import de.fabianduerkop.exercise.exercises.math.ExerciseArithmetic;
import de.fabianduerkop.exercise.exercises.math.ExerciseMathQuiz;

final class ExerciseRegister {

	private ExerciseRegister() {
		
	}
	
	public static void register() {
		ExerciseGenerator.instance().registerExercise(new ExerciseArithmetic());
		ExerciseGenerator.instance().registerExercise(new ExerciseMathQuiz());
	}
	
}
