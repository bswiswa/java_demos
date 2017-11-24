package extras.swing;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JCheckBoxDemo implements ItemListener{
	//set top-level container
		//size, layout, close
	//set components
		// 3 checkboxed, label for last action, label for all selected
	//main
	JLabel current = new JLabel();
	JLabel allSelected = new JLabel();
	JCheckBox alpha = new JCheckBox("alpha");
	JCheckBox beta = new JCheckBox("beta");
	JCheckBox gamma = new JCheckBox("gamma");
	
	JCheckBoxDemo(){
	JFrame fr = new JFrame("Working with checkboxes");
	fr.setSize(950, 90);
	fr.setLayout(new FlowLayout());
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JLabel label = new JLabel("Select checkbox(es)");
	fr.add(label);
	
	alpha.addItemListener(this);
	beta.addItemListener(this);
	gamma.addItemListener(this);
	fr.add(alpha	);
	fr.add(beta);
	fr.add(gamma	);
	fr.add(current);
	fr.add(allSelected);
	
	fr.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent ie) {
		JCheckBox checkBox = (JCheckBox)ie.getItem();
		String label = checkBox.getText();
		String out = "";
		
		if(checkBox.isSelected()) {
			out += "Selected "+ label;
		}else {
			out+= "Unselected "+ label;
		}
		current.setText(out);
		String all = "Currently selected: ";
		if(alpha.isSelected()) all+= " alpha";
		if(beta.isSelected()) all+= " beta";
		if(gamma.isSelected()) all+= " gamma";
		allSelected.setText(all);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JCheckBoxDemo();
			}
		});
	}
}
