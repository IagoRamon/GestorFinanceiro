package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import dados.ArquivosDados;
import modelo.Despesa;
import modelo.Orcamento;
import modelo.Receita;
import visao.JanelaPrincipal;
import visao.cadastro_despesa;
import visao.cadastro_orcamento;
import visao.cadastro_receita;
import visao.jpDashboard;
import visao.jpDespesa;
import visao.jpOrcamento;
import visao.jpReceita;

public class ControladorPrincipal implements ActionListener, ItemListener, ChangeListener {

	JanelaPrincipal janela;

	// Paineis do TabbedPanel
	jpDashboard dashboard;
	jpReceita receitas;
	jpDespesa despesas;
	jpOrcamento orcamento;

	// Janelas de Cadastro
	cadastro_receita cadReceita;
	cadastro_despesa cadDespesa;
	cadastro_orcamento cadOrcamento;

	// Gerador de Numeros Randomicos
	Random gerador;

	public ControladorPrincipal() {

		// instanciando a parte grafica

		janela = new JanelaPrincipal();

		dashboard = janela.getJPDashboard();
		receitas = janela.getJPReceitas();
		despesas = janela.getJPDespesas();
		orcamento = janela.getOrcamento();

		cadReceita = new cadastro_receita();
		cadDespesa = new cadastro_despesa();
		cadOrcamento = new cadastro_orcamento();

		// Carrega os dados dos arquivos
		ArquivosDados.lerEntradas();
		ArquivosDados.lerSaidas();
		ArquivosDados.lerOrcamento();
		ArquivosDados.lerInfos();

		// Instanciando gerador de rands
		gerador = new Random();

		// Configura os elementos que serão controlados
		addAcoes();

		// Carrega informações no dashboard (valores e qtds)
		contarDashboard();

		// Preeche a tabela do dashboard
		buscarReceitasDashBorad();

		// coloca o nome do usuario na tela inicial do dashboard
		dashboard.getLblNome().setText("Olá " + ArquivosDados.getInfo().getNome() + " ! ");

		// Torna a janela visivel
		janela.mostrar();

	}

