package loja.entidades;

import java.math.BigDecimal;

public class Item {
	
	
	private String codigo;

	private Produto produto;
	
	private Integer quantidade;
	
	private BigDecimal valor;

	public Item(String codigo,Produto produto, int quantidade, BigDecimal valor) {
		this.codigo = codigo;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@Override
	protected Item clone()  {
		Item copia = new Item(codigo, produto.clone(), quantidade, valor);
		return copia;
	}

	@Override
	public String toString() {
		return "Item [codigo="+codigo +" produto=" + produto + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
