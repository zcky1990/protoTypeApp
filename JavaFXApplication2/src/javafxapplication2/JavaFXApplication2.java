/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author soeltan_z
 */
public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        
        
        //try layout
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        BorderPane border = new BorderPane();
        BorderPane innerBorder = new BorderPane();
        
        //kotak Vertical
        VBox vboxbot = new VBox();
        vboxbot.getStyleClass().add("vbox");
        innerBorder.setBottom(vboxbot);
        
        VBox vboxtop = new VBox();
        vboxtop.getStyleClass().add("vbox");
        innerBorder.setTop(vboxtop);
        border.setRight(innerBorder);
        
        //kotak horizontal
        HBox hbox = new HBox();
        hbox.getStyleClass().add("hbox");
        border.setLeft(hbox);
        
        //button
        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);
        buttonCurrent.setText("Say 'Hello World'");
        
        buttonCurrent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vboxtop.getChildren().add(new Text("asdw"));
            }
        });
        
        //text
        Text t = new Text();
        t.setText("This is a text sample");
        
        hbox.getChildren().add(buttonCurrent);
        hbox.getChildren().add(t);
        
        Scene scene = new Scene(border);
        scene.getStylesheets().add("css/layout.css");
        
        //add scene to stage
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
