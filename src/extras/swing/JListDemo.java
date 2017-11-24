package extras.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListDemo implements ActionListener, ListSelectionListener {
	//set container, size, display property, close
	//create components
	//text field
	//scrollable list
	//label to display chosen names
	JTextField txt = new JTextField(40);
	static String[] names = new String[]{ "Ruvarashe Moyo", "Batsirai Swiswa", "Tsitsi Moyo", "Alex Mazuru", "Chipo Swiswa", "Shingirai Swiswa", "Tianchi Wu", "Victor Mutai" };
	JList<String> l = new JList<>(names);
	JLabel updates = new JLabel();
	JLabel selected = new JLabel();
	JListDemo(){
	JFrame fr = new JFrame("Working with Lists");
	fr.setSize(500, 200);
	fr.setLayout(new FlowLayout());
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	txt.addActionListener(this);
	l.addListSelectionListener(this);
	
	JScrollPane scrollList = new JScrollPane(l);
	scrollList.setPreferredSize(new Dimension(120, 60));
	fr.add(txt);
	fr.add(scrollList);
	fr.add(updates);
	fr.add(selected);
	
	fr.setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		String newName = txt.getText();
		if(newName.length() > 0) {
			int[] selection = l.getSelectedIndices();
			for(int i = 0; i < selection.length; i++) {
				if(newName.equals(JListDemo.names[selection[i]])) {
					selected.setText(newName + " is selected");
					break;
				}
				if(i == selection.length - 1) {
					selected.setText(newName + " is not selected");
				}
			}
		}
	}
	
	public void valueChanged(ListSelectionEvent le) {
		int[] s = l.getSelectedIndices();
		String t = "Selected names: ";
		for(int i = 0; i < s.length; i++) {
				t += " " + JListDemo.names[s[i]];
		}
		updates.setText(t);
		selected.setText("");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JListDemo();
			}
		});
	}
	
}
