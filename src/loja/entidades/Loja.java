package loja.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Loja {
	
	
	private AtomicInteger codigosProduto = new AtomicInteger(100);
	
	private AtomicInteger codigosVenda = new AtomicInteger(1000);


	private List<Produto> produtos = new ArrayList<>();

	private List<Venda> vendas = new ArrayList<>();

	private List<Cliente> clientes = new ArrayList<>();

	public Loja() {

	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void salvarProduto(Produto produto) {
		if(produto.getCodigo() == null) {
			produto.setCodigo(codigosProduto.getAndIncrement()+"");
			this.produtos.add(produto);
		}else {
			Produto p = obterProduto(produto);
			p.setNome(produto.getNome());
			p.setValor(produto.getValor());
		}
	}

	public Produto obterProduto(String codigo) {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		Produto original = obterProduto(produto);
		if(original != null) {
			return original.clone();
		}else {
			return null;
		}
	}
	
	private Produto obterProduto(Produto produto) {
		int index = produtos.indexOf(produto);
		if(index != -1) {
			return produtos.get(index);
		}else {
			return null;
		}
	}

	public void excluir(Produto produto) {
		produtos.remove(produto);
	}

	public void salvarCliente(Cliente cliente) {
		if(!clientes.contains(cliente)) {
			this.clientes.add(cliente);
		}else {
			Cliente c = obterCliente(cliente);
			c.setNome(cliente.getNome());
		}
	}

	private Cliente obterCliente(Cliente cliente) {
		int index = clientes.indexOf(cliente);
		if(index != -1) {
			return clientes.get(index);
		}else {
			return null;
		}
	}

	public Cliente obterCliente(String cpfCnpj) {
		Cliente cliente = new Cliente();
		cliente.setCpfCnpj(cpfCnpj);
		Cliente original = obterCliente(cliente);
		if(original != null) {
			return original.clone();
		}else {
			return null;
		}
	}

	public void excluir(Cliente cliente) {
		clientes.remove(cliente);
	}

	public void salvarVenda(Venda venda) {
		if(venda.getCodigo() == null) {
			venda.setCodigo(codigosVenda.getAndIncrement()+"");
			this.vendas.add(venda);
		}
	}

	public Venda obterVenda(String codigo) {
		Venda venda = new Venda();
		venda.setCodigo(codigo);
		Venda original = obterVenda(venda);
		if(original != null) {
			return original.clone();
		}else {
			return null;
		}
	}

	private Venda obterVenda(Venda venda) {
		int index = vendas.indexOf(venda);
		if(index != -1) {
			return vendas.get(index);
		}else {
			return null;
		}	
	}

	public void excluir(Venda venda) {
		this.vendas.remove(venda);
	}

}
