package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import resources.ThreadClear;
import resources.FindVoters;
import resources.ThreadBack;
import resources.VotingRegistration;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PrimaryPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, 
	               boardMemberPanel, 
	               votingPanel;
	
	public static JTabbedPane tabbedPane;
	public static JEditorPane titleNumber;
	public static JPasswordField passwordField;
	
	public static JTextField tenBox,
	                         oneBox;
	
	public static JLabel candidateName,
	                     viceName,
	                     candidateImg,
	                     viceImg,
	                     politicalParty,
	                     end;
	
	public static String dn, un, dnun;
	public static int vote, confirm, blanck, voteNull, 
	                  ciroGomes, Lula, robertoJefferson, 
	                  simoneTebet, Vera, sofiaManzano,
			          jairBolsonaro, Eymael, Davila, 
			          sorayaThronicke, leoPericles, pabloMarcal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimaryPanel frame = new PrimaryPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	Create the frame.
	**/
	public PrimaryPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 689, 398);
		contentPane.add(tabbedPane);
		
		/**
		setting the board member panel
		**/	
		boardMemberPanel = new JPanel();
		tabbedPane.addTab("Painel do Mesário", null, boardMemberPanel, null);
		boardMemberPanel.setLayout(null);
		
		JLabel title = new JLabel("N\u00FAmero do T\u00EDtulo de Eleitor");
		title.setFont(new Font("Tahoma", Font.BOLD, 12));
		title.setBounds(43, 33, 187, 14);
		boardMemberPanel.add(title);
		
		titleNumber = new JEditorPane();
		titleNumber.setBounds(43, 58, 204, 20);
		boardMemberPanel.add(titleNumber);
		titleNumber.requestFocus();
		
		JLabel password = new JLabel("SENHA do MES\u00C1RIO - Liberar Vota\u00E7\u00E3o");
		password.setFont(new Font("Tahoma", Font.BOLD, 12));
		password.setBounds(43, 120, 240, 14);
		boardMemberPanel.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(43, 145, 204, 20);
		boardMemberPanel.add(passwordField);
		
		JPanel edge = new JPanel();
		edge.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		edge.setBounds(24, 21, 371, 245);
		boardMemberPanel.add(edge);
		
		JLabel electoralJustice = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Justiça Eleitoral - Brasão.jpg")).getImage()
				                                 .getScaledInstance(230, 245, Image.SCALE_SMOOTH);
		electoralJustice.setIcon(new ImageIcon(img));
		electoralJustice.setBounds(420, 21, 230, 245);
		boardMemberPanel.add(electoralJustice);
		
		JButton btnResult = new JButton("PRINT");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(passwordField.getPassword());
				if (!senha.equals("123")) {
					JOptionPane.showMessageDialog(null, "SENHA INCORRETA!");
					passwordField.setText("");
					passwordField.requestFocus();
				}
				if (senha.equals("123")) {
				    VotingRegistration.countVotes();
				    
				    FileWriter arq;
					try {
						arq = new FileWriter("D:\\JAVA\\Temp\\ws-eclipse\\Electronic Voting Machine\\archive\\RESULTS.txt");
						PrintWriter gravarArq = new PrintWriter(arq);
						
						gravarArq.println(
								"Total de Votos: " + confirm
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
						
						JOptionPane.showMessageDialog(null, "Resultado de Urna gerado com sucesso no Diretório D:\\JAVA\\Temp\\ws-eclipse\\Electronic Voting Machine\\archive\\!!!");

						arq.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					passwordField.setText("");
				}

			}
		});
		btnResult.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnResult.setBackground(Color.WHITE);
		btnResult.setBounds(347, 288, 86, 36);
		boardMemberPanel.add(btnResult);
		
		JButton btnClear = new JButton("CORRIGE");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleNumber.setText("");
				passwordField.setText("");
				titleNumber.requestFocus();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClear.setBackground(Color.ORANGE);
		btnClear.setBounds(443, 288, 94, 36);
		boardMemberPanel.add(btnClear);
		
		JButton btnEnter = new JButton("CONFIRMA");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(passwordField.getPassword());
				if (!senha.equals("123")) {
					JOptionPane.showMessageDialog(null, "SENHA INCORRETA!");
					passwordField.setText("");
					passwordField.requestFocus();
				}
				if (titleNumber.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo TÍTULO DE ELEITOR deve ser preenchido!");
				}
				if (!titleNumber.getText().equals("") && senha.equals("123")) {					
					/**
					thread to check the names of voters registered
					**/
					FindVoters treadFr = new FindVoters ("Find");
					treadFr.start();

					tabbedPane.setEnabledAt(1, true);
					tabbedPane.setSelectedIndex(1);
					dn = "";
				    tenBox.requestFocus();
				}
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEnter.setBackground(Color.GREEN);
		btnEnter.setBounds(544, 279, 93, 45);
		boardMemberPanel.add(btnEnter);

		/**
		end of board member panel settings
		
		*********************************************************************************************************************************************
		
		setting the voting panel
		**/
		
		votingPanel = new JPanel();
		tabbedPane.addTab("Painle de Votação", null, votingPanel, null);
		votingPanel.setLayout(null);
		tabbedPane.setEnabledAt(1, false);
		
		JLabel head = new JLabel("SEU VOTO PARA");
		head.setFont(new Font("Tahoma", Font.BOLD, 12));
		head.setBounds(43, 33, 100, 14);
		votingPanel.add(head);
		
		JLabel office = new JLabel("PRESIDENTE");
		office.setFont(new Font("Calibri", Font.BOLD, 22));
		office.setBounds(100, 79, 120, 23);
		votingPanel.add(office);
		
		JLabel number = new JLabel("N\u00FAmero:");
		number.setFont(new Font("Tahoma", Font.BOLD, 10));
		number.setBounds(43, 123, 46, 14);
		votingPanel.add(number);

		tenBox = new JTextField();
		tenBox.setHorizontalAlignment(SwingConstants.CENTER);
		tenBox.setFont(new Font("Tahoma", Font.PLAIN, 38));
		tenBox.setColumns(10);
		tenBox.setBounds(120, 105, 33, 55);
		votingPanel.add(tenBox);
		tenBox.requestFocus();
		
		oneBox = new JTextField();
		oneBox.setHorizontalAlignment(SwingConstants.CENTER);
		oneBox.setFont(new Font("Tahoma", Font.PLAIN, 38));
		oneBox.setColumns(10);
		oneBox.setBounds(155, 105, 33, 55);
		votingPanel.add(oneBox);
		
		JLabel name = new JLabel("Nome:");
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.setBounds(43, 205, 46, 14);
		votingPanel.add(name);

		JLabel group = new JLabel("Partido:");
		group.setFont(new Font("Tahoma", Font.BOLD, 12));
		group.setBounds(43, 230, 60, 14);
		votingPanel.add(group);
		
		candidateName = new JLabel("");
		candidateName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		candidateName.setBounds(88, 204, 310, 14);
		votingPanel.add(candidateName);
		
		politicalParty = new JLabel("");
		politicalParty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		politicalParty.setBounds(100, 230, 94, 14);
		votingPanel.add(politicalParty);
		
		candidateImg = new JLabel("");
		candidateImg.setFont(new Font("Arial", Font.BOLD, 65));
		candidateImg.setBounds(278, 21, 120, 160);
		votingPanel.add(candidateImg);
		
		end = new JLabel("");
		end.setFont(new Font("Tahoma", Font.PLAIN, 30));
		end.setBounds(108, 171, 112, 30);
		votingPanel.add(end);
		
		viceName = new JLabel("");
		viceName.setHorizontalAlignment(SwingConstants.RIGHT);
		viceName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		viceName.setBounds(159, 246, 169, 14);
		votingPanel.add(viceName);
		
		viceImg = new JLabel("");
		viceImg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viceImg.setHorizontalAlignment(SwingConstants.RIGHT);
		viceImg.setBounds(338, 185, 60, 75);
		votingPanel.add(viceImg);
		
		edge = new JPanel();
		edge.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		edge.setBounds(10, 11, 401, 265);
		votingPanel.add(edge);
		
		JLabel instructions = new JLabel("Aperte a tecla");
		instructions.setFont(new Font("Tahoma", Font.BOLD, 11));
		instructions.setToolTipText("");
		instructions.setBounds(30, 290, 298, 14);
		votingPanel.add(instructions);

		JLabel green = new JLabel("VERDE para CONFIRMAR");
		green.setFont(new Font("Tahoma", Font.BOLD, 11));
		green.setBounds(30, 305, 298, 14);
		votingPanel.add(green);

		JLabel orange = new JLabel("LARANJA para CORRIGIR");
		orange.setFont(new Font("Tahoma", Font.BOLD, 11));
		orange.setBounds(30, 321, 298, 14);
		votingPanel.add(orange);
		
		JLabel electoralJusticeCoat = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/Justiça Eleitoral.jpg")).getImage()
				                                  .getScaledInstance(180, 68, Image.SCALE_SMOOTH);
		electoralJusticeCoat.setIcon(new ImageIcon(img1));
		electoralJusticeCoat.setBounds(445, 33, 180, 68);
		votingPanel.add(electoralJusticeCoat);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("1");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "1";
				}
			}
		});
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("1");
					un = "1";

					if ((dn.equals("2")) && (un.equals("1"))) {
						Image img21 = new ImageIcon(this.getClass().getResource("/21.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img21));
						candidateName.setText("SOFIA MANZANO");
						politicalParty.setText("PCB");
						viceName.setText("Vice: Antonio Alves");

						Image imgv21 = new ImageIcon(this.getClass().getResource("/v21.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv21));
					}
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn1.setBounds(464, 123, 39, 30);
		votingPanel.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("2");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "2";
				}
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("2");
					un = "2";

					if ((dn.equals("1")) && (un.equals("2"))) {
						Image img12 = new ImageIcon(this.getClass().getResource("/12.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img12));
						candidateName.setText("CIRO GOMES");
						politicalParty.setText("PDT");
						viceName.setText("Vice: Ana Paula Matos");

						Image imgv12 = new ImageIcon(this.getClass().getResource("/v12.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv12));

					}

					if ((dn.equals("2")) && (un.equals("2"))) {
						Image img22 = new ImageIcon(this.getClass().getResource("/22.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img22));
						candidateName.setText("JAIR BOLSONARO");
						politicalParty.setText("PL");
						viceName.setText("Vice: Braga Netto");

						Image imgv22 = new ImageIcon(this.getClass().getResource("/v22.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv22));
					}
				}
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn2.setBounds(516, 123, 39, 30);
		votingPanel.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("3");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "3";
				}
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("3");
					un = "3";

					if ((dn.equals("1")) && (un.equals("3"))) {
						Image img13 = new ImageIcon(this.getClass().getResource("/13.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img13));
						candidateName.setText("LULA");
						politicalParty.setText("PT");
						viceName.setText("Vice: Geraldo Alckmin");

						Image imgv13 = new ImageIcon(this.getClass().getResource("/v13.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv13));
					}
				}
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn3.setBounds(565, 123, 39, 30);
		votingPanel.add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("4");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "4";
				}
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("4");
					un = "4";

					if ((dn.equals("1")) && (un.equals("4"))) {
						Image img14 = new ImageIcon(this.getClass().getResource("/14.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img14));
						candidateName.setText("ROBERTO JEFFERSON");
						politicalParty.setText("PTB");
						viceName.setText("Vice: Padre Kelmon");

						Image imgv14 = new ImageIcon(this.getClass().getResource("/v14.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv14));
					}

					if ((dn.equals("4")) && (un.equals("4"))) {
						Image img44 = new ImageIcon(this.getClass().getResource("/44.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img44));
						candidateName.setText("SORAYA THRONICKE");
						politicalParty.setText("UNIÃO");
						viceName.setText("Vice: Marcos Cintra");

						Image imgv44 = new ImageIcon(this.getClass().getResource("/v44.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv44));
					}
				}
			}
		});
		btn4.setBounds(464, 164, 39, 30);
		votingPanel.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("5");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "5";
				}
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("5");
					un = "5";

					if ((dn.equals("1")) && (un.equals("5"))) {
						Image img15 = new ImageIcon(this.getClass().getResource("/15.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img15));
						candidateName.setText("SIMONE TEBET");
						politicalParty.setText("MDB");
						viceName.setText("Vice: Mara Babrilli");

						Image imgv15 = new ImageIcon(this.getClass().getResource("/v15.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv15));
					}
				}
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn5.setBounds(516, 164, 39, 30);
		votingPanel.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("6");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "6";
				}
			}
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("6");
					un = "6";

					if ((dn.equals("1")) && (un.equals("6"))) {
						Image img16 = new ImageIcon(this.getClass().getResource("/16.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img16));
						candidateName.setText("VERA");
						politicalParty.setText("PSTU");
						viceName.setText("Vice: Raquel Tremenbé");

						Image imgv16 = new ImageIcon(this.getClass().getResource("/v16.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv16));
					}
				}
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn6.setBounds(565, 164, 39, 30);
		votingPanel.add(btn6);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("7");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "7";
				}
			}
		});
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("7");
					un = "7";

					if ((dn.equals("2")) && (un.equals("7"))) {
						Image img27 = new ImageIcon(this.getClass().getResource("/27.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img27));
						candidateName.setText("CONSTITUINTE EYMAEL");
						politicalParty.setText("DC");
						viceName.setText("Vice: Professor Bravo");

						Image imgv27 = new ImageIcon(this.getClass().getResource("/v27.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv27));
					}
				}
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn7.setBounds(464, 205, 39, 30);
		votingPanel.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("8");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "8";
				}
			}
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("8");
					un = "8";
				}
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn8.setBounds(516, 205, 39, 30);
		votingPanel.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("9");
					oneBox.setText("");
					dn = "9";
				}
			}
		});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("9");
					un = "9";
				}
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn9.setBounds(565, 205, 39, 30);
		votingPanel.add(btn9);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenBox.getText().equals("")) {
					tenBox.setText("0");
					oneBox.requestFocus();
					oneBox.setText("");
					dn = "0";
				}
			}
		});
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneBox.getText().equals("")) {
					oneBox.setText("0");
					un = "0";

					if ((dn.equals("3")) && (un.equals("0"))) {
						Image img30 = new ImageIcon(this.getClass().getResource("/30.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img30));
						candidateName.setText("FELIPE D'AVILA");
						politicalParty.setText("NOVO");
						viceName.setText("Vice: Tiago Mitraud");

						Image imgv30 = new ImageIcon(this.getClass().getResource("/v30.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv30));
					}

					if ((dn.equals("8")) && (un.equals("0"))) {
						Image img80 = new ImageIcon(this.getClass().getResource("/80.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img80));
						candidateName.setText("LÉO PÉRICLES");
						politicalParty.setText("UP");
						viceName.setText("Vice: Samara Martins");

						Image imgv80 = new ImageIcon(this.getClass().getResource("/v80.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv80));
					}

					if ((dn.equals("9")) && (un.equals("0"))) {
						Image img90 = new ImageIcon(this.getClass().getResource("/90.jpg")).getImage()
								                                   .getScaledInstance(120, 160, Image.SCALE_SMOOTH);
						candidateImg.setIcon(new ImageIcon(img90));
						candidateName.setText("PABLO MARÇAL");
						politicalParty.setText("PROS");
						viceName.setText("Vice: Fátima Pérola Neggra");

						Image imgv90 = new ImageIcon(this.getClass().getResource("/v90.jpg")).getImage()
								                                    .getScaledInstance(60, 75, Image.SCALE_SMOOTH);
						viceImg.setIcon(new ImageIcon(imgv90));
					}
				}
			}
		});

		btn0.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn0.setBounds(516, 246, 39, 30);
		votingPanel.add(btn0);
	
		JButton btnCorrige = new JButton("CORRIGE");
		btnCorrige.setBackground(Color.ORANGE);
		btnCorrige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!candidateImg.getText().equals("FIM")) {
				    Image img = new ImageIcon(this.getClass().getResource("")).getImage()
				    		                                 .getScaledInstance(120, 160,Image.SCALE_SMOOTH);
				    tenBox.setText("");
				    oneBox.setText("");
				    dn = "";
				    un = "";
				    candidateImg.setIcon(new ImageIcon(img));
				    viceImg.setIcon(new ImageIcon(img));
				    candidateImg.setText("");
				    viceName.setText("");
				    candidateName.setText("");
				    politicalParty.setText("");
				    end.setText("");
				    tenBox.requestFocus();
				}
			}
		});
		btnCorrige.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCorrige.setBounds(463, 299, 94, 36);
		votingPanel.add(btnCorrige);

		JButton btnWhite = new JButton("BRANCO");
		btnWhite.setBackground(Color.WHITE);
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!candidateImg.getText().equals("FIM")) {
					blanck++;
				    confirm++;
				    VotingRegistration.countVotes();
				
				    ThreadClear clear = new ThreadClear("Clear");
				    clear.start();
				
				    ThreadBack back = new ThreadBack("Back", 7000);
				    back.start();
				}
		    }			
		});
		btnWhite.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnWhite.setBounds(367, 299, 86, 36);
		votingPanel.add(btnWhite);

		JButton btnConfirm = new JButton("CONFIRMA");
		btnConfirm.setBackground(Color.GREEN);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if ((!tenBox.getText().equals("")) && (!oneBox.getText().equals(""))) {			
					dnun = (dn + un);
					vote = Integer.parseInt(dnun);
					confirm++;
					
				    switch (vote) {
					    case 12: ciroGomes++; break;
					    case 13: Lula++; break;
					    case 14: robertoJefferson++; break;
					    case 15: simoneTebet++; break;
					    case 16: Vera++; break;
					    case 21: sofiaManzano++; break;
					    case 22: jairBolsonaro++; break;
					    case 27: Eymael++; break;
					    case 30: Davila++; break;
					    case 44: sorayaThronicke++; break;
					    case 80: leoPericles++; break;
					    case 90: pabloMarcal++; break;
					    default: voteNull++; break;
				    }
				    
					ThreadClear clear = new ThreadClear("clear");
					clear.start();
				    
                    VotingRegistration.countVotes();
    		    }
				
				ThreadBack back = new ThreadBack("Back", 7000);
				back.start();
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConfirm.setBounds(567, 290, 93, 45);
		votingPanel.add(btnConfirm);

		
		/**
		end of voting panel settings
		**/
		
	}
}