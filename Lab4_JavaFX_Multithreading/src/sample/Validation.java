package sample;


import javafx.scene.control.TextField;

/**
 * <h1>Validation models class<h1/>
 * <p>
 *     provides a set of static methods for validation of user's data
 * </p>
 */
public final class Validation {
    public static void validateTextField(TextField field, String regex){
        String temp = field.getText().replaceAll("\\s+","");
        if(!temp.matches(regex)){
            field.setStyle("-fx-border-color: red;");
            field.setText("");
        }
        else {
            field.setStyle(null);
        }
    }
}
