package de.fabianduerkop.exercise.exercises;

import java.util.List;

public class ExercisePacket {
    private String exerciseUID;
    private String uID;
	private List<String> exerciseText;
	private List<String> possibleAnswers; 
	private int level;
	
	/**
	 * 
	 * @param uID - A unique string representing this exercise. May not contain the characters '[' or ']'.
	 * @param exerciseText - A list of strings containing the text used to describe the exercise.
	 */
	public ExercisePacket(String exerciseUID, String uID, List<String> exerciseText) {
		this(exerciseUID, uID, exerciseText, null);
	}
	
	/**
	 * 
	 * @param uID - A unique string representing this exercise. May not contain the characters '[' or ']'.
	 * @param exerciseText - A list of strings containing the text used to describe the exercise.
	 * @param possibleAnswers - A list of strings containing the possible answers to the exercise. These could be used as checkboxes later on.
	 */
	public ExercisePacket(String exerciseUID, String uID, List<String> exerciseText, List<String> possibleAnswers) {
		this.exerciseUID = exerciseUID;
	    this.uID = uID;
		this.exerciseText = exerciseText;
		this.possibleAnswers = possibleAnswers;
	}
	
	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public List<String> getExerciseText() {
		return exerciseText;
	}

	public void setExerciseText(List<String> exerciseText) {
		this.exerciseText = exerciseText;
	}

	public List<String> getPossibleAnswers() {
		return possibleAnswers;
	}

	public void setPossibleAnswers(List<String> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getExerciseUID() {
        return exerciseUID;
    }
}
