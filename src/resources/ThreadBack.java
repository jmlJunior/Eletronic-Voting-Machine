package resources;


import java.lang.Thread;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import application.PrimaryPanel;

public class ThreadBack extends Thread {
	
    JLabel candidateImg = PrimaryPanel.candidateImg;
    JLabel viceImg = PrimaryPanel.viceImg;
    JLabel candidateName = PrimaryPanel.candidateName;
    JLabel politicalParty = PrimaryPanel.politicalParty;
    JLabel end = PrimaryPanel.end;
    JEditorPane titleNumber = PrimaryPanel.titleNumber;
    JPasswordField passwordField = PrimaryPanel.passwordField;
    JTabbedPane tabbedPane = PrimaryPanel.tabbedPane;
    JTextField tenBox = PrimaryPanel.tenBox;
    JTextField oneBox = PrimaryPanel.oneBox;
	
	public String name;
	public int tempo;

	public ThreadBack(String name, int tempo) {
		this.name = name;
		this.tempo = tempo;
		
	}
	
	public void run() {
		try {	        	
        	Thread.sleep(tempo);	    		   
        	tabbedPane.setEnabledAt(1, false);
        	tabbedPane.setSelectedIndex(0);
        	titleNumber.setText("");
            passwordField.setText("");
            titleNumber.requestFocus();
            candidateImg.setText("");
            viceImg.setText("");
            candidateName.setText("");
            politicalParty.setText("");
            end.setText("");
            tenBox.setEditable(true);
            oneBox.setEditable(true);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}