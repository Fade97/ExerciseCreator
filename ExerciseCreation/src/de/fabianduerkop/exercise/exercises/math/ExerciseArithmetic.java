package de.fabianduerkop.exercise.exercises.math;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fabianduerkop.exercise.exercises.ExercisePacket;
import de.fabianduerkop.exercise.exercises.MinimalExample;
import de.fabianduerkop.exercise.exercises.ResultPacket;

public class ExerciseArithmetic extends MinimalExample{
	private Map<String, Double> results = new HashMap<>();
	
	public ExerciseArithmetic() {
        this.displayName = "Arithmetik";
    }
	
	@Override
	public ExercisePacket createExercise(int difficulty) {
		// Call the base createExercise to setup the uid and initialize everything
		ExercisePacket packet = super.createExercise(difficulty);
		String exerciseLine = "";

		// Generate an exercise
		for (int i = 0; i < difficulty * 2; i++) {
			int number = 0;
			do {
				number = (int) (Math.random() * 10 * difficulty);
				
				if(difficulty > 3) {
					number = Math.random() > 0.5 ? number*-1 : number; 
				}
				
			} while(exerciseLine.length() > 2 && exerciseLine.charAt(exerciseLine.length()-2) == '/' && number == 0);
			exerciseLine += number;

			if (i < difficulty * 2 - 1) {
				exerciseLine += " ";
				double rng = Math.random();
				if (rng < 1. / 4) {
					exerciseLine += "+";
				} else if (rng < (1. / 4) * 2) {
					exerciseLine += "-";
				} else if (rng < (1. / 4) * 3) {
					exerciseLine += "*";
				} else if (rng < (1. / 4) * 4) {
					exerciseLine += "/";
				}
				exerciseLine += " ";
			}
		}

		// Add the exercise to the packet along some text
		packet.getExerciseText().add("Berechnen Sie die folgende Gleichung: ");
		packet.getExerciseText().add(exerciseLine);


		// Generate the result for the exercise and store it for later
		double result = (int)(HelperMath.eval(exerciseLine) * 100);
		result /= 100;
		results.put(packet.getuID(), result);

		return packet;
	}

	@Override
	public ResultPacket checkAnswer(String uID, List<String> answer) {
		// Call the base checkAnswer to get a ResultPacket
		ResultPacket packet = super.checkAnswer(uID, answer);
		// Get the correct solution using the UID
		String solution = Double.toString(results.get(uID));

		// Check if the answer is correct and give the user an explanation if it's not
		packet.explanation.add("Die richtige Antwort wäre " + solution + " gewesen.");

		for (String line : answer) {
		    line = line.trim();
			String decimalPlace = solution.substring(solution.indexOf('.'));
			if (line.replace('.', ',').equals(solution) || line.replace(',', '.').equals(solution)) { // Input has decimal places
				packet.explanation.clear();
				packet.explanation.add("Super, das ist richtig!");
				packet.isCorrect = true;
				break;
			}else if(decimalPlace.equals(".0") && solution.substring(0, solution.indexOf('.')).equals(line) ) { // Input is an integer
				packet.explanation.clear();
				packet.explanation.add("Super, das ist richtig!");
				packet.isCorrect = true;
				break;
			}
		}
		return packet;
	}

	
}
