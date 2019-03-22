package loja.entidades;

import java.math.BigDecimal;

public class Produto {

	
	private String codigo;
	
	private String nome;
	
	private BigDecimal valor;
	
	
	public Produto() {
	}
	
	public Produto(String nome, String valor) {
		this(nome,new BigDecimal(valor));
	}
	

	public Produto(String nome, BigDecimal valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
	


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "Produto [Codigo: " + codigo + ", Nome: " + nome + ", Valor: R$" + valor + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	@Override
	protected Produto clone()  {
		Produto copia = new Produto(nome, valor);
		copia.setCodigo(codigo);
		return copia;
	}
	
}
