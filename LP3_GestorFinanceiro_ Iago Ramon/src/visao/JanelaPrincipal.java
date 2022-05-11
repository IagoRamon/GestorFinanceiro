package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {
	private jpDashboard Dashboard;
	private jpDespesa Despesas;
	private jpReceita Receitas;
	private jpOrcamento Orcamento;
	private JTabbedPane tabbedPane;

	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(700, 535));
		setLocationRelativeTo(null);
		setTitle("Iago Ramon - Trabalho de LP3");
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(228, 228, 228));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		//tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.addTab("Dashboard", null, getJPDashboard(), null);
		tabbedPane.addTab("Receitas", null, getJPReceitas(), null);
		tabbedPane.addTab("Despesas", null, getJPDespesas(), null);
		tabbedPane.addTab("Orcamento", null, getOrcamento(), null);

	}

	public void mostrar() {
		repaint();
		validate();

		setVisible(true);
	}

	public jpDashboard getJPDashboard() {
		if (Dashboard == null) {
			Dashboard = new jpDashboard();
			Dashboard.getLbl_icone_saldo().setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/Imagens/saldo atual.png")));
			Dashboard.getLbl_icone_receitas().setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/Imagens/receitas.png")));
			Dashboard.getLbl_icone_despesas().setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/Imagens/despesas.png")));
			Dashboard.getLbl_icone_saldo().setSize(44, 32);
			Dashboard.getLbl_icone_despesas().setLocation(130, 5);
			Dashboard.getLbl_icone_saldo().setLocation(124, 3);
			Dashboard.getLbl_icone_receitas().setLocation(125, 5);
			Dashboard.getLblSaldoValor().setLocation(34, 32);
			// Dashboard.getPanel_principal_despesas().setBounds(0, 0, 623, 62);
		}
		return Dashboard;
	}

	public jpDespesa getJPDespesas() {
		if (Despesas == null) {
			Despesas = new jpDespesa();
			Despesas.getPanel_principal_despesas().setBounds(0, 0, 623, 62);
		}
		return Despesas;
	}

	public jpReceita getJPReceitas() {
		if (Receitas == null) {
			Receitas = new jpReceita();
			Receitas.getTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Receitas.getTabela().setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "ID", "Data", "Descri\u00E7\u00E3o", "Valor" }));
		}
		return Receitas;
	}

	public JTabbedPane getJTabbedPane() {
		return tabbedPane;
	}

	public jpOrcamento getOrcamento() {
		if (Orcamento == null) {
			Orcamento = new jpOrcamento();
			Orcamento.getBtnAddItem().setBounds(481, 350, 109, 23);
			
		}
		return Orcamento;
	}
}
