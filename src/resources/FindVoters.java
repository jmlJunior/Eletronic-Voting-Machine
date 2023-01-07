package resources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import votersregistration.Voters;
import application.PrimaryPanel;

public class FindVoters extends Thread {

	public String name;
	public String voterTitle, voterName, votedTitle, votedName, found;

	public FindVoters(String name) {
		this.name = name;
	}

	public void run() {

		String titleNumber = PrimaryPanel.titleNumber.getText();

		List<Voters> listOfVoted = new ArrayList<>();
		String path = "D:\\JAVA\\Temp\\ws-eclipse\\Electronic Voting Machine\\archive\\VotersSummary.txt";
		try (BufferedReader brVoted = new BufferedReader(new FileReader(path))) {
			String votedLine = brVoted.readLine();
			while (votedLine != null) {
				String[] voted = votedLine.split(",");
				votedTitle = voted[0];
				listOfVoted.add(new Voters(votedTitle, votedName));
				if (votedTitle.equals(titleNumber)) {
					found = "yes";
					JOptionPane.showMessageDialog(null, "ERRO! O voto deste(a) eleitor(a) já foi registrado!");
					ThreadBack back = new ThreadBack("Back", 0);
					back.start();
				}
				votedLine = brVoted.readLine();
			}
		} catch (Exception z) {
			z.printStackTrace();
		}

		List<Voters> listOfVoters = new ArrayList<>();
		String votersRoster = "D:\\JAVA\\Temp\\ws-eclipse\\Electronic Voting Machine\\archive\\Voters.csv";

		try (BufferedReader brVoters = new BufferedReader(new FileReader(votersRoster))) {
			String votersLine = brVoters.readLine();
			while (votersLine != null) {
				String[] voter = votersLine.split(",");
				voterTitle = voter[0];
				voterName = voter[1];

				if (voterTitle.equals(titleNumber) && found == null) {
					listOfVoters.add(new Voters(voterTitle, voterName));
					JOptionPane.showMessageDialog(null, "Eleitor(a) " + voterName + " encontrado(a) com sucesso!");
				} 

				votersLine = brVoters.readLine();
			}
			
			if (listOfVoters.isEmpty() && found == null) {
				JOptionPane.showMessageDialog(null, "Eleitor(a) não cadastrado(a) nesta seção eleitoral!");
				ThreadBack back = new ThreadBack("Back", 0);
				back.start();
			}
			
			for (Voters i : listOfVoters) {
				String newPath = "D:\\JAVA\\Temp\\ws-eclipse\\Electronic Voting Machine\\archive\\VotersSummary.txt";
				String[] lines = new String[] { i.getTitle() + "," + i.getName() };
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(newPath, true))) {
					for (String newLines : lines) {
						bw.write(newLines);
						bw.newLine();
					}
				} catch (Exception x) {
					x.getMessage();
				}
			}

		} catch (Exception y) {
			y.printStackTrace();
		}
	}
}