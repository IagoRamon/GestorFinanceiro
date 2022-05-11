package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class jpDespesa extends JPanel {
	private JButton btnAddDespesa;
	private JPanel panel_principal_despesas;
	private JLabel lblDashboard;
	private JScrollPane scrollPane;
	private JList<String> lista;
	private JTextField textFieldDescricao;
	private JButton btnPesquisar;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBoxMes;
	private JSpinner spinnerAno;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JComboBox<String> comboBoxTipo;
	private JTable tabela;

	public jpDespesa() {
		setSize(new Dimension(600, 500));
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		// TODO Auto-generated constructor stub
		this.setName("");
		setLayout(null);
		add(getScrollPane());
		add(getPanel_principal_despesas());
		add(getBtnAddDespesa());
		add(getTextFieldDescricao());
		add(getBtnPesquisar());
		add(getLblNewLabel());
		add(getComboBoxMes());
		add(getSpinnerAno());
		add(getLblNewLabel_1());
		add(getLblNewLabel_1_1());
		add(getLblNewLabel_2());
		add(getComboBoxTipo());
	}

	public JButton getBtnAddDespesa() {
		if (btnAddDespesa == null) {
			btnAddDespesa = new JButton("Nova despesa");
			btnAddDespesa.setBounds(454, 428, 136, 23);
		}
		return btnAddDespesa;
	}

	public JPanel getPanel_principal_despesas() {
		if (panel_principal_despesas == null) {
			panel_principal_despesas = new JPanel();
			panel_principal_despesas.setBounds(0, 0, 601, 62);
			panel_principal_despesas.setLayout(null);
			panel_principal_despesas.setBackground(new Color(119, 104, 255));
			panel_principal_despesas.add(getLblDashboard());
		}
		return panel_principal_despesas;
	}

	public JLabel getLblDashboard() {
		if (lblDashboard == null) {
			lblDashboard = new JLabel("Despesas");
			lblDashboard.setForeground(Color.WHITE);
			lblDashboard.setFont(new Font("Arial", Font.PLAIN, 22));
			lblDashboard.setBackground((Color) null);
			lblDashboard.setBounds(31, 20, 149, 31);
		}
		return lblDashboard;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 80, 580, 234);
			scrollPane.setViewportView(getTabela());
		}
		return scrollPane;
	}

	public JList<String> getLista() {
		if (lista == null) {
			lista = new JList<String>();
			lista.setBounds(167, 210, 200, 50);
		}
		return lista;
	}

	public JTextField getTextFieldDescricao() {
		if (textFieldDescricao == null) {
			textFieldDescricao = new JTextField();
			textFieldDescricao.setBounds(266, 351, 211, 20);
			textFieldDescricao.setColumns(10);
		}
		return textFieldDescricao;
	}

	public JButton getBtnPesquisar() {
		if (btnPesquisar == null) {
			btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.setBounds(487, 350, 103, 23);
		}
		return btnPesquisar;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Descri\u00E7\u00E3o");
			lblNewLabel.setBounds(266, 326, 89, 14);
		}
		return lblNewLabel;
	}

	public JComboBox<String> getComboBoxMes() {
		if (comboBoxMes == null) {
			comboBoxMes = new JComboBox<String>();
			comboBoxMes.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Todos", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho",
							"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
			comboBoxMes.setBounds(109, 350, 147, 22);
		}
		return comboBoxMes;
	}

	public JSpinner getSpinnerAno() {
		if (spinnerAno == null) {
			spinnerAno = new JSpinner();
			spinnerAno.setModel(new SpinnerNumberModel(new Integer(2021), new Integer(2021), null, new Integer(1)));
			spinnerAno.setBounds(10, 351, 89, 20);
		}
		return spinnerAno;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Ano");
			lblNewLabel_1.setBounds(10, 326, 48, 14);
		}
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("M\u00EAs");
			lblNewLabel_1_1.setBounds(109, 326, 48, 14);
		}
		return lblNewLabel_1_1;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Tipo:");
			lblNewLabel_2.setBounds(10, 400, 48, 14);
		}
		return lblNewLabel_2;
	}

	public JComboBox<String> getComboBoxTipo() {
		if (comboBoxTipo == null) {
			comboBoxTipo = new JComboBox<String>();
			comboBoxTipo.setModel(
					new DefaultComboBoxModel<String>(new String[] { "TODOS", "DINHEIRO", "CARTAO", "EMPRESTIMO" }));
			comboBoxTipo.setBounds(10, 428, 167, 22);
		}
		return comboBoxTipo;
	}

	public JTable getTabela() {
		if (tabela == null) {
			String col[] = { "ID", "Data", "Descrição", "Valor", "Tipo" };
			tabela = new JTable(new DefaultTableModel(new Object[][] {}, col));
			tabela.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		}
		return tabela;
	}
}