	private void addAcoes() {
		janela.getJTabbedPane().addChangeListener(this);

		// Dashboard
		dashboard.getComboBoxTipo().addItemListener(this); // combo box

		// Painel RECEITAS
		receitas.getBtnAddReceita().addActionListener(this); // botao
		receitas.getBtnPesquisar().addActionListener(this);

		// Painel DESPESAS
		despesas.getBtnAddDespesa().addActionListener(this);
		despesas.getBtnPesquisar().addActionListener(this);

		// Janela Cadastro Receitas
		cadReceita.getBtn_cadastrar().addActionListener(this);
		cadReceita.getBtn_cancelar().addActionListener(this);

		// Janela Cadastro Despesa
		cadDespesa.getBtn_cancelar().addActionListener(this);
		cadDespesa.getBtn_cadastrar().addActionListener(this);

		// Painel orcamento
		orcamento.getComboBoxMes().addItemListener(this); // mes painel orcamento
		orcamento.getBtnPesquisar().addActionListener(this); // pesquisar orcamento
		orcamento.getBtnAddItem().addActionListener(this); // adicionar ITEM no orcamento do mes TAL

		// Janela cadastro orcamento
		cadOrcamento.getBtn_cancelar().addActionListener(this); // cancelar cadastro
		cadOrcamento.getBtn_cadastrar().addActionListener(this); // cadastrar

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == receitas.getBtnAddReceita()) {
			cadReceita.mostrar(true);

		} else if (e.getSource() == receitas.getBtnPesquisar()) {
			buscarReceitas();

		} else if (e.getSource() == despesas.getBtnAddDespesa()) {
			cadDespesa.mostrar(true);

		} else if (e.getSource() == despesas.getBtnPesquisar()) {
			buscarDespesas();

		} else if (e.getSource() == cadReceita.getBtn_cancelar()) {
			cadReceita.limpar();
			cadReceita.mostrar(false);
			
		} else if (e.getSource() == cadReceita.getBtn_cadastrar()) {
			cadastrarReceita();

		} else if (e.getSource() == cadDespesa.getBtn_cancelar()) {
			cadDespesa.limpar();
			cadDespesa.mostrar(false);
		} else if (e.getSource() == cadDespesa.getBtn_cadastrar()) {
			cadastrarDespesa(); // ORCAMENTO
		} else if (e.getSource() == cadOrcamento.getBtn_cancelar()) { // OK
			cadOrcamento.limpar();
			cadOrcamento.mostrar(false);
		} else if (e.getSource() == cadOrcamento.getBtn_cadastrar()) { //
			cadastrarOrcamento();
		} else if (e.getSource() == orcamento.getBtnAddItem()) {
			cadOrcamento.mostrar(true);
		} else if (e.getSource() == orcamento.getBtnPesquisar()) {
			buscarOrcamentos();
			contarOrcamento();
		}

	}

	private void buscarOrcamentos() {
		// TODO Auto-generated method stub
		// titulo colunas tabela
		String col[] = { "Descrição", "Valor", "Ano", "Mês" };
		// Modelo da tabela, passando As colunas e a qtd de linhas

		DefaultTableModel modelo = new DefaultTableModel(col, 0);
		ArrayList<Orcamento> arrayOrcamento = null;

		// ele busca pelo mes e ano
		if (orcamento.getComboBoxMes().getSelectedIndex() == 0) {
			arrayOrcamento = ArquivosDados.OrcamentosPorAno((int) orcamento.getSpinnerAno().getValue());

		} else {
			arrayOrcamento = ArquivosDados.OrcamentosPorAnoMes((int) orcamento.getSpinnerAno().getValue(),
					orcamento.getComboBoxMes().getSelectedItem().toString());
		}

		if (arrayOrcamento != null) {// verifica se existe algo cadastrada

			for (Orcamento topo : arrayOrcamento) {
				// se houver algum registro, transformamos em objeto
				Object[] dados = { topo.getDescricao(), topo.getValor(), topo.getAno() , topo.getMes() };

				// adicionamos esse objeto como uma nova linha do modelo da tabela
				modelo.addRow(dados);
			}
			// subistui o modelo da tabela
			orcamento.getTabela().setModel(modelo);
		}

	}

	public void cadastrarReceita() {
		Receita nova = new Receita();
		int id;
		Boolean result;
		do {
			id = gerador.nextInt(99999);
			result = ArquivosDados.verificaIdReceita(id);
		} while (result);
		nova.setId(id);
		nova.setDescricao(cadReceita.getText_descricao().getText());
		nova.setAno((int) cadReceita.getSpinner_ano().getValue());
		nova.setMes(cadReceita.getComboBox_mes().getSelectedItem().toString());
		nova.setValor(Double.valueOf(cadReceita.getSpinner_valor().getValue().toString()));

		// Gravando Na RAM (Array)
		ArquivosDados.arrayEntradas.add(nova);
		// Gravando no Disco (Arquivo)
		ArquivosDados.gravarEntrada(nova);

		JOptionPane.showMessageDialog(cadReceita, "Cadastrada!!");
		cadReceita.limpar();
		cadReceita.setVisible(false);
		buscarReceitas();
	}

	public void cadastrarDespesa() {
		Despesa nova = new Despesa();
		int id;
		Boolean result;
		do {
			id = gerador.nextInt(99999);
			result = ArquivosDados.verificaIdReceita(id);
		} while (result);
		nova.setId(id);
		nova.setDescricao(cadDespesa.getText_descricao().getText());
		nova.setAno((int) cadDespesa.getSpinner_ano().getValue());
		nova.setMes(cadDespesa.getComboBox_mes().getSelectedItem().toString());
		nova.setValor(Double.valueOf(cadDespesa.getSpinner_valor().getValue().toString()));
		nova.setTipo(cadDespesa.getComboBox_Tipo().getSelectedItem().toString());

		ArquivosDados.arraySaidas.add(nova);
		ArquivosDados.gravarSaida(nova);

		JOptionPane.showMessageDialog(cadDespesa, "Cadastrada!!");
		cadDespesa.limpar();
		cadDespesa.setVisible(false);
		buscarDespesas();

	}

	public void cadastrarOrcamento() {
		Orcamento nova = new Orcamento();

		nova.setDescricao(cadOrcamento.getText_descricao().getText()); // descricao orcamento
		nova.setValor(Double.valueOf(cadOrcamento.getSpinner_valor().getValue().toString())); // valor
		nova.setAno((int) cadOrcamento.getSpinner_ano().getValue()); // ano
		nova.setMes(cadOrcamento.getComboBox_mes().getSelectedItem().toString()); // mes

		ArquivosDados.arrayOrcamento.add(nova);
		ArquivosDados.gravarOrcamento(nova);

		JOptionPane.showMessageDialog(cadOrcamento, "Cadastrado!!");
		cadOrcamento.limpar();
		cadOrcamento.setVisible(false);
		buscarDespesas();

	}

	public void buscarReceitas() {
		// titulo colunas tabela
		String col[] = { "ID", "Data", "Descrição", "Valor" };
		
		// Modelo da tabela, passando As colunas e a qtd de linhas
		DefaultTableModel modelo = new DefaultTableModel(col, 0);

		ArrayList<Receita> arrayReceitas = null;

		String busca = receitas.getTextFieldDescricao().getText();

		if (busca == null || busca.isEmpty()) {// se Não digitar nada na descrição ele busca pelo mes e ano
			if (receitas.getComboBoxMes().getSelectedIndex() == 0) {
				arrayReceitas = ArquivosDados.receitasPorAno((int) receitas.getSpinnerAno().getValue());

			} else {
				arrayReceitas = ArquivosDados.receitasPorAnoMes((int) receitas.getSpinnerAno().getValue(),
						receitas.getComboBoxMes().getSelectedItem().toString());
			}
		} else {
			arrayReceitas = ArquivosDados.receitasPorDescricao(receitas.getTextFieldDescricao().getText());
		}

		if (arrayReceitas != null) {// verifica se existe algo cadastrada

			for (Receita topo : arrayReceitas) {
				// se houver algum registro, transformamos em objeto
				Object[] dados = { topo.getId(), topo.getMes() + " de " + topo.getAno(), topo.getDescricao(),
						topo.getValor() };

				// adicionamos esse objeto como uma nova linha do modelo da tabela
				modelo.addRow(dados);
			}
			// subistui o modelo da tabela
			receitas.getTabela().setModel(modelo);
		}
	}

	public void buscarDespesas() {
		String col[] = { "ID", "Data", "Descrição", "Valor", "Tipo" };
		DefaultTableModel modelo = new DefaultTableModel(col, 0);
		ArrayList<Despesa> arrayDespesas = null;
		String busca = despesas.getTextFieldDescricao().getText();
		if (busca == null || busca.isEmpty()) {

			// Pesquisa só pelo ano
			if (despesas.getComboBoxTipo().getSelectedIndex() == 0) {
				if (despesas.getComboBoxMes().getSelectedIndex() == 0) {
					arrayDespesas = ArquivosDados.despesasPorAno((int) despesas.getSpinnerAno().getValue());

				} else { // Pesquisa pelo ano e mês
					arrayDespesas = ArquivosDados.despesasPorAnoMes((int) despesas.getSpinnerAno().getValue(),
							despesas.getComboBoxMes().getSelectedItem().toString());
				}
			} else {// Pesquisa pelo ano e tipo
				if (despesas.getComboBoxMes().getSelectedIndex() == 0) {
					arrayDespesas = ArquivosDados.despesasPorAnoTipo((int) despesas.getSpinnerAno().getValue(),
							despesas.getComboBoxTipo().getSelectedItem().toString());

				} else {// Pesquisa pelo ano, mes e tipo
					arrayDespesas = ArquivosDados.despesasPorAnoMesTipo((int) despesas.getSpinnerAno().getValue(),
							despesas.getComboBoxMes().getSelectedItem().toString(),
							despesas.getComboBoxTipo().getSelectedItem().toString());
				}
			}

		} else {// Pesquisa só pela descrição
			arrayDespesas = ArquivosDados.despesasPorDescricao(despesas.getTextFieldDescricao().getText());

		}

		if (arrayDespesas != null) {

			for (Despesa topo : arrayDespesas) {
				Object[] dados = { topo.getId(), topo.getMes() + " de " + topo.getAno(), topo.getDescricao(),
						topo.getValor(), topo.getTipo() };
				modelo.addRow(dados);
			}
			despesas.getTabela().setModel(modelo);
		}
	}

	public void buscarReceitasDashBorad() {
		String col[] = { "ID", "Data", "Descrição", "Valor" };

		DefaultTableModel modelo = new DefaultTableModel(col, 0);

		if (ArquivosDados.arrayEntradas != null) {

			for (Receita topo : ArquivosDados.arrayEntradas) {
				Object[] dados = { topo.getId(), topo.getMes() + " de " + topo.getAno(), topo.getDescricao(),
						topo.getValor() };
				modelo.addRow(dados);

			}

		}
		dashboard.getTabela().setModel(modelo);
	}

	public void buscarDespesasDashBorad() {
		String col[] = { "ID", "Data", "Descrição", "Valor", "Tipo" };

		DefaultTableModel modelo = new DefaultTableModel(col, 0);

		if (ArquivosDados.arraySaidas != null) {

			for (Despesa topo : ArquivosDados.arraySaidas) {
				Object[] dados = { topo.getId(), topo.getMes() + " de " + topo.getAno(), topo.getDescricao(),
						topo.getValor(), topo.getTipo() };
				modelo.addRow(dados);
			}
			dashboard.getTabela().setModel(modelo);
		}
	}

	public void contarDashboard() {
		double receitas = 0;
		double despesas = 0;
		// exibe a qtd de receitas e despesas cadastradas
		dashboard.getNDespesas().setText(String.valueOf(ArquivosDados.arraySaidas.size()));
		dashboard.getNReceitas().setText(String.valueOf(ArquivosDados.arrayEntradas.size()));

		// soma os totais
		for (Receita topo : ArquivosDados.arrayEntradas) {
			receitas += topo.getValor();
		}

		for (Despesa topo : ArquivosDados.arraySaidas) {
			despesas += topo.getValor();
		}

		// exibe na tela os totais e o saldo
		dashboard.getLblReceitasValor().setText(String.valueOf(receitas));
		dashboard.getLblDespesasValor().setText(String.valueOf(despesas));
		dashboard.getLblSaldoValor().setText(String.valueOf(receitas - despesas));

	}

	@Override
	// Controla a busca no dashboard
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == dashboard.getComboBoxTipo()) {
			if (dashboard.getComboBoxTipo().getSelectedIndex() == 0) {
				buscarReceitasDashBorad();
			} else if (dashboard.getComboBoxTipo().getSelectedIndex() == 1) {
				buscarDespesasDashBorad();
			}
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == janela.getJTabbedPane()) {
			if (janela.getJTabbedPane().getSelectedIndex() == 0) {
				contarDashboard();
				dashboard.getComboBoxTipo().setSelectedIndex(0);
				buscarReceitasDashBorad();

			} else if (janela.getJTabbedPane().getSelectedIndex() == 1) {
				buscarReceitas();

			} else if (janela.getJTabbedPane().getSelectedIndex() == 2) {
				buscarDespesas();

			} else if (janela.getJTabbedPane().getSelectedIndex() == 3) {
				buscarOrcamentos();
				contarOrcamento();


			}

		}

	}

	public void contarOrcamento() {

		double despesas = 0;
		double orcamentoValor = 0;
		// exibe a qtd de receitas e despesas cadastradas
		dashboard.getNDespesas().setText(String.valueOf(ArquivosDados.arraySaidas.size()));
		dashboard.getNReceitas().setText(String.valueOf(ArquivosDados.arrayEntradas.size()));

		// soma os totais
		for (Orcamento topo : ArquivosDados.OrcamentosPorAnoMes(
				Integer.valueOf(orcamento.getSpinnerAno().getValue().toString()),
				orcamento.getComboBoxMes().getSelectedItem().toString())) {
			orcamentoValor += topo.getValor();

		}
		orcamento.getTextFieldTotalOrcamento().setText(String.valueOf(orcamentoValor));
		for (Despesa topo : ArquivosDados.despesasPorAnoMes(
				Integer.valueOf(orcamento.getSpinnerAno().getValue().toString()),
				orcamento.getComboBoxMes().getSelectedItem().toString())) {
			despesas += topo.getValor();
		}
		orcamento.getTextFieldTotalMes().setText(String.valueOf(despesas));
		// exibe na tela os totais e o saldo
		if (orcamentoValor - despesas > 0) {
			orcamento.getTextFieldStatus().setText("Bom");
		} else if (orcamentoValor - despesas == 0) {
			orcamento.getTextFieldStatus().setText("Médio");
		} else {
			orcamento.getTextFieldStatus().setText("Ruim");
		}

	}

}
