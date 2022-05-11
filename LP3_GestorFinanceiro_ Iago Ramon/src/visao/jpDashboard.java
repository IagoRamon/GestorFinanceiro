package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class jpDashboard extends JPanel {
	private JPanel panel_saldo_atual;
	private JLabel lbl_saldo_atual;
	private JPanel panel_receitas;
	private JLabel lbl_receitas;
	private JPanel panel_despesas;
	private JLabel lbl_despesas;
	private JLabel lbl_RS1;
	private JLabel lblDashboard;
	private JLabel lbl_RS1_1;
	private JLabel lbl_RS1_1_1;
	private JLabel lblSaldoValor;
	private JLabel lblReceitasValor;
	private JLabel lblDespesasValor;
	private JPanel panel_principal;
	private JLabel lbltotal_d;
	private JLabel lbltotal_d_1;
	private JTextField nDespesas;
	private JTextField nReceitas;
	private JLabel lbl_acompanhamento_geral;
	private JLabel lbl_icone_saldo;
	private JLabel lbl_icone_receitas;
	private JLabel lbl_icone_despesas;
	private JScrollPane scrollPane;
	private JComboBox<String> comboBoxTipo;
	private JLabel lblNome;
	private JTable tabela;
	private JPanel panel;

	public jpDashboard() {
		// TODO Auto-generated constructor stub
		this.setSize(600, 472);
		setLayout(null);
		this.add(getPanel_saldo_atual());
		this.add(getPanel_receitas());
		this.add(getPanel_despesas());
		this.add(getPanel_principal());
		this.add(getLbltotal_d());
		this.add(getLbltotal_d_1());
		this.add(getNDespesas());
		this.add(getNReceitas());
		this.add(getLbl_acompanhamento_geral());
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		add(getScrollPane());
		add(getComboBoxTipo());
		add(getPanel());
	}

	public JPanel getPanel_saldo_atual() {
		if (panel_saldo_atual == null) {
			panel_saldo_atual = new JPanel();
			panel_saldo_atual.setBounds(28, 73, 168, 67);
			panel_saldo_atual.setBackground(Color.WHITE);
			panel_saldo_atual.setLayout(null);
			panel_saldo_atual.add(getLbl_saldo_atual());
			panel_saldo_atual.add(getLbl_RS1());
			panel_saldo_atual.add(getLblSaldoValor());
			panel_saldo_atual.add(getLbl_icone_saldo());
		}
		return panel_saldo_atual;
	}

	public JLabel getLbl_saldo_atual() {
		if (lbl_saldo_atual == null) {
			lbl_saldo_atual = new JLabel("Saldo Atual:");
			lbl_saldo_atual.setBounds(5, 8, 59, 13);
			lbl_saldo_atual.setForeground(Color.DARK_GRAY);
			lbl_saldo_atual.setFont(new Font("Arial", Font.BOLD, 10));
			lbl_saldo_atual.setVerticalAlignment(SwingConstants.TOP);
			lbl_saldo_atual.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lbl_saldo_atual;
	}

	public JPanel getPanel_receitas() {
		if (panel_receitas == null) {
			panel_receitas = new JPanel();
			panel_receitas.setBounds(208, 73, 169, 67);
			panel_receitas.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
			panel_receitas.setBackground(Color.WHITE);
			panel_receitas.setLayout(null);
			panel_receitas.add(getLbl_receitas());
			panel_receitas.add(getLbl_RS1_1());
			panel_receitas.add(getLblReceitasValor());
			panel_receitas.add(getLbl_icone_receitas());
		}
		return panel_receitas;
	}

	public JLabel getLbl_receitas() {
		if (lbl_receitas == null) {
			lbl_receitas = new JLabel("Receitas:");
			lbl_receitas.setBounds(5, 5, 56, 13);
			lbl_receitas.setForeground(Color.DARK_GRAY);
			lbl_receitas.setVerticalAlignment(SwingConstants.TOP);
			lbl_receitas.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_receitas.setFont(new Font("Arial", Font.BOLD, 10));
		}
		return lbl_receitas;
	}

	public JPanel getPanel_despesas() {
		if (panel_despesas == null) {
			panel_despesas = new JPanel();
			panel_despesas.setBounds(389, 73, 174, 67);
			panel_despesas.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
			panel_despesas.setBackground(Color.WHITE);
			panel_despesas.setLayout(null);
			panel_despesas.add(getLbl_despesas());
			panel_despesas.add(getLbl_RS1_1_1());
			panel_despesas.add(getLblDespesasValor());
			panel_despesas.add(getLbl_icone_despesas());
		}
		return panel_despesas;
	}

	public JLabel getLbl_despesas() {
		if (lbl_despesas == null) {
			lbl_despesas = new JLabel("Despesas:");
			lbl_despesas.setBounds(5, 5, 63, 13);
			lbl_despesas.setForeground(Color.DARK_GRAY);
			lbl_despesas.setVerticalAlignment(SwingConstants.TOP);
			lbl_despesas.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_despesas.setFont(new Font("Arial", Font.BOLD, 10));
		}
		return lbl_despesas;
	}

	public JLabel getLbl_RS1() {
		if (lbl_RS1 == null) {
			lbl_RS1 = new JLabel("R$:");
			lbl_RS1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_RS1.setBounds(5, 40, 19, 16);
			lbl_RS1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			lbl_RS1.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_RS1.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return lbl_RS1;
	}

	public JLabel getLblDashboard() {
		if (lblDashboard == null) {
			lblDashboard = new JLabel("Dashboard");
			lblDashboard.setForeground(Color.WHITE);
			lblDashboard.setBackground(UIManager.getColor("nimbusLightBackground"));
			lblDashboard.setBounds(31, 20, 149, 31);
			lblDashboard.setFont(new Font("Arial", Font.PLAIN, 22));
		}
		return lblDashboard;
	}

	public JLabel getLbl_RS1_1() {
		if (lbl_RS1_1 == null) {
			lbl_RS1_1 = new JLabel("R$:");
			lbl_RS1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_RS1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_RS1_1.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_RS1_1.setAlignmentY(1.0f);
			lbl_RS1_1.setBounds(5, 40, 19, 16);
		}
		return lbl_RS1_1;
	}

	public JLabel getLbl_RS1_1_1() {
		if (lbl_RS1_1_1 == null) {
			lbl_RS1_1_1 = new JLabel("R$:");
			lbl_RS1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_RS1_1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
			lbl_RS1_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl_RS1_1_1.setAlignmentY(1.0f);
			lbl_RS1_1_1.setBounds(5, 40, 19, 16);
		}
		return lbl_RS1_1_1;
	}

	public JLabel getLblSaldoValor() {
		if (lblSaldoValor == null) {
			lblSaldoValor = new JLabel("00.00");
			lblSaldoValor.setFont(new Font("Arial", Font.PLAIN, 21));
			lblSaldoValor.setBounds(34, 32, 124, 24);
		}
		return lblSaldoValor;
	}

	public JLabel getLblReceitasValor() {
		if (lblReceitasValor == null) {
			lblReceitasValor = new JLabel("00.00");
			lblReceitasValor.setFont(new Font("Arial", Font.PLAIN, 21));
			lblReceitasValor.setBounds(34, 33, 125, 24);
		}
		return lblReceitasValor;
	}

	public JLabel getLblDespesasValor() {
		if (lblDespesasValor == null) {
			lblDespesasValor = new JLabel("00.00");
			lblDespesasValor.setFont(new Font("Arial", Font.PLAIN, 21));
			lblDespesasValor.setBounds(34, 33, 130, 24);
		}
		return lblDespesasValor;
	}

	public JPanel getPanel_principal() {
		if (panel_principal == null) {
			panel_principal = new JPanel();
			panel_principal.setBounds(0, 0, 621, 62);
			panel_principal.setBackground(UIManager.getColor("nimbusFocus"));
			panel_principal.setBackground(new Color(119, 104, 255));
			panel_principal.setForeground(UIManager.getColor("Table.dropLineColor"));
			panel_principal.setLayout(null);
			panel_principal.add(getLblDashboard());
			panel_principal.add(getLblNome());
		}
		return panel_principal;
	}

	public JLabel getLbltotal_d() {
		if (lbltotal_d == null) {
			lbltotal_d = new JLabel("N\u00FAmero total de despesas:\r\n");
			lbltotal_d.setBounds(28, 151, 199, 18);
			lbltotal_d.setFont(new Font("Arial", Font.PLAIN, 15));
		}
		return lbltotal_d;
	}

	public JLabel getLbltotal_d_1() {
		if (lbltotal_d_1 == null) {
			lbltotal_d_1 = new JLabel("N\u00FAmero total de receitas:\r\n");
			lbltotal_d_1.setBounds(333, 151, 189, 18);
			lbltotal_d_1.setFont(new Font("Arial", Font.PLAIN, 15));
		}
		return lbltotal_d_1;
	}

	public JTextField getNDespesas() {
		if (nDespesas == null) {
			nDespesas = new JTextField();
			nDespesas.setForeground(Color.RED);
			nDespesas.setEditable(false);
			nDespesas.setBounds(221, 151, 59, 20);
			nDespesas.setHorizontalAlignment(SwingConstants.CENTER);
			nDespesas.setFont(new Font("Arial", Font.PLAIN, 14));
			nDespesas.setText("00\r\n");
			nDespesas.setColumns(10);
		}
		return nDespesas;
	}

	public JTextField getNReceitas() {
		if (nReceitas == null) {
			nReceitas = new JTextField();
			nReceitas.setForeground(new Color(0, 128, 0));
			nReceitas.setBounds(502, 151, 59, 20);
			nReceitas.setEditable(false);
			nReceitas.setHorizontalAlignment(SwingConstants.CENTER);
			nReceitas.setFont(new Font("Arial", Font.PLAIN, 14));
			nReceitas.setText("00\r\n");
			nReceitas.setColumns(10);
		}
		return nReceitas;
	}

	public JLabel getLbl_acompanhamento_geral() {
		if (lbl_acompanhamento_geral == null) {
			lbl_acompanhamento_geral = new JLabel("Acompanhamento geral:");
			lbl_acompanhamento_geral.setBounds(28, 194, 199, 18);
			lbl_acompanhamento_geral.setFont(new Font("Arial", Font.BOLD, 15));
		}
		return lbl_acompanhamento_geral;
	}

	public JLabel getLbl_icone_saldo() {
		if (lbl_icone_saldo == null) {
			lbl_icone_saldo = new JLabel("");
			lbl_icone_saldo.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_icone_saldo.setIcon(
					new ImageIcon(jpDashboard.class.getResource("/Imagens/saldo atual.png")));
			lbl_icone_saldo.setBounds(123, 4, 44, 38);
		}
		return lbl_icone_saldo;
	}

	public JLabel getLbl_icone_receitas() {
		if (lbl_icone_receitas == null) {
			lbl_icone_receitas = new JLabel("");
			lbl_icone_receitas.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_icone_receitas.setIcon(
					new ImageIcon(jpDashboard.class.getResource("/Imagens/receitas.png")));
			lbl_icone_receitas.setBounds(127, 5, 44, 38);
		}
		return lbl_icone_receitas;
	}

	public JLabel getLbl_icone_despesas() {
		if (lbl_icone_despesas == null) {
			lbl_icone_despesas = new JLabel("");
			lbl_icone_despesas.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_icone_despesas.setIcon(
					new ImageIcon(jpDashboard.class.getResource("/Imagens/despesas.png")));
			lbl_icone_despesas.setBounds(130, 5, 44, 38);
		}
		return lbl_icone_despesas;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 223, 580, 234);
			scrollPane.setViewportView(getTabela());
		}
		return scrollPane;
	}

	public JComboBox<String> getComboBoxTipo() {
		if (comboBoxTipo == null) {
			comboBoxTipo = new JComboBox<String>();
			comboBoxTipo.setBounds(204, 193, 156, 22);
			comboBoxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"RECEITAS", "DESPESAS"}));
		}
		return comboBoxTipo;
	}

	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Ol\u00E1!");
			lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNome.setForeground(Color.WHITE);
			lblNome.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
			lblNome.setBackground((Color) null);
			lblNome.setBounds(251, 20, 342, 31);
		}
		return lblNome;
	}

	public JTable getTabela() {
		if (tabela == null) {
			String col[] = { "ID", "Data", "Descrição", "Valor", "Tipo" };
			tabela = new JTable(new DefaultTableModel(col, 0));
			tabela.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		}
		return tabela;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(SystemColor.inactiveCaption);
			panel.setBounds(0, 180, 600, 292);
		}
		return panel;
	}

}
