# Tetris Game (JavaFX)
A simple implementation of the classic Tetris game using JavaFX. This project demonstrates core game mechanics like piece movement, rotation, line clearing, scoring, and game-over detection, all rendered using JavaFX components.

## Features
✅ Classic Tetris gameplay\
✅ Supports standard Tetris shapes (I, J, L, O, S, T, Z)\
✅ Smooth block movement and rotation\
✅ Score tracking (50 points per cleared line)\
✅ Line count display\
✅ Game over detection and exit\
✅ Simple UI with real-time updates

## Screenshots
![START-1](https://github.com/VikkiCat/GAME-tetris/assets/33381663/44afc73f-4ec0-4644-8a29-a79bd9f0487b)

## Game Controls
↑ - Change rotation\
↓ - Down (faster down)\
→ - Right\
← - Left

# How to Run
## Requirements
Java 8 or higher\
JavaFX SDK (if not bundled with your JDK)

## Compile
```bash
javac -d out src/com/tetris/tetrisgame/*.java
```

## Run
```bash
java -cp out com.tetris.tetrisgame.Tetris
```
> Alternatively, you can run it directly from your IDE (IntelliJ IDEA, Eclipse, NetBeans).

## Controls
| Key       | Action                 |
| --------- | ---------------------- |
| **LEFT**  | Move piece left        |
| **RIGHT** | Move piece right       |
| **DOWN**  | Move piece down faster |
| **UP**    | Rotate the piece       |

## Code Structure
```bash
src/com/tetris/tetrisgame/
├── Tetris.java        // Main class handling game logic, rendering, input
├── Form.java          // (Assumed) Represents a tetromino form
├── Controller.java    // (Assumed) Provides static methods for movement and piece creation
```

```bash
Tetris.java
```
Contains the primary game loop, rendering logic, and event handling for key presses.

```bash
Form.java
```
Represents individual Tetris shapes, holds rectangles for each block of a shape.

```bash
Controller.java
```
Responsible for creating new tetrominoes and controlling their movement.

## Game Logic Overview
Grid size: 12 × 24 blocks\

Block size: 25px\

Score: +50 points per cleared row\

Line clear: Rows are checked and removed when full\

Game over: Triggered when new pieces collide at the top

## License
This project is provided as-is for educational purposes. Feel free to modify and enhance it!
