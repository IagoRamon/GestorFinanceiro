package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class jpOrcamento extends JPanel {
	private JButton btnAddItem;
	private JPanel panel_principal_orcamento;
	private JLabel lblOrcamento;
	private JScrollPane scrollPane;
	private JButton btnPesquisar;
	private JComboBox<String> comboBoxMes;
	private JSpinner spinnerAno;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTable tabela;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textFieldTotalMes;
	private JLabel lblValorTotalDo;
	private JTextField textFieldTotalOrcamento;
	private JLabel lblStatus;
	private JTextField textFieldStatus;
	private JLabel aviso;

	public jpOrcamento() {
		setSize(new Dimension(600, 500));
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		// TODO Auto-generated constructor stub
		this.setName("");
		setLayout(null);
		add(getScrollPane());
		add(getPanel_principal_orcamento());
		add(getBtnAddItem());
		add(getBtnPesquisar());
		add(getComboBoxMes());
		add(getSpinnerAno());
		add(getLblNewLabel_1());
		add(getLblNewLabel_1_1());
		add(getPanel());
		setVisible(true);//
	}

	public JButton getBtnAddItem() {
		if (btnAddItem == null) {
			btnAddItem = new JButton("Novo item");
			btnAddItem.setBounds(501, 350, 89, 23);
		}
		return btnAddItem;
	}

	public JPanel getPanel_principal_orcamento() {
		if (panel_principal_orcamento == null) {
			panel_principal_orcamento = new JPanel();
			panel_principal_orcamento.setBounds(0, 0, 601, 62);
			panel_principal_orcamento.setLayout(null);
			panel_principal_orcamento.setBackground(new Color(119, 104, 255));
			panel_principal_orcamento.add(getLblOrcamento());
		}
		return panel_principal_orcamento;
	}

	public JLabel getLblOrcamento() {
		if (lblOrcamento == null) {
			lblOrcamento = new JLabel("Or\u00E7amento");
			lblOrcamento.setForeground(Color.WHITE);
			lblOrcamento.setFont(new Font("Arial", Font.PLAIN, 22));
			lblOrcamento.setBackground((Color) null);
			lblOrcamento.setBounds(31, 20, 149, 31);
		}
		return lblOrcamento;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 80, 580, 234);
			scrollPane.setViewportView(getTabela());
		}
		return scrollPane;
	}

	public JButton getBtnPesquisar() {
		if (btnPesquisar == null) {
			btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.setBounds(266, 350, 103, 23);
		}
		return btnPesquisar;
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

	public JTable getTabela() {
		if (tabela == null) {
			String col[] = { "Descrição", "Valor", "Ano", "Mês" };
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
			panel.setBounds(10, 396, 580, 79);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTextFieldTotalMes());
			panel.add(getLblValorTotalDo());
			panel.add(getTextFieldTotalOrcamento());
			panel.add(getLblStatus());
			panel.add(getTextFieldStatus());
			panel.add(getAviso());
		}
		return panel;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Valor total j\u00E1 gasto no m\u00EAs: ");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
			lblNewLabel.setBounds(46, 13, 193, 14);
		}
		return lblNewLabel;
	}

	public JTextField getTextFieldTotalMes() {
		if (textFieldTotalMes == null) {
			textFieldTotalMes = new JTextField();
			textFieldTotalMes.setEditable(false);
			textFieldTotalMes.setBounds(216, 10, 86, 20);
			textFieldTotalMes.setColumns(10);
		}
		return textFieldTotalMes;
	}

	public JLabel getLblValorTotalDo() {
		if (lblValorTotalDo == null) {
			lblValorTotalDo = new JLabel("Valor total do m\u00EAs no or\u00E7amento:");
			lblValorTotalDo.setFont(new Font("Arial", Font.PLAIN, 13));
			lblValorTotalDo.setBounds(16, 42, 222, 14);
		}
		return lblValorTotalDo;
	}

	public JTextField getTextFieldTotalOrcamento() {
		if (textFieldTotalOrcamento == null) {
			textFieldTotalOrcamento = new JTextField();
			textFieldTotalOrcamento.setEditable(false);
			textFieldTotalOrcamento.setColumns(10);
			textFieldTotalOrcamento.setBounds(216, 39, 86, 20);
		}
		return textFieldTotalOrcamento;
	}

	public JLabel getLblStatus() {
		if (lblStatus == null) {
			lblStatus = new JLabel("Status:");
			lblStatus.setFont(new Font("Arial", Font.BOLD, 15));
			lblStatus.setBounds(474, 11, 193, 14);
		}
		return lblStatus;
	}

	public JTextField getTextFieldStatus() {
		if (textFieldStatus == null) {
			textFieldStatus = new JTextField();
			textFieldStatus.setEditable(false);
			textFieldStatus.setColumns(10);
			textFieldStatus.setBounds(423, 36, 147, 20);
		}
		return textFieldStatus;
	}

	public JComboBox<String> btn_cancelar() {
		// TODO Auto-generated method stub
		return null;
	}

	public JOptionPane spinner_valor() {
		// TODO Auto-generated method stub
		return null;
	}
	public JLabel getAviso() {
		if (aviso == null) {
			aviso = new JLabel("* Para ver os dados referentes ao M\u00CAS e ANO, os selecione e clique \"Pesquisar\"!");
			aviso.setForeground(new Color(0, 128, 0));
			aviso.setFont(new Font("Arial", Font.BOLD, 11));
			aviso.setBounds(26, 65, 505, 14);
		}
		return aviso;
	}
}
