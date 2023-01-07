package resources;

import application.PrimaryPanel;

public class VotingRegistration {
	
	public static void countVotes() {
		
		int 
		    ciroGomes = PrimaryPanel.ciroGomes,
		    Lula = PrimaryPanel.Lula,
            robertoJefferson = PrimaryPanel.robertoJefferson,
            simoneTebet = PrimaryPanel.simoneTebet,
            Vera = PrimaryPanel.Vera,
            sofiaManzano = PrimaryPanel.sofiaManzano,
            jairBolsonaro = PrimaryPanel.jairBolsonaro,
            Eymael = PrimaryPanel.Eymael,
            Davila = PrimaryPanel.Davila,
            sorayaThronicke = PrimaryPanel.sorayaThronicke,
            leoPericles = PrimaryPanel.leoPericles,
            pabloMarcal = PrimaryPanel.pabloMarcal,
            voteNull = PrimaryPanel.voteNull,
		    blanck = PrimaryPanel.blanck,
	        nVotos = PrimaryPanel.confirm;
		
		System.out.println(
				"Total de Votos: " + nVotos
				+ "\n12 - CIRO GOMES (PDT) = " + ciroGomes
				+ "\n13 - LULA (PT) = " + Lula
				+ "\n14 - ROBERTO JEFFERSON (PTB) = " + robertoJefferson
				+ "\n15 - SIMONE TEBET (MDB) = " + simoneTebet
				+ "\n16 - VERA (PSTU) = " + Vera
				+ "\n21 - SOFIA MANZANO (PCB) = " + sofiaManzano
				+ "\n22 - JAIR BOLSONARO (PL) = " + jairBolsonaro
				+ "\n27 - CONSTITUINTE EYMAEL (DC) = " + Eymael
				+ "\n30 - FELIPE D'AVILA (NOVO) = " + Davila
				+ "\n44 - SORAYA THRONICKE (UNIÃO) = " + sorayaThronicke
				+ "\n80 - LÉO PÉRICLES (UP) = " + leoPericles
				+ "\n90 - PABLO MARÇAL (PROS) = " + pabloMarcal
				+ "\nVotos BRANCOS = " + blanck
				+ "\nVotos NULOS = " + voteNull
				+ "\n\n"
				);

	}

	public static void main(String[] args) {
		
	}
}