package extras.javafx;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.value.*;
import javafx.collections.*;

public class ListViewDemo extends Application {
	/*
	 * A ListView can display a list of entries from which you can select one or
	 * more ListView automatically incorporates scroll bars when appropriate
	 * ListView is a generic class: class ListView<T> where T is the type of entries
	 * eg String
	 * 
	 * 1. Create the ListView - We will need to keep track of the state of our list
	 * items ie a way of Observing them and knowing when an item is selected and
	 * trigger any changes necessary - thus we need a way of placing listeners on
	 * each item in the list - a list can be a raw type that doesn't have the
	 * capabilities of noticing changes but if we want to use a ListView that
	 * observes changes and reacts to them we need to give list items additional
	 * capabilities - this is done via ObservableList<E>. An ObservableList<E> is an
	 * interface that extends the List<E> and Observable interfaces - By extending
	 * the List<E> interface, our list has to implement List capabilities eg
	 * addAll(), remove()... - By extending Observable, the list has to implement
	 * addListener() and removeListener() methods - once implemented we will now
	 * have the ability to choose to add event listeners to our list or not - we can
	 * create the ListView via ListView<T> lv = new
	 * ListView<>(FXCollections.observableArrayList(T...elements));
	 * 
	 * 2. Get selectionModel & selectedItemProperty - in order to listen to events
	 * on a ListView, we need to add a listener to its selectedItemProperty. - We
	 * cannot access the selectedItemProperty directly as it is specified in the
	 * ListView's selectionModel - thus to properly listen for change events we need
	 * to know the ListView's selection model first(single or multiple), and then
	 * add an event listener to this model's selectedItemProperty.
	 * MultipleSelectionModel<T> selModel = lv.getSelectionModel();
	 * ReadOnlyObjectProperty<T> selItemProp = selModel.selectedItemProperty();
	 * 
	 * 3. Add listener to selectedItemProperty - a change listener is supported by
	 * the ChangeListener interface which has one method void
	 * changed(ObservableValue<? extends T> changed, T oldVal, T newVal) where
	 * changed is an instance of ObservableValue<T> which encapsulates an object
	 * that can be watched for changes - use the addListener() method on the
	 * selectedItemProperty selItemProp.addListener(ChangeListener<? super T>
	 * listener)
	 */
	Label response;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		stage.setTitle("JavaFX ListView Demo");
		FlowPane rootNode = new FlowPane(10, 10);
		rootNode.setAlignment(Pos.CENTER);

		Scene scene = new Scene(rootNode, 200, 120);
		stage.setScene(scene);

		response = new Label("Select Computer Type");
		// create an ObservableList<String> of entries for the list view
		ObservableList<String> computerTypes = FXCollections.observableArrayList("Smartphone", "Tablet", "Notebook",
				"Desktop");
		// create the ListView
		ListView<String> lv = new ListView<>(computerTypes);
		// ListView size
		lv.setPrefSize(150, 70);
		// get selectionModel
		MultipleSelectionModel<String> selModel = lv.getSelectionModel();
		// get selectedItemProperty and add a listener to it
		selModel.selectedItemProperty().addListener((changed, oldVal, newVal)-> {
				// display the selection
				response.setText("Computer selected is " + newVal);
		});
		// add Label and ListView to scene graph
		rootNode.getChildren().addAll(lv, response);
		
		//show the stage
		stage.show();
	}

}
