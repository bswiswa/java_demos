package extras.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		stage.setTitle("JavaFX TextField Demo");
		FlowPane rootNode = new FlowPane(10, 10);
		rootNode.setAlignment(Pos.CENTER);
		Scene scene = new Scene(rootNode, 300, 200);
	
		Label label = new Label("List of names: ");
		TextField tf = new TextField();
		tf.setPrefColumnCount(15);
		tf.setPromptText("Enter name");
		Button save = new Button("Add");
		//handlers
		save.setOnAction(ae -> {
			String txt = label.getText();
			String nm = tf.getText();
			if (nm.length() > 0) {
				txt += " "+ nm;
				label.setText(txt);
				tf.setText("");
			}
		});
		tf.setOnAction(ae -> {
			String txt = label.getText();
			String nm = tf.getText();
			if (nm.length() > 0) {
				txt += " " + nm;
				label.setText(txt);
				tf.setText("");
			}
		});
		//use a separator to better organize layout
		Separator separator = new Separator();
		separator.setPrefWidth(300);
		rootNode.getChildren().addAll(tf, save, separator, label);
		stage.setScene(scene);
		stage.show();
	}
}
