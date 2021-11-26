# ExerciseCreator
ExerciseCreator is an Application to create and solve Exercises.\
It is written in Java and designed to easily create exercise generators.
## Development
The code is split into two seperate projects - **ExerciseCreation** and **ExerciseCreationGUI**. The GUI project depends on the ExerciseCreation project.
### Eclipse
To develop in Eclipse you have to import both projects into your workspace and configure the build path.
1. `File` -> `Import..` -> `Existing Projects into Workspace` -> Set `Select root directory` to the root path of this repository.
2. Check both the `ExerciseCreation` and `ExerciseCreationGUI` projects under `Projects:` and hit `Finish`.
3. `Right Click` on `ExerciseCreationGUI` in your package explorer and select `Properties`.
4. Go to `Java Build Path` -> `Projects` -> `Add` and select `ExerciseCreation` -> `Apply and Close`.

### Creating an exercise
You can take a look at the examples in `de.fabianduerkop.exercise.exercises.math` - `ExerciseArithmetic` and `ExerciseMathQuiz`. \
\
To create an exercise your class should extend `MinimalExample` and override the methods `createExercise` and `checkAnswer`. You also need to register your class in `de.fabianduerkop.exercise.ExerciseRegister`.

## Features
- [x] Support for custom exercise generators
- [x] Simple GUI
- [ ] Fancy GUI
- [ ] Support for code exercises
- [ ] More exercise types