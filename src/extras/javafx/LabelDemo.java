package extras.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LabelDemo  extends Application{
	//override methods from Application - init(), start() and stop()
	//inside start()
		//receive stage
		//create root node
		//create scene on root node
		//add label to child nodes of scene
		//show the stage
	public void init() {
		System.out.println("init()");
	}
	public void start(Stage stage) {
		System.out.println("start()");
		stage.setTitle("JavaFX Label");
		FlowPane rootNode = new FlowPane();
		Scene scene = new Scene(rootNode, 300, 200);
		Label l = new Label("A simple label");
		rootNode.getChildren().add(l);
		stage.setScene(scene);
		stage.show();
	}
	public void stop() {
		System.out.println("stop()");
	}
	public static void main(String[] args) {
		System.out.println("main()");
		launch();
	}
	
}
