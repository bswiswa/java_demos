import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTextDemo implements ActionListener{
	JLabel l = new JLabel("Text field text");
	JTextField txt = new JTextField(20);
	//set frame
		//size, layout, close
	// set components
		//label, textfield, reverse button
	JTextDemo() {
	JFrame fr = new JFrame("Introducing JText");
	fr.setSize(900, 80);
	fr.setLayout(new FlowLayout());
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JLabel l2 = new JLabel("Enter text in the text field");
	txt.setActionCommand("TextField");
	JButton b = new JButton("Reverse");
	txt.addActionListener(this);
	b.addActionListener(this);
	fr.add(l2);
	fr.add(txt);
	fr.add(b);
	fr.add(l);
	fr.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String eventSource = ae.getActionCommand();
		if(eventSource.equals("TextField")) {
			String t = txt.getText();
			l.setText(t);
		}
		else if(eventSource.equals("Reverse")) {
			String t = l.getText();
			StringBuilder sb = new StringBuilder();
			for(int i=t.length()-1; i >= 0; i--) {
				sb.append(t.charAt(i));
			}
			l.setText(sb.toString());
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTextDemo();
			}
		});
	}
	
}
