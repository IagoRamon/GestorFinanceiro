package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class cadastro_orcamento extends JFrame {
	private JPanel panel_cadastro_despesa;
	private JPanel panel_principal_despesas;
	private JLabel lblNovaDespesa;
	private JLabel lbl_valor_despesa;
	private JLabel lbl_ano;
	private JButton btn_cadastrar;
	private JLabel lbl_descricao;
	private JTextField text_descricao;
	private JLabel lbl_icone_despesas;
	private JComboBox<String> comboBox_mes;
	private JLabel lbl_mes;
	private JSpinner spinner_ano;
	private JSpinner spinner_valor;
	private JButton btn_cancelar;

	public cadastro_orcamento() {

		setSize(562, 420);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Cadastro de Nova Entrada de Receita");
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel_cadastro_despesa());
	}

	public void mostrar(boolean op) { // preenchi isso
		if (op == true) {
			this.repaint();
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}

	}

	public JPanel getPanel_cadastro_despesa() {
		if (panel_cadastro_despesa == null) {
			panel_cadastro_despesa = new JPanel();
			panel_cadastro_despesa.setForeground(Color.WHITE);
			panel_cadastro_despesa.setBounds(0, 0, 546, 330);
			panel_cadastro_despesa.setLayout(null);
			panel_cadastro_despesa.add(getPanel_principal_despesas_2());
			panel_cadastro_despesa.add(getLbl_valor_despesa());
			panel_cadastro_despesa.add(getLbl_ano());
			panel_cadastro_despesa.add(getBtn_cadastrar());
			panel_cadastro_despesa.add(getLbl_descricao());
			panel_cadastro_despesa.add(getText_descricao());
			panel_cadastro_despesa.add(getComboBox_mes());
			panel_cadastro_despesa.add(getLbl_mes());
			panel_cadastro_despesa.add(getSpinner_ano());
			panel_cadastro_despesa.add(getSpinner_valor());
			panel_cadastro_despesa.add(getBtn_cancelar());
		}
		return panel_cadastro_despesa;
	}

	public JPanel getPanel_principal_despesas_2() {
		if (panel_principal_despesas == null) {
			panel_principal_despesas = new JPanel();
			panel_principal_despesas.setLayout(null);
			panel_principal_despesas.setBackground(new Color(119, 104, 255));
			panel_principal_despesas.setBounds(0, 0, 557, 62);
			panel_principal_despesas.add(getLblDashboard_2());

		}
		return panel_principal_despesas;
	}

	public JLabel getLblDashboard_2() {
		if (lblNovaDespesa == null) {
			lblNovaDespesa = new JLabel("Novo Item no Or\u00E7amento");
			lblNovaDespesa.setForeground(Color.WHITE);
			lblNovaDespesa.setFont(new Font("Arial", Font.PLAIN, 22));
			lblNovaDespesa.setBackground((Color) null);
			lblNovaDespesa.setBounds(31, 20, 299, 31);
		}
		return lblNovaDespesa;
	}

	public JLabel getLbl_valor_despesa() {
		if (lbl_valor_despesa == null) {
			lbl_valor_despesa = new JLabel("Valor: ");
			lbl_valor_despesa.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_valor_despesa.setBounds(63, 130, 48, 14);
		}
		return lbl_valor_despesa;
	}

	public JLabel getLbl_ano() {
		if (lbl_ano == null) {
			lbl_ano = new JLabel("Ano:");
			lbl_ano.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_ano.setBounds(63, 170, 33, 14);
		}
		return lbl_ano;
	}

	public JButton getBtn_cadastrar() {
		if (btn_cadastrar == null) {
			btn_cadastrar = new JButton("Cadastrar");
			btn_cadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn_cadastrar.setBounds(282, 282, 103, 23);
		}
		return btn_cadastrar;
	}

	public JLabel getLbl_descricao() {
		if (lbl_descricao == null) {
			lbl_descricao = new JLabel("Descri\u00E7\u00E3o: ");
			lbl_descricao.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_descricao.setBounds(41, 205, 69, 14);
		}
		return lbl_descricao;
	}

	public JTextField getText_descricao() {
		if (text_descricao == null) {
			text_descricao = new JTextField();
			text_descricao.setBounds(123, 202, 283, 20);
			text_descricao.setColumns(10);
		}
		return text_descricao;
	}

//	public JLabel getLbl_icone_despesas() {
//		if (lbl_icone_despesas == null) {
//			lbl_icone_despesas = new JLabel("");
//			lbl_icone_despesas.setIcon(
//					new ImageIcon("C:\\Users\\Iago Ramon\\eclipse-workspace\\LP3_Trabalho1\\Imagens\\despesas.png"));
//			lbl_icone_despesas.setBounds(465, 20, 55, 25);
//		}
//		return lbl_icone_despesas;
//	}

	public JComboBox<String> getComboBox_mes() {
		if (comboBox_mes == null) {
			comboBox_mes = new JComboBox<String>();
			comboBox_mes.setModel(new DefaultComboBoxModel<String>(new String[] { "Janeiro", "Fevereiro", "Mar\u00E7o",
					"Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
			comboBox_mes.setBounds(347, 166, 119, 22);
		}
		return comboBox_mes;
	}

	public JLabel getLbl_mes() {
		if (lbl_mes == null) {
			lbl_mes = new JLabel("M\u00EAs:");
			lbl_mes.setFont(new Font("Arial", Font.PLAIN, 13));
			lbl_mes.setBounds(291, 170, 33, 14);
		}
		return lbl_mes;
	}

	public JSpinner getSpinner_ano() {
		if (spinner_ano == null) {
			spinner_ano = new JSpinner();
			spinner_ano.setModel(new SpinnerNumberModel(new Integer(2021), new Integer(2021), null, new Integer(1)));
			spinner_ano.setBounds(124, 167, 69, 20);
		}
		return spinner_ano;
	}

	public JSpinner getSpinner_valor() {
		if (spinner_valor == null) {
			spinner_valor = new JSpinner();
			spinner_valor.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
			spinner_valor.setBounds(123, 127, 103, 20);
		}
		return spinner_valor;
	}

	public JButton getBtn_cancelar() {
		if (btn_cancelar == null) {
			btn_cancelar = new JButton("Cancelar");
			btn_cancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn_cancelar.setBounds(183, 282, 89, 23);
		}
		return btn_cancelar;
	}

	public void limpar() {
		// TODO Auto-generated method stub

		this.getSpinner_ano().setValue(2021);
		this.getSpinner_valor().setValue(0.0);
		this.getText_descricao().setText("");
		this.getComboBox_mes().setSelectedIndex(0);

	}

}
