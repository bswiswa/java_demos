package extras.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application implements EventHandler<ActionEvent> {
	// override methods init(), start() and stop()
	// add stage
	// add rootNode
	// add top label, checkboxes, and 2 labels after
	// addAll components to rootNode
	// show the stage
	Label lastAction;
	Label allSelected;
	CheckBox smartPhone;
	CheckBox tablet;
	CheckBox notebook;
	CheckBox desktop;

	public void init() {
		System.out.println("init()");
	}

	public void start(Stage stage) {
		stage.setTitle("JavaFX CheckBox");
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 5, 5);
		rootNode.setAlignment(Pos.CENTER_LEFT);
		Scene scene = new Scene(rootNode, 400, 200);
		Label topLabel = new Label("Checkbox(es) select");
		lastAction = new Label("");
		allSelected = new Label("");
		smartPhone = new CheckBox("Smart Phone");
		tablet = new CheckBox("Tablet");
		notebook = new CheckBox("Notebook");
		desktop = new CheckBox("Desktop");

		smartPhone.setOnAction(this);
		tablet.setOnAction(this);
		notebook.setOnAction(this);
		desktop.setOnAction(this);

		rootNode.getChildren().addAll(topLabel, smartPhone, tablet, notebook, desktop, lastAction, allSelected);
		stage.setScene(scene);
		stage.show();
	}

	public void stop() {
		System.out.println("stop()");
	}

	@Override
	public void handle(ActionEvent ae) {
		CheckBox src = (CheckBox) ae.getSource();
		String name = src.getText();
		String last = "", all = "All Selected: ";
		if (src.isSelected())
			last += name + " selected";
		else
			last += name + " unselected";

		lastAction.setText(last);

		if (smartPhone.isSelected()) {
			all += " Smart Phone";
		}
		if (tablet.isSelected()) {
			all += " Tablet";
		}
		if (notebook.isSelected()) {
			all += " Notebook";
		}
		if (desktop.isSelected()) {
			all += " Desktop";
		}
		allSelected.setText(all);
	}
	
	public static void main(String[] args) {
		System.out.println("main()");
		launch(args);
	}
}
