import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class GUI implements IOManager, ActionListener{
	private JFrame window;
	private JPanel pane;
	private JScrollPane scrollPane;
	JTextArea textArea;
	int command;
	boolean hasCommand;
	public GUI(){
		window = new JFrame("JUAPJJ v.0.2.4 Release Candidate");
		pane = new JPanel();
		textArea = new JTextArea();
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollPane= new JScrollPane(textArea);
		command = -1;
		launchGUI();
	}
	private void launchGUI(){
		pane.setLayout(new	BorderLayout());
		scrollPane.setPreferredSize(new Dimension(700,500));
		pane.add(scrollPane,BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,4));
		pane.add(buttonPanel);
		textArea.setEditable(false);
		pane.add(buttonPanel,BorderLayout.SOUTH);
		JButton b = new JButton("F1");
		b.addActionListener(this);
		b.setActionCommand(b.getText());
		buttonPanel.add(b);
		b = new JButton("F2");
		b.addActionListener(this);
		b.setActionCommand(b.getText());
		buttonPanel.add(b);
		b = new JButton("F3");
		b.addActionListener(this);
		b.setActionCommand(b.getText());
		buttonPanel.add(b);
		b = new JButton("F4");
		b.addActionListener(this);
		b.setActionCommand(b.getText());	
		buttonPanel.add(b);
		window.setContentPane(pane);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
	public String getActionCommand(){
		return null;
	}
	public int getCommand(){
		int readedCommand;
		while(command < 0){
			try{
				Thread.sleep(100);
			}catch(Exception e){}
		}
		readedCommand = command;
		command = -1;
		return readedCommand;
	}
	public String getString(String title){
		return JOptionPane.showInputDialog(title);
	}
	public void showMessage(String m){
		textArea.append(m + "\n");
	}
	public void actionPerformed(ActionEvent evt){
		String cmd = evt.getActionCommand();
		if(cmd.equals("F1")) command = 1;
		else if(cmd.equals("F2")) command = 2;
		else if(cmd.equals("F3")) command = 3;
		else if(cmd.equals("F4")) command = 4;
	}
	public void waitInteraction(){
		getCommand();
	}
	
	public void clearScreen(){
		textArea.setText(null);
	}
}
