package extras.swing;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingDemo {
	SwingDemo(){
// Create the top-level container		
		// Create a JFrame Container
		JFrame jframe = new JFrame("A Simple Swing Application");
		//Give the frame an initial size
		jframe.setSize(275, 100);
		//Terminate the program when the user closes the application
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
// Create the Components
		//Create a text-based label
		JLabel jlabel = new JLabel("GUI Programming with Swing");
		//Add the label to the content pane [panes are part of the top-level containers eg JFrame]

// Add the components
		jframe.add(jlabel);
// Display the top-level container
		jframe.setVisible(true);
	}
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		// Create the frame on the event dispatching thread
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				new SwingDemo();
			}
		});
	}
}
