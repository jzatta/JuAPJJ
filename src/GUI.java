import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GUI implements IOManager, ActionListener{
	private JFrame window;
	private JPanel pane;
	JTextArea textArea;
	int command;
	boolean hasCommand;
	public GUI(){
		window = new JFrame();
		pane = new JPanel();
		textArea = new JTextArea(200,100);
		command = -1;
		launchGUI();
	}
	private void launchGUI(){
		//pane.setPreferredSize(new Dimension(400,500));
		pane.setLayout(new BorderLayout());
		JPanel textPanel, buttonPanel, c3;
		textPanel = new JPanel();
		pane.add(textPanel,BorderLayout.WEST);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
		c3 = new JPanel();
		c3.setLayout(new BorderLayout());
		c3.add(buttonPanel,BorderLayout.CENTER);
		pane.add(c3,BorderLayout.EAST);
		
		textArea.setEditable(false);
		textPanel.add(textArea);

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
}
