package extras.javafx;
//A JavaFX application skeleton
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;


public class JavaFXSkeleton extends Application {	
	//override init()
	public void init() {
		System.out.println("Inside the init() method");
	}
	//override start()
	public void start(Stage myStage) {
		System.out.println("Inside the start() method");
		myStage.setTitle("JavaFX Skeleton");
		
		//create root node
		FlowPane rootNode = new FlowPane();
		//create a scene
		Scene myScene = new Scene(rootNode, 300, 200);
		//set the scene on the stage
		myStage.setScene(myScene);
		//show the stage and its scene
		myStage.show();
	}
	
	public void stop() {
		System.out.println("Inside the stop() method");
	}
	
	public static void main(String[] args) {
		System.out.println("Launching JavaFX application");
		launch(args);
	}
}
