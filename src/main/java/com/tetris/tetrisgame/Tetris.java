package com.tetris.tetrisgame;


import java.text.Normalizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application {

    //Variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    private static Pane groupe = new Pane();
    private static Form object;
    private static Scene scene = new Scene(groupe, XMAX + 150, YMAX);
    public static int score = 0;
    public static int top = 0;
    private static boolean game = true;
    private static Form nextObj = Controller.makeRect();
    private static int linesN = 0;

    //creating scene and start the game
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }
        //creating score and level text
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        groupe.getChildren().addAll(scoretext, line, level);

        //creating first block and the stage
        Form a = nextObj;
        groupe.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        Object a;
        nextObj = Controller.makeRect();
        stage.setScene(scene);
        stage.setTitle("TETRIS");
        stage.show();

        //Timer
        Timer fall = new Timer();
        //new java thread
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0 || object.d.getY() == 0) {
                            top++;
                        } else top = 0;

                        if (top == 2) {
                            //Game over
                            Text over = new Text("GAME OVER");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 70 arial;");
                            over.setY(250);
                            over.setX(10);
                            groupe.getChildren().add(over);
                            game = false;
                        }

                        //Exit
                        if (top == 15) {
                            System.exit(0);
                        }
                        if (game){
                            MoveDown(object);
                            scoretext.setText("Score: " + Integer.toString(score));
                            level.setText("Lines: " + Integer.toString(linesN));

                        }
                    }
                });
            }
        };

        fall.schedule(task, 0, 300);
    }

    //The control system
    private void moveOnKeyPress(Form form){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                 switch (keyEvent.getCode()){
                     case RIGHT:
                         Controller.MoveRight(form);
                         break;
                     case DOWN:
                         MoveDown(form);
                         score++;
                         break;
                     case LEFT:
                         Controller.MoveLeft(form);
                         break;
                     case UP:
                         MoveTurn(form);
                         break;
                 }
            }
        });






    }





}
