package loja.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Venda {
	
	private AtomicInteger item = new AtomicInteger(1);

	
	private String codigo;

	private Cliente cliente;
	
	private BigDecimal valor;
	
	private List<Item> itens = new ArrayList<>();

	public Venda(Cliente cliente) {
		this.setCliente(cliente);
	}



	public Venda() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}



	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void adicionaItem(Produto produto) {
		this.adicionaItem(produto, 1);
	}

	public void adicionaItem(Produto produto, int quantidade) {
		itens.add(new Item(item.getAndIncrement()+"",produto,quantidade,produto.getValor()));		
	}

	
	public void fechar() {
		fechar(new BigDecimal(0));
	}
	
	public void fechar(BigDecimal desconto) {
		BigDecimal total = BigDecimal.ZERO;
		for (Item item : itens) {
			total = total.add(item.getValor().multiply(BigDecimal.valueOf(item.getQuantidade())));
		}
		this.valor = total.subtract(desconto);
		
	}

	@Override
	public String toString() {
		return "Venda [ " + this.cliente + ", valor=" + valor + "]";
	}
	
	public String vendaComItensToString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Venda: \n");
		stringBuffer.append("Codigo: ");
		if(this.codigo!=null) {
			stringBuffer.append(this.codigo);
		}
		stringBuffer.append("\n");
		stringBuffer.append("Cliente \n");
		stringBuffer.append("CPF/CNPJ: ");
		stringBuffer.append(this.cliente.getCpfCnpj());
		stringBuffer.append(" Nome: ");
		stringBuffer.append(this.cliente.getNome());
		stringBuffer.append("\n");
		stringBuffer.append("ITENS \n");
		for (Item item : itens) {
			stringBuffer.append(item);
			stringBuffer.append("\n");
		}
		 return stringBuffer.toString();
	}
	
	



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	@Override
	protected Venda clone() {
		Venda venda = new Venda();
		venda.setCodigo(codigo);
		venda.setCliente(cliente.clone());
		List<Item> copia = new ArrayList<>();
		for (Item item : itens) {
			copia.add(item.clone());
		}
		venda.setItens(copia);
		return venda;
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
		Venda other = (Venda) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}



	public Item obterItem(String codigo) {
		Item item = new Item();
		item.setCodigo(codigo);
		Item original = obterItem(item);
		if(original != null) {
			return original.clone();
		}else { 
			return null;
		}
	}



	public void excluir(Item item) {
		obterItem(item);
		itens.remove(item);
	}



	private Item obterItem(Item item) {
		int index = itens.indexOf(item);
		if(index != -1) {
			return itens.get(index);
		}else {
			return null;
		}
		
	}
	
	
 
	
	
}
