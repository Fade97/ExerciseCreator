package de.fabianduerkop.exercise.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MinimalExample implements ProvableExercise {

	protected String displayName = "N/D";
	protected String uuid = UUID.randomUUID().toString();

    @Override
	public ExercisePacket createExercise(int difficulty) {
		String uID = UUID.randomUUID().toString();
		List<String> exerciseText = new ArrayList<>();
		ExercisePacket p = new ExercisePacket(this.uuid, uID, exerciseText);
		p.setLevel(difficulty);
		return p;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public ResultPacket checkAnswer(String uID, List<String> answer) {
		List<String> explainationList = new ArrayList<>();
		boolean isCorrectAnswer = false;
		
		
		return new ResultPacket(isCorrectAnswer, explainationList);
	}
	
	@Override
    public String getUuid() {
        return uuid;
    }

}
