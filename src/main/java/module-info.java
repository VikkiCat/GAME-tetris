module com.tetris.tetrisgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tetris.tetrisgame to javafx.fxml;
    exports com.tetris.tetrisgame;
}