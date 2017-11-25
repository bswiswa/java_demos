package extras.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class EffectsAndTransformsDemo extends Application {
	double angle = 0.0;
	double scaleFactor = 0.4;
	double blurVal = 1.0;
	// initial effects and transforms
	Reflection reflection = new Reflection();
	BoxBlur blur = new BoxBlur(1.0, 1.0, 1);
	Rotate rotate = new Rotate();
	Scale scale = new Scale(scaleFactor, scaleFactor);
	// buttons
	Button btnRotate = new Button("Rotate");
	Button btnBlur = new Button("Blur off");
	Button btnScale = new Button("Scale");

	Label reflect = new Label("Reflection Adds Visual Sparkle");

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		stage.setTitle("Effects and Transforms Demo");

		FlowPane rootNode = new FlowPane(20, 20);
		rootNode.setAlignment(Pos.CENTER);

		Scene scene = new Scene(rootNode, 300, 120);
		stage.setScene(scene);

		btnRotate.getTransforms().add(rotate);
		btnScale.getTransforms().add(scale);
		reflection.setTopOpacity(0.7);
		reflection.setBottomOpacity(0.3);
		reflect.setEffect(reflection);

		// handle action events
		// rotate
		btnRotate.setOnAction(ae -> {
			angle += 15.0;
			rotate.setAngle(angle);
			rotate.setPivotX(btnRotate.getWidth() / 2);
			rotate.setPivotY(btnRotate.getHeight() / 2);
		});

		// scale
		btnScale.setOnAction(ae -> {
			scaleFactor += 0.1;
			if (scaleFactor > 2.0)
				scaleFactor = 0.4;
			scale.setX(scaleFactor);
			scale.setY(scaleFactor);
		});

		// blur
		btnBlur.setOnAction(ae -> {
			// change blur status each time button is pressed
			if (blurVal == 10.0) {
				blurVal = 1.0;
				btnBlur.setEffect(null);
				btnBlur.setText("Blur off");
			} else {
				blurVal++;
				btnBlur.setEffect(blur);
				btnBlur.setText("Blur on");
			}
			blur.setWidth(blurVal);
			blur.setHeight(blurVal);
		});

		// add label and buttons to scene graph
		rootNode.getChildren().addAll(btnRotate, btnScale, btnBlur, reflect);

		// show
		stage.show();
	}
}
