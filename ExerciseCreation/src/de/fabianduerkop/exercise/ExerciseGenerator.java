package de.fabianduerkop.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.fabianduerkop.exercise.exercises.Exercise;
import de.fabianduerkop.exercise.exercises.ExercisePacket;
import de.fabianduerkop.exercise.exercises.ProvableExercise;
import de.fabianduerkop.exercise.exercises.ResultPacket;

public class ExerciseGenerator {
    private static ExerciseGenerator instance = null;
    private Map<String, Exercise> exerciseMap;
    private List<ExercisePacket> exercisePackets;

    private ExerciseGenerator() {
        
    }
    
    public static ExerciseGenerator instance() {
        if(ExerciseGenerator.instance == null) {
            ExerciseGenerator.instance = new ExerciseGenerator();
            ExerciseGenerator.instance.init();
            ExerciseGenerator.instance.listExercises();
        }
        return ExerciseGenerator.instance;
    }

    public void debug() {
        this.exerciseMap.forEach((k, e) -> {
            getExercisePackets(k, 10, 1);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            for (ExercisePacket packet : exercisePackets) {
                printExercisePacket(packet);
                ResultPacket result = null;
                try {
                    String solution = reader.readLine();
                    ArrayList<String> solutionList = new ArrayList<>();
                    solutionList.add(solution);
                    result = checkExercisePacket(e.getUuid(), packet.getuID(), solutionList);
                } catch (NumberFormatException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                } catch (IOException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                }
                if (result != null) {
                    printResultPacket(result);
                }
            }
        });

    }

    private void init() {
        this.exerciseMap = new HashMap<String, Exercise>();
        this.exercisePackets = new ArrayList<>();
        ExerciseRegister.register();
    }

    public ReturnValue registerExercise(Exercise exercise) {
        if (!exerciseMap.containsKey(exercise.getDisplayName())) {
            exerciseMap.put(exercise.getDisplayName(), exercise);
            return ReturnValue.ok;
        }
        return ReturnValue.alreadyExists;
    }

    public List<ExercisePacket> getExercisePackets(String UUID, int amount, int difficulty) {
        if (amount < 0 || getExercise(UUID) == null) {
            return null;
        }

        Exercise selectedExercise = getExercise(UUID);
        List<ExercisePacket> exercisesPackets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            exercisesPackets.add(selectedExercise.createExercise(difficulty));
        }
        this.exercisePackets.addAll(exercisesPackets);
        return exercisesPackets;
    }

    public void printExercisePacket(ExercisePacket packet) {
        System.out.println("[" + packet.getuID() + "]");
        for (String line : packet.getExerciseText()) {
            System.out.println(line);
        }
    }

    public ResultPacket checkExercisePacket(String UUID, String UID, List<String> answerList) {
        Exercise thisExercise = getExercise(UUID);
        if (thisExercise instanceof ProvableExercise) {
            ResultPacket thisResult = ((ProvableExercise) thisExercise).checkAnswer(UID, answerList);
            return thisResult;
        }
        return null;
    }

    public void printResultPacket(ResultPacket packet) {
        for (String line : packet.explanation) {
            System.out.println(line);
        }
    }

    public void removeExercisePacket(String UID) {
        this.exercisePackets.removeAll(this.exercisePackets.stream().filter(e -> {
            return e.getuID().equals(UID);
        }).collect(Collectors.toList()));
    }

    public void listExercises() {
        exerciseMap.forEach((k, e) -> {
            System.out.println(k);
        });
    }

    public List<Exercise> getExercises() {
        return new ArrayList<Exercise>(this.exerciseMap.values());
    }

    public Exercise getExercise(String exerciseUUID) {
        List<Exercise> ex = getExercises().stream().filter(e->{
            return e.getUuid().equals(exerciseUUID);
        }).collect(Collectors.toList());
        if(ex.size() > 0) {
            return ex.get(0);
        }
        return null;
    }

}
