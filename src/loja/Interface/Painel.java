package loja.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import loja.entidades.Loja;

public class Painel extends JFrame{

	private static final long serialVersionUID = 1L;

	private JButton btnProdutos = new JButton("Produtos");
	private JButton btnClientes = new JButton("Clientes");
	private JButton btnVendas = new JButton("Vendas");
	private JButton btnSair = new JButton("Sair");
	
	private JButton btnInserirProdutos = new JButton("Inserir");
	private JButton btnAlterarProdutos = new JButton("Alterar");
	private JButton btnExcluirProdutos = new JButton("Excluir");
	private JButton btnListarProdutos = new JButton("Listar");
	private JButton btnVoltarProdutos = new JButton("Voltar");
	
	private JButton btnInserirClientes = new JButton("Inserir");
	private JButton btnAlterarClientes = new JButton("Alterar");
	private JButton btnExcluirClientes = new JButton("Excluir");
	private JButton btnListarClientes = new JButton("Listar");
	private JButton btnVoltarClientes = new JButton("Voltar");
	
	private JButton btnInserirVendas = new JButton("Inserir");
	private JButton btnExcluirVendas = new JButton("Excluir");
	private JButton btnListarVendas = new JButton("Listar");
	private JButton btnVoltarVendas = new JButton("Voltar");

	public Painel(){

		Loja loja = new Loja();
		LojaConsole lojaConsole = new LojaConsole(loja);

		JFrame janelaPrinc = new JFrame("Loja Avançada");
		janelaPrinc.setVisible(true);
		janelaPrinc.setSize(400, 100);
		
		JFrame janelaProduto = new JFrame("Área de Produtos");
		janelaProduto.setSize(500, 100);
		
		JFrame janelaCliente = new JFrame("Área de Clientes");
		janelaCliente.setSize(500, 100);
		
		JFrame janelaVendas = new JFrame("Área de Vendas");
		janelaVendas.setSize(400, 100);
		
		JPanel botoesProduto = new JPanel();
		botoesProduto.add(btnInserirProdutos);
		botoesProduto.add(btnAlterarProdutos);
		botoesProduto.add(btnExcluirProdutos);
		botoesProduto.add(btnListarProdutos);
		botoesProduto.add(btnVoltarProdutos);
		botoesProduto.setSize(100, 100);		

		JPanel botoesPrinc = new JPanel();
		botoesPrinc.add(btnClientes);
		botoesPrinc.add(btnProdutos);
		botoesPrinc.add(btnVendas);
		botoesPrinc.add(btnSair);
		botoesPrinc.setSize(100, 100);	
		
		JPanel botoesClientes = new JPanel();
		botoesClientes.add(btnInserirClientes);
		botoesClientes.add(btnAlterarClientes);
		botoesClientes.add(btnExcluirClientes);
		botoesClientes.add(btnListarClientes);
		botoesClientes.add(btnVoltarClientes);
		botoesClientes.setSize(100, 100);
		
		JPanel botoesVendas = new JPanel();
		botoesVendas.add(btnInserirVendas);
		botoesVendas.add(btnExcluirVendas);
		botoesVendas.add(btnListarVendas);
		botoesVendas.add(btnVoltarVendas);
		botoesVendas.setSize(100, 100);

		janelaPrinc.add(botoesPrinc);
		janelaProduto.add(botoesProduto);
		janelaCliente.add(botoesClientes);
		janelaVendas.add(botoesVendas);

		btnProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janelaProduto.setVisible(true);
			}
		});

		btnClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janelaCliente.setVisible(true);
			}
		});

		btnVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janelaVendas.setVisible(true);
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		
		btnInserirProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.inserirProduto();
			}
		});
		
		btnAlterarProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.alterarProduto();
			}
		});
		
		btnExcluirProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.excluirProduto();
			}
		});
		
		btnListarProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.listar(loja.getProdutos());
			}
		});
		
		btnVoltarProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janelaProduto.dispose();
			}
		});
		
		btnInserirClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.inserirCliente();
			}
		});
		
		btnAlterarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.alterarCliente();
			}
		});
		
		btnExcluirClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.excluirCliente();
			}
		});
		
		btnListarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.listar(loja.getClientes());
			}
		});
		
		btnVoltarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janelaCliente.dispose();
			}
		});
		
		btnInserirVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.inserirVenda();
			}
		});
		
		btnExcluirVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.excluirVenda();
			}
		});
		
		btnListarVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lojaConsole.listar(loja.getVendas());
			}
		});
		
		btnVoltarVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janelaVendas.dispose();
			}
		});
	}
}
