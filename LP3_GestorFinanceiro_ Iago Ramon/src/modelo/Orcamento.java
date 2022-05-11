package modelo;

public class Orcamento {
	
	
	private double valor_total_orcamento_mes;
	private String Descricao;
	private double Valor;
	private int Ano;
	private String Mes;
	
	public double getvalor_total_orcamento_mes() {		// valor do orcamento no mes
		return valor_total_orcamento_mes;
	}

	public void setvalor_total_orcamento_mes(double valor_total_orcamento_mes) {
		this.valor_total_orcamento_mes = valor_total_orcamento_mes;
	}


	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		this.Descricao = descricao;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double dados) {
		this.Valor = dados;
	}

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		this.Ano = ano;
	}

	public String getMes() {
		return Mes;
	}

	public void setMes(String mes) {
		this.Mes = mes;
	}



}
