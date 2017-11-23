package extras.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JButtonDemo implements ActionListener {
	JLabel l;
	JButtonDemo(){
		// create top-level container
		JFrame fr = new JFrame("JButton Demo");
			// define its size
		fr.setSize(220, 90);
			//set its layout
		fr.setLayout(new FlowLayout());
			//allow it to close the program
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//define components
		l = new JLabel("Click button");
		JButton down = new JButton("up");
		JButton up = new JButton("down");
		//define their size
		down.setSize(50, 100);
		up.setSize(50, 100);
		//add event handlers
		down.addActionListener(this);
		up.addActionListener(this);
		fr.add(down);
		fr.add(up);
		fr.add(l);
		fr.setVisible(true);
	}
	
	//define actionPerformed() method to handle events
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("down"))
			l.setText("Clicked down");
		else
			l.setText("Clicked up");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JButtonDemo();
			}
		});
	}
}
