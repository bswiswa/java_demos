package extras.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonDemo extends Application{
	//override methods init(), start(), stop()
	//implement setOnAction(EventHandler<ActionEvent> handler)
	//main()
	//add components
	//add to scene
	//setScene
	//show
	
	public void init() {
		System.out.println("init()");
	}
	
	public void start(Stage stage) {
		stage.setTitle("JavaFX button");
		
		FlowPane rootNode = new FlowPane(10, 10);
		rootNode.setAlignment(Pos.CENTER);
		
		Scene s = new Scene(rootNode, 700, 90);
		
		Label l = new Label("Push a button");
		Button up = new Button("up");
		up.setOnAction(ae-> l.setText("Clicked up"));
		Button down = new Button("down");
		down.setOnAction(ae-> l.setText("Clicked down"));
		rootNode.getChildren().addAll(up, down, l);
		
		stage.setScene(s);
		
		stage.show();
	}
	
	public void stop() {
		System.out.println("stop()");
	}
	
	public static void main(String[] args) {
		System.out.println("main()");
		launch(args);
	}
}
