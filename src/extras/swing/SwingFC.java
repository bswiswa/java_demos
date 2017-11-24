//a simple GUI to compare files
package extras.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SwingFC implements ActionListener{
	JTextField jtfFirst;
	JTextField jtfSecond;
	
	JButton jbtnComp;
	
	JLabel jlabFirst, jlabSecond, jlabResult;
	
	SwingFC(){
		JFrame jfrm = new JFrame("Compare Files");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(200,  190);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtfFirst = new JTextField(14);
		jtfSecond = new JTextField(14);
		
		jtfFirst.setActionCommand("fileA");
		jtfSecond.setActionCommand("fileB");
		
		jbtnComp = new JButton("Compare");
		jbtnComp.addActionListener(this);
		
		jlabFirst = new JLabel("First file: ");
		jlabSecond = new JLabel("Second file: ");
		jlabResult = new JLabel();
		
		jfrm.add(jlabFirst);
		jfrm.add(jtfFirst);
		jfrm.add(jlabSecond);
		jfrm.add(jtfSecond);
		jfrm.add(jbtnComp);
		jfrm.add(jlabResult);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		int i=0, j=0;
		//check if filenames have been entered
		if(jtfFirst.getText().equals("")) {
			jlabResult.setText("First file name missing.");
			return;
		}
		if(jtfSecond.getText().equals("")) {
			jlabResult.setText("Second file name missing.");
			return;
		}
		
		//compare files...
		try(FileInputStream f1 = new FileInputStream(jtfFirst.getText());
			FileInputStream f2 = new FileInputStream(jtfSecond.getText())){
			
			do {
				i = f1.read();
				j = f2.read();
				if(i != j) break;
			} while(i != -1 && j != -1);
			
			if(i != j)
				jlabResult.setText("Files are not the same");
			else
				jlabResult.setText("Files are equal");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingFC();
			}
		});
	}
}
