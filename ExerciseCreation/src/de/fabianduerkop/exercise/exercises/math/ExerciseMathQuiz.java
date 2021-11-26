package de.fabianduerkop.exercise.exercises.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fabianduerkop.exercise.exercises.ExercisePacket;
import de.fabianduerkop.exercise.exercises.MinimalExample;
import de.fabianduerkop.exercise.exercises.ResultPacket;

public class ExerciseMathQuiz extends MinimalExample {
    private List<List<String>> tasks = new ArrayList<>();
    private Map<String, Double> results = new HashMap<>();
    private int currentIndex = 0;

    public ExerciseMathQuiz() {
        this.displayName = "Mathe Quiz";
        this.tasks.add(Arrays.asList(new String[] {
                "Tim hat zum Geburtstag eine neue Autorennbahn erhalten. Mit seinem Freund Tom fahren die beiden sofort ein Rennen. Doch der rote Rennwagen braucht 2 Sekunden länger als der blaue Rennwagen, der für eine Runde genau 7 Sekunden benötigt.",
                "",
                "Wie lange müssen die Jungs ihren Joystick gedrückt halten, damit beide Autos wieder gemeinsam durch das Ziel fahren?" }));
        this.results.put("0", 63.0);
        this.tasks.add(Arrays.asList(new String[] {
                "Obwohl ich Sie noch nie gesehen habe, weiß ich genau, was Sie in diesem Rätsel denken. Sie glauben mir nicht? Lassen Sie uns beginnen!",
                "", "1. Denken Sie sich eine zweistellige Zahl aus, die nicht durch 10 teilbar ist",
                "2. Multiplizieren Sie diese Zahl mit 9", "3. Bilden Sie von diesem Ergebnis die Quersumme",
                "4. Ist die zweite Ziffer, Ihrer am Anfang gewählten Zahl, größer als die erste, dann multiplizieren Sie Ihre Quersumme mit 4. Ist die erste Ziffer größer oder beide Zahlen gleich, dann multiplizieren Sie Ihre Quersumme mit 2." }));
        this.results.put("1", 36.0);
        this.tasks.add(Arrays.asList(new String[] {
                "Fünf Freunde treffen sich an einem Montagabend in ihrer Stammkneipe und wollen ein kleines Dart-Turnier veranstalten. Jeder der Spieler muss bei diesem Turnier einmal gegen jeden spielen. Ein Spiel kostet am Dartautomaten 2.-Euro.",
                "", "Wie viele Geld müssen die Freunde insgesamt für die Spiele ausgeben?" }));
        this.results.put("2", 36.0);
    }

    @Override
    public ExercisePacket createExercise(int difficulty) {
        ExercisePacket packet = super.createExercise(difficulty);
        packet.setExerciseText(this.tasks.get(currentIndex));
        packet.setuID(String.valueOf(currentIndex++));
        if (currentIndex >= this.tasks.size()) {
            currentIndex = 0;
        }
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
            if (line.replace('.', ',').equals(solution) || line.replace(',', '.').equals(solution)) { // Input has
                                                                                                      // decimal places
                packet.explanation.clear();
                packet.explanation.add("Super, das ist richtig!");
                packet.isCorrect = true;
                break;
            } else if (decimalPlace.equals(".0") && solution.substring(0, solution.indexOf('.')).equals(line)) { // Input
                                                                                                                 // is
                                                                                                                 // an
                                                                                                                 // integer
                packet.explanation.clear();
                packet.explanation.add("Super, das ist richtig!");
                packet.isCorrect = true;
                break;
            }
        }
        return packet;
    }

}
