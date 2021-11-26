package de.fabianduerkop.exercise.exercises;

import java.util.List;

public class ResultPacket {
	public boolean isCorrect;
	public List<String> explanation;
	
	/**
	 * 
	 * @param isCorrect - A boolean to indicate whether the answer was correct or not.
	 * @param explanation - A List of Strings explaining why the answer may be wrong or additional information if the answer is correct.
	 */
	public ResultPacket(boolean isCorrect, List<String> explanation) {
		this.isCorrect = isCorrect;
		this.explanation = explanation;
	}
}
