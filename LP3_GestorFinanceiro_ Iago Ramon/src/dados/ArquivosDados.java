package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Despesa;
import modelo.Infos;
import modelo.Orcamento;
import modelo.Receita;

public class ArquivosDados {
	private static String conteudo = "";
	public static Infos info = new Infos();
	public static ArrayList<Receita> arrayEntradas = new ArrayList<Receita>();
	public static ArrayList<Despesa> arraySaidas = new ArrayList<Despesa>();
	public static ArrayList<Orcamento> arrayOrcamento = new ArrayList<Orcamento>();
	

	// MANIPULAÇÃO DE ARQUIVOS

	// FUNÇÃO QUE BUSCA O ARQUIVO DE ENTRADA DE RECEITA NO DISCO  ------------------------------------------
	public static void procuraArqEntradas() {
		try {
			File arquivo = new File("Entradas.txt"); // Criamos um arquivo passando nome e extensão
			if (!arquivo.exists()) { // Caso o arquvio não exista no disco, criamos um novo arquivo
				arquivo.createNewFile();// cria um novo arquvio fisicamente no disco
				System.out.println("Arquivo Entradas.txt criado!");
			}

		} catch (IOException e) {
			System.out.println("Erro ao criar o arquivo Entradas.txt!: " + e.getMessage());
		}
	}

	// FUNÇÃO LER O ARQUIVO NO DISCO E CARREGA NO ARRAYLIST DE ENTRADA DE RECEITAS
	public static void lerEntradas() {
		procuraArqEntradas();
		try {
			// Criamos um leitor de buffer, passando como parametro um leitor de arquivo e
			// para esse leitor de arquivo passamos o arquivo
			BufferedReader lerBuffer = new BufferedReader(new FileReader(new File("Entradas.txt")));

			while ((conteudo = lerBuffer.readLine()) != null) {
				Receita nova = new Receita();
				String[] dados = conteudo.split(";");

				nova.setId(Integer.valueOf(dados[0]));
				nova.setAno(Integer.valueOf(dados[1]));
				nova.setMes(dados[2]);
				nova.setDescricao(dados[3]);
				nova.setValor(Double.valueOf(dados[4]));

				System.out.println(nova.toString() + "\n");
				arrayEntradas.add(nova);

			}
		} catch (IOException | NumberFormatException e1) {
			System.out.println("Erro ao ler aquivo entradas.txt: \n" + e1.getMessage());
		}
	}

	public static boolean gravarEntrada(Receita receita) {
		try {

			File arquivo = new File("Entradas.txt");

			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}

		} catch (IOException e) {
			System.out.println("Erro 1 ao Gravar Receita!:" + e.getMessage());
		}

