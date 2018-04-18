package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Model.*;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 95);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        gridpane.add(new Label("Vector #1: "), 0, 0);
        gridpane.add(new Label("Vector #2: "), 0, 1);

        Button btnCompute = new Button("Get Sum");
        gridpane.add(btnCompute, 0, 2);

        TextField fldVec1 = new TextField();
        fldVec1.focusedProperty().addListener((arg, oldValue, newValue) -> {
            if(!newValue){
                // numbers and commas only
                Validation.validateTextField(fldVec1, "^(?:\\d\\,?)+$");
            }
        });
        gridpane.add(fldVec1, 1, 0);

        TextField fldVec2 = new TextField();
        fldVec2.focusedProperty().addListener((arg, oldValue, newValue) -> {
            if(!newValue){
                // numbers and commas only
                Validation.validateTextField(fldVec2, "^(?:\\d\\,?)+$");
            }
        });
        gridpane.add(fldVec2, 1, 1);

        Label lblResult = new Label();
        gridpane.add(lblResult, 1, 2);

        btnCompute.setOnAction(e -> {
            String text1 = fldVec1.getText();
            String text2 = fldVec2.getText();

            if(text1.isEmpty() || text2.isEmpty()){
                new Alert(Alert.AlertType.ERROR).showAndWait();
                return;
            }

            String[] strvec1 = text1
                    .replaceAll("\\s+","")
                    .split(",");
            String[] strvec2 = text2
                    .replaceAll("\\s+","")
                    .split(",");

            Integer[] vec1 = new Integer[strvec1.length], vec2 = new Integer[strvec2.length];

            int i = 0;
            for(String num : strvec1){
                vec1[i++] = Integer.parseInt(num);
            }

            i = 0;
            for(String num : strvec2){
                vec2[i++] = Integer.parseInt(num);
            }

            Integer[] result = {};
            try {
                result = Summator.sumVectors(vec1, vec2);
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Result");
            alert.setHeaderText(Arrays.toString(result));

            alert.showAndWait();

            fldVec1.clear();
            fldVec2.clear();
        });

        root.setCenter(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}