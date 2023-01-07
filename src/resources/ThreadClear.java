package resources;

import java.awt.Image;
import java.lang.Thread;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import application.PrimaryPanel;

public class ThreadClear extends Thread {
	
    String dn = PrimaryPanel.dn;
    String un = PrimaryPanel.un;
	JLabel candidateImg = PrimaryPanel.candidateImg;
    JLabel viceImg = PrimaryPanel.viceImg;
    JLabel viceName = PrimaryPanel.viceName;
    JLabel candidateName = PrimaryPanel.candidateName;
    JLabel politicalParty = PrimaryPanel.politicalParty;
    JLabel end = PrimaryPanel.end;
    JTextField tenBox = PrimaryPanel.tenBox;
    JTextField oneBox = PrimaryPanel.oneBox;
    
	public String name;
	
	public ThreadClear(String name) {
		this.name = name;
	}
	
	public void run() {
	    Image img = new ImageIcon(this.getClass().getResource("")).getImage()
                                                 .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
	    candidateImg.setIcon(new ImageIcon(img));
	    viceImg.setIcon(new ImageIcon(img));
	    candidateImg.setText("FIM");
	    viceName.setText("");
	    candidateName.setText("");
	    politicalParty.setText("");
	    tenBox.setEditable(false);
	    oneBox.setEditable(false);
	    tenBox.setText("");
        oneBox.setText("");
		dn = "";
		un = "";
        end.setText("VOTOU");   
	}
}