		try {

			conteudo = receita.getId() + ";" + receita.getAno() + ";" + receita.getMes() + ";" + receita.getDescricao()
					+ ";" + receita.getValor() + ";" + "\n";

			BufferedWriter gravadorBuffer = new BufferedWriter(new FileWriter(new File("Entradas.txt"), true));

			gravadorBuffer.write(conteudo);
			gravadorBuffer.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro 2 ao Gravar Receita!:" + e.getMessage());
		}
		return false;

	}

	//GARANTE QUE NO FECHAMENTO DO PROGRAMA TUDO SEJA GRAVADO NO DISCO
	public static void gravarTodasEntradas() {
		try {
			File arquivo = new File("Entradas.txt");
			if (arquivo.exists()) {
				Files.delete(Paths.get("Entradas.txt"));
			}
			Thread.sleep(1000);
			arquivo.createNewFile();
		} catch (IOException | InterruptedException e) {
			System.out.println("Erro 1 ao Gravar Todas as Entradas!:" + e.getMessage());
		}

		for (Receita topo : arrayEntradas) {
			if (topo != null) {
				try {
					conteudo = topo.getId() + ";" + topo.getAno() + ";" + topo.getMes() + ";" + topo.getDescricao()
							+ ";" + topo.getValor() + ";" + "\n";

					BufferedWriter gravadorBuffer = new BufferedWriter(new FileWriter(new File("Entradas.txt"), true));

					gravadorBuffer.write(conteudo);
					gravadorBuffer.close();
				} catch (IOException e) {
					System.out.println("Erro 2 ao Gravar Todas as Entradas!:" + e.getMessage());
				}
			}
		}
	}

	public static void procuraArqSaidas() {
		try {
			File arquivo = new File("Saidas.txt");
			if (!arquivo.exists()) {
				arquivo.createNewFile();
				System.out.println("Arquivo Saidas.txt criado!");
			}
		} catch (IOException e) {
			System.out.println("Erro ao criar o arquivo Saidas.txt!: " + e.getMessage());
		}
	}

	public static void lerSaidas() {
		procuraArqSaidas();
		Despesa despesa;
		try {
			BufferedReader leitorBuffer = new BufferedReader(new FileReader(new File("Saidas.txt")));
			while ((conteudo = leitorBuffer.readLine()) != null) {
				String[] dados = conteudo.split(";");
				despesa = new Despesa();

				despesa.setId(Integer.valueOf(dados[0]));
				despesa.setAno(Integer.valueOf(dados[1]));
				despesa.setMes(dados[2]);
				despesa.setDescricao(dados[3]);
				despesa.setValor(Double.valueOf(dados[4]));
				despesa.setTipo(dados[5]);

				System.out.println(despesa.toString() + "\n");

				arraySaidas.add(despesa);
			}
		} catch (IOException | NumberFormatException e1) {
			System.out.println("Erro ao ler aquivo Saidas.txt: \n" + e1.getMessage());
		}
	}

	public static boolean gravarSaida(Despesa despesa) {
		try {
			File arquivo = new File("Saidas.txt");

			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}

		} catch (IOException e) {
			System.out.println("Erro 1 ao Gravar Despesa!:" + e.getMessage());
		}

		try {

			String conteudo = despesa.getId() + ";" + despesa.getAno() + ";" + despesa.getMes() + ";"
					+ despesa.getDescricao() + ";" + despesa.getValor() + ";" + despesa.getTipo() + ";" + "\n";

			BufferedWriter gravadorBuffer = new BufferedWriter(new FileWriter(new File("Saidas.txt"), true));

			gravadorBuffer.write(conteudo);
			gravadorBuffer.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro 2 ao Gravar Despesa!:" + e.getMessage());
		}

		return false;

	}

	public static void gravarTodasSaidas() {
		try {

			File arquivo = new File("Saidas.txt");
			if (arquivo.exists()) {
				Files.delete(Paths.get("Saidas.txt"));
			}
			arquivo.createNewFile();

		} catch (IOException e) {
			System.out.println("Erro 1 ao Gravar Todas as Entradas!:" + e.getMessage());
		}

		for (Despesa topo : arraySaidas) {
			if (topo != null) {
				try {

					String conteudo = topo.getId() + ";" + topo.getAno() + ";" + topo.getMes() + ";"
							+ topo.getDescricao() + ";" + topo.getValor() + ";" + topo.getTipo() + ";" + "\n";

					BufferedWriter gravadorBuffer = new BufferedWriter(new FileWriter(new File("Despesas.txt"), true));

					gravadorBuffer.write(conteudo);
					gravadorBuffer.close();
				} catch (IOException e) {
					System.out.println("Erro 2 ao Gravar Todas as Saidas!:" + e.getMessage());
				}
			}
		}

	}

	public static void procuraArqInfos() {
		try {
			File arquivo = new File("Infos.txt"); // Criamos um arquivo passando nome e extensão
			if (!arquivo.exists()) { // Caso o arquvio não exista no disco, criamos um novo arquivo
				// cria um novo arquvio fisicamente no disco

				// Conteudo inicial do arquivo recém criado
				String conteudo = (String) JOptionPane.showInputDialog(null, "Informe seu nome",
						"Antes de começar, por favor", JOptionPane.QUESTION_MESSAGE);

				if (conteudo == null || conteudo.equals("")) {
					conteudo = "Novo(a) Usuário(a)";
				}

				arquivo.createNewFile();

				// Prepara para escrever no arquivo
				BufferedWriter gravadorBuffer = new BufferedWriter(new FileWriter(new File("Infos.txt")));

				// Escreve os dados e fecha arquivo
				gravadorBuffer.write(conteudo);
				gravadorBuffer.close();
				System.out.println("Arquivo Infos.txt criado!");
			}

		} catch (IOException e) {
			System.out.println("Erro ao criar o arquivo Info.txt!: " + e.getMessage());
		}
	}

	public static void lerInfos() {
		procuraArqInfos();
		try {
			BufferedReader leitorBuffer = new BufferedReader(new FileReader(new File("Infos.txt")));
			while ((conteudo = leitorBuffer.readLine()) != null) {
				String[] dados = conteudo.split(";");
				info.setNome(dados[0]);

				System.out.println(info.toString() + "\n");

			}
		} catch (IOException | NumberFormatException e1) {
			System.out.println("Erro ao ler aquivo Infos.txt: \n" + e1.getMessage());
		}
	}

	public static void gravarInfos() {
		try {
			File arquivo = new File("Infos.txt");
			if (arquivo.exists()) {
				Files.delete(Paths.get("Infos.txt"));
			}
			Thread.sleep(1000);
			arquivo.createNewFile();
		} catch (IOException | InterruptedException e) {
			System.out.println("Erro 1 ao Gravar Infos!:" + e.getMessage());
		}

		try {
			conteudo = info.getNome() + ";" + "\n";

			BufferedWriter gravadorBuffer = new BufferedWriter(new FileWriter(new File("Infos.txt"), true));

			gravadorBuffer.write(conteudo);
			gravadorBuffer.close();
		} catch (IOException e) {
			System.out.println("Erro 2 ao Gravar Infos!:" + e.getMessage());
		}

	}

	// MANIPULAÇÂO DOS DADOS - RECEITAS

	public static boolean verificaIdReceita(int id) {		// ID	
		boolean busca = false;
		if (arrayEntradas != null) {
			for (Receita topo : arrayEntradas) {
				if (topo.getId() == id) {
					busca = true;
				}
			}
		}
		return busca;
	}

	public static ArrayList<Receita> receitasPorDescricao(String descricao) {	// DESCRICAO
		ArrayList<Receita> listaReceitas = null;
		if (arrayEntradas != null) {
			listaReceitas = new ArrayList<Receita>();
			for (Receita topo : arrayEntradas) {
				if (topo.getDescricao().equals(descricao)) {
					listaReceitas.add(topo);
				}
			}
		}
		return listaReceitas;
	}

	public static ArrayList<Receita> receitasPorAno(int ano) { 	// ano
		ArrayList<Receita> listaReceitas = null;
		if (arrayEntradas != null) {
			listaReceitas = new ArrayList<Receita>();
			for (Receita topo : arrayEntradas) {
				if (topo.getAno() == ano) {
					listaReceitas.add(topo);
				}
			}
		}
		return listaReceitas;
	}

	public static ArrayList<Receita> receitasPorAnoMes(int ano, String mes) {
		ArrayList<Receita> listaReceitas = null;
		if (arrayEntradas != null) {
			listaReceitas = new ArrayList<Receita>();
			for (Receita topo : arrayEntradas) {
				if (topo.getAno() == ano && topo.getMes().equals(mes)) {
					listaReceitas.add(topo);
				}
			}
		}
		return listaReceitas;
	}

	// DESPESAS 
	
	public boolean verificaIdDespesa(int id) {
		boolean busca = false;
		if (arraySaidas != null) {
			for (Despesa topo : arraySaidas) {
				if (topo.getId() == id) {
					busca = true;
				}
			}
		}
		return busca;
	}

	public static ArrayList<Despesa> despesasPorDescricao(String descricao) {
		ArrayList<Despesa> listaDespesas = null;
		if (arraySaidas != null) {
			listaDespesas = new ArrayList<Despesa>();
			for (Despesa topo : arraySaidas) {
				if (topo.getDescricao().equals(descricao)) {
					listaDespesas.add(topo);
				}
			}
		}
		return listaDespesas;
	}

	public static ArrayList<Despesa> despesasPorAnoTipo(int ano, String tipo) {
		ArrayList<Despesa> listaDespesas = null;
		if (arraySaidas != null) {
			listaDespesas = new ArrayList<Despesa>();
			for (Despesa topo : arraySaidas) {
				if (topo.getAno() == ano && topo.getTipo().equals(tipo)) {
					listaDespesas.add(topo);
				}
			}
		}
		return listaDespesas;
	}

	public static ArrayList<Despesa> despesasPorTipo(String tipo) {
		ArrayList<Despesa> listaDespesas = null;
		if (arraySaidas != null) {
			listaDespesas = new ArrayList<Despesa>();
			for (Despesa topo : arraySaidas) {
				if (topo.getTipo().equals(tipo)) {
					listaDespesas.add(topo);
				}
			}
		}
		return listaDespesas;
	}

	public static ArrayList<Despesa> despesasPorAnoMes(int ano, String mes) {
		ArrayList<Despesa> listaDespesas = null;
		if (arraySaidas != null) {
			listaDespesas = new ArrayList<Despesa>();
			for (Despesa topo : arraySaidas) {
				if (topo.getAno() == ano && topo.getMes().equals(mes)) {
					listaDespesas.add(topo);
				}
			}
		}
		return listaDespesas;
	}

	public static ArrayList<Despesa> despesasPorAnoMesTipo(int ano, String mes, String tipo) {
		ArrayList<Despesa> listaDespesas = null;
		if (arraySaidas != null) {
			listaDespesas = new ArrayList<Despesa>();
			for (Despesa topo : arraySaidas) {
				if ((topo.getAno() == ano && topo.getMes().equals(mes)) && topo.getTipo().equals(tipo)) {
					listaDespesas.add(topo);
				}
			}
		}
		return listaDespesas;
	}

	public static ArrayList<Despesa> despesasPorAno(int ano) {
		ArrayList<Despesa> listaDespesas = null;
		if (arraySaidas != null) {
			listaDespesas = new ArrayList<Despesa>();
			for (Despesa topo : arraySaidas) {
				if (topo.getAno() == ano) {
					listaDespesas.add(topo);
				}
			}
		}
		return listaDespesas;
	}

	public static void setInfos(Infos newInfo) {
		info = newInfo;
	}

	public static Infos getInfo() {
		return info;
	}
	
	// FUNÇÃO LER O ARQUIVO NO DISCO E CARREGA NO ARRAYLIST DE ENTRADA DE ORÇAMENTO ------------------------------------------
	
		public static void lerOrcamento() {
			procuraArqOrcamento();
			try {
				// Criamos um leitor de buffer, passando como parametro um leitor de arquivo e
				// para esse leitor de arquivo passamos o arquivo
				BufferedReader lerBuffer = new BufferedReader(new FileReader(new File("Orcamento.txt")));

				while ((conteudo = lerBuffer.readLine()) != null) {
					Orcamento nova = new Orcamento();
					String[] dados = conteudo.split(";");


				
					nova.setAno(Integer.valueOf(dados[0]));	// 	Ano do orcamento do mes	
					nova.setMes(dados[1]);	//  mes orcamento
					nova.setDescricao(dados[2]);	// Valor orcamento mes
					nova.setValor(Double.valueOf(dados[3]));	// Valor do item / servico
					System.out.println(nova.toString() + "\n");
					
					arrayOrcamento.add(nova);

				}
			} catch (IOException | NumberFormatException e1) {
				System.out.println("Erro ao ler aquivo Orcamento.txt: \n" + e1.getMessage());
			}
		}

		public static boolean gravarOrcamento(Orcamento orcamento) {
			try {

				File arquivo = new File("Orcamento.txt");

				if (!arquivo.exists()) {
					arquivo.createNewFile();
				}

			} catch (IOException e) {
				System.out.println("Erro 1 ao Gravar Orcamento!:" + e.getMessage());
			}

			try {

				conteudo = orcamento.getAno() + ";" + orcamento.getMes() + ";" + orcamento.getDescricao()
						+ ";" + orcamento.getValor() + ";" +  "\n";

				BufferedWriter gravadorBuffer = new BufferedWriter(new FileWriter(new File("Orcamento.txt"), true));

				gravadorBuffer.write(conteudo);
				gravadorBuffer.close();
				return true;
			} catch (IOException e) {
				System.out.println("Erro 2 ao Gravar Orcamento!:" + e.getMessage());
			}
			return false;

		}

		//GARANTE QUE NO FECHAMENTO DO PROGRAMA TUDO SEJA GRAVADO NO DISCO
		public static void gravarTodosOrcamento() {
			try {
				File arquivo = new File("Orcamento.txt");
				if (arquivo.exists()) {
					Files.delete(Paths.get("Orcamento.txt"));
				}
				Thread.sleep(1000);
				arquivo.createNewFile();
			} catch (IOException | InterruptedException e) {
				System.out.println("Erro 1 ao Gravar!:" + e.getMessage());
			}

			for (Orcamento topo : arrayOrcamento) {
				if (topo != null) {
					try {				// ALTERAR
						conteudo =  topo.getAno() + ";" + topo.getMes() + ";" + topo.getDescricao()
								+ ";" + topo.getValor() + ";" + "\n";

						BufferedWriter gravadorBuffer = new BufferedWriter(new FileWriter(new File("Orcamento.txt"), true));

						gravadorBuffer.write(conteudo);
						gravadorBuffer.close();
					} catch (IOException e) {
						System.out.println("Erro 2 ao Gravar!:" + e.getMessage());
					}
				}
			}
		}

		public static void procuraArqOrcamento() {
			try {
				File arquivo = new File("Orcamento.txt");
				if (!arquivo.exists()) {
					arquivo.createNewFile();
					System.out.println("Arquivo Orcamento.txt criado!");
				}
			} catch (IOException e) {
				System.out.println("Erro ao criar o arquivo Orcamento.txt!: " + e.getMessage());
			}
		}
		
		// MANIPULAÇÃO DOS DADOS - ORÇAMENTO
		



		public static ArrayList<Orcamento> OrcamentosPorDescricao(String descricao) {	// DESCRICAO
			ArrayList<Orcamento> listaOrcamento = null;
			if (arrayOrcamento != null) {
				listaOrcamento = new ArrayList<Orcamento>();
				for (Orcamento topo : arrayOrcamento) {
					if (topo.getDescricao().equals(descricao)) {
						listaOrcamento.add(topo);
					}
				}
			}
			return listaOrcamento;
		}

		public static ArrayList<Orcamento> OrcamentoValor(double valor) { 	// VALOR
			ArrayList<Orcamento> listaOrcamento = null;
			if (arrayOrcamento != null) {
				listaOrcamento = new ArrayList<Orcamento>();
				for (Orcamento topo : arrayOrcamento) {
					if (topo.getValor() == valor) {
						listaOrcamento.add(topo);
					}
				}
			}
			return listaOrcamento;
		}

		public static ArrayList<Orcamento> OrcamentosPorAno(int ano) { 	// ANO
			ArrayList<Orcamento> listaOrcamento = null;
			if (arrayOrcamento != null) {
				listaOrcamento = new ArrayList<Orcamento>();
				for (Orcamento topo : arrayOrcamento) {
					if (topo.getAno() == ano) {
						listaOrcamento.add(topo);
					}
				}
			}
			return listaOrcamento;
		}

		public static ArrayList<Orcamento> OrcamentosPorAnoMes(int ano, String mes) { // MES
			ArrayList<Orcamento> listaOrcamento = null;
			if (arrayOrcamento != null) {
				listaOrcamento = new ArrayList<Orcamento>();
				for (Orcamento topo : arrayOrcamento) {
					if (topo.getAno() == ano && topo.getMes().equals(mes)) {
						listaOrcamento.add(topo);
					}
				}
			}
			return listaOrcamento;
		}
		


		
		

}
