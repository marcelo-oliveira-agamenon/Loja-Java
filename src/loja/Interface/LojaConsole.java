package loja.Interface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import loja.entidades.Cliente;
import loja.entidades.Item;
import loja.entidades.Loja;
import loja.entidades.Produto;
import loja.entidades.Venda;

public class LojaConsole extends JFrame{

	private static final long serialVersionUID = 1L;

	private Loja loja;

	public LojaConsole(Loja loja) {
		this.loja = loja;
	}

	public void iniciar() {
		this.menu();
	}

	public void menu() {
		Painel principal = new Painel();
		principal.setVisible(true);
	}

	protected void listar(List<?> lista) {
		JFrame tela = new JFrame("Listagem");
		JPanel panel = new JPanel();
		tela.setSize(300, 300);
		
		Object [][] dados = {
				{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
				{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
		};

		String [] colunas = {"Nome", "Telefone", "Email"};
		JScrollPane js = new JScrollPane();
		JTable table = new JTable();
		table = new JTable(dados, colunas);
		js.add(table);
		panel.add(js);
		tela.add(panel);
		tela.setVisible(true);

		/*Produto p = new Produto();
		Venda v = new Venda();

		if (lista.contains(p)) {
			
		} else if (lista.contains(v)) {

		} else {

		}

		/*for (Object object : lista) {

			table.add(comp);
		}*/
	}

	protected void excluirProduto() {
		JFrame excluirProdutos = new JFrame("Excluir Produtos");
		excluirProdutos.setVisible(true);
		excluirProdutos.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("Código do produto:");
		JTextField txtF1 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		excluirProdutos.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String codigo = txtF1.getText();
				Produto produto = loja.obterProduto(codigo);

				if (produto != null) {
					int  opcao = JOptionPane.showConfirmDialog(jErro1, "Confirma Exclusão => " + produto);
					if (opcao == 0) {
						loja.excluir(produto);
						JOptionPane.showMessageDialog(jErro1, "Produto Excluído com Sucesso");
					} else {
						JOptionPane.showMessageDialog(jErro1, "Exclusão Cancelada!");
					}
				} else {
					JOptionPane.showMessageDialog(jErro1, "Não existe produto com esse codigo");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirProdutos.dispose();
			}
		});
	}

	protected void alterarProduto() {	
		JFrame alterarProdutos = new JFrame("Alterar Produtos");
		alterarProdutos.setVisible(true);
		alterarProdutos.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("Código do produto:");
		JTextField txtF1 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		alterarProdutos.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String codigo = txtF1.getText();
				Produto produto = loja.obterProduto(codigo);

				int erros = 0;

				String nome = null;
				String valorString = null;
				BigDecimal valor = null;

				if (produto != null) {
					nome = JOptionPane.showInputDialog(jErro1, "Nome [" + produto.getNome() + "]: ");
					if (nome.length() == 0) {
						nome = produto.getNome();
					}
					valorString = JOptionPane.showInputDialog(jErro1, "Valor [" + produto.getValor() + "]:");
					if (valorString.length() == 0) {
						valorString = produto.getValor().toPlainString();
					}

					if (nome.length() < 3) {
						JOptionPane.showMessageDialog(jErro1, "Nome Invalida: O nome deve ter mais que 3 caracteres");
						erros++;
					}
					try {
						valor = new BigDecimal(valorString);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(jErro1, "Valor Invalida:  (use o formato 0000.00) ");
						erros++;
					}

				} else {
					JOptionPane.showMessageDialog(jErro1, "Não existe produto com esse Código");
					erros++;
				}

				if (erros == 0) {
					produto.setNome(nome);
					produto.setValor(valor);
					loja.salvarProduto(produto);
					JOptionPane.showMessageDialog(jErro1, "Salvo com Sucesso");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alterarProdutos.dispose();
			}
		});
	}

	protected void inserirProduto() {
		JFrame inserirProdutos = new JFrame("Inserir Produtos");
		inserirProdutos.setVisible(true);
		inserirProdutos.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("Inserir nome do produto:");
		JTextField txtF1 = new JTextField(50);

		JLabel txt2 = new JLabel("Inserir valor do produto: (0.00)");	
		JTextField txtF2 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(txt2);
		p1.add(txtF2);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		inserirProdutos.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String nome = txtF1.getText();
				String valor = txtF2.getText();	

				int erros = 0;
				if (nome.length() < 3) {
					JOptionPane.showMessageDialog(jErro1, "Nome Inválido!");
					erros++;
				}

				BigDecimal valorNumber = null;

				try {
					valorNumber = new BigDecimal(valor);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(jErro1, "Valor Invalida:  (use o formato 0000.00) ");
					erros++;
				}

				if (erros == 0) {
					Produto produto = new Produto(nome, valorNumber);
					loja.salvarProduto(produto);
					JOptionPane.showMessageDialog(jErro1, "Salvo com Sucesso");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inserirProdutos.dispose();
			}
		});
	}

	protected void inserirCliente() {	
		JFrame inserirClientes = new JFrame("Inserir Clientes");
		inserirClientes.setVisible(true);
		inserirClientes.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("Inserir nome do cliente:");
		JTextField txtF1 = new JTextField(50);

		JLabel txt2 = new JLabel("Inserir CPF ou CNPJ dp cliente:");	
		JTextField txtF2 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(txt2);
		p1.add(txtF2);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		inserirClientes.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String nome = txtF1.getText();
				String cpfCnpj = txtF2.getText();	

				int erros = 0;
				if ( !(cpfCnpj.length() == 11 || cpfCnpj.length() == 14) ) {
					JOptionPane.showMessageDialog(jErro1, "CPF ou CNPJ Inválidos: Digite apenas números para o CFP (11) ou CNPJ (14)");
					erros++;
				}

				if (nome.length() < 3) {
					JOptionPane.showMessageDialog(jErro1, "Nome Inválido: O nome deve ter mais que 3 caracteres");
					erros++;
				}

				if (erros == 0) {
					Cliente cliente = new Cliente(cpfCnpj, nome);
					loja.salvarCliente(cliente);
					JOptionPane.showMessageDialog(jErro1, "Salvo com Sucesso");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inserirClientes.dispose();
			}
		});
	}

	protected void alterarCliente() {	
		JFrame alterarClientes = new JFrame("Alterar Clientes");
		alterarClientes.setVisible(true);
		alterarClientes.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("CPF ou CNPJ do cliente:");
		JTextField txtF1 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		alterarClientes.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String nome = null;
				String cpfCnpj = txtF1.getText();
				Cliente cliente = loja.obterCliente(cpfCnpj);

				int erros = 0;
				if (cliente != null) {
					nome = JOptionPane.showInputDialog(jErro1, "Nome [" + cliente.getNome() + "]: ");
					if (nome.length() == 0) {
						nome = cliente.getNome();
					}

					if (nome.length() < 3) {
						JOptionPane.showMessageDialog(jErro1, "Nome Inválido: O nome deve ter mais que 3 caracteres");
						erros++;
					}

				} else {
					JOptionPane.showMessageDialog(jErro1, "Não existe cliente com esse CPF ou CNPJ");
					erros++;
				}

				if (erros == 0) {
					cliente.setNome(nome);
					loja.salvarCliente(cliente);
					JOptionPane.showMessageDialog(jErro1, "Salvo com Sucesso");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alterarClientes.dispose();
			}
		});
	}

	protected void excluirCliente() {
		JFrame excluirCliente = new JFrame("Excluir Cliente");
		excluirCliente.setVisible(true);
		excluirCliente.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("CPF ou CNPJ do cliente:");
		JTextField txtF1 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		excluirCliente.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String cpfCnpj = txtF1.getText();
				Cliente cliente = loja.obterCliente(cpfCnpj);

				if (cliente != null) {
					int  opcao = JOptionPane.showConfirmDialog(jErro1, "Confirma Exclusão => " + cliente);
					if (opcao == 0) {
						loja.excluir(cliente);
						JOptionPane.showMessageDialog(jErro1, "Produto Excluído com Sucesso");
					} else {
						JOptionPane.showMessageDialog(jErro1, "Exclusão Cancelada!");
					}
				} else {
					JOptionPane.showMessageDialog(jErro1, "Não existe produto com esse codigo");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirCliente.dispose();
			}
		});
	}

	protected void excluirVenda() {
		JFrame excluirVenda = new JFrame("Excluir Venda");
		excluirVenda.setVisible(true);
		excluirVenda.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("Codigo da Venda:");
		JTextField txtF1 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		excluirVenda.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String codigo = txtF1.getText();
				Venda venda = loja.obterVenda(codigo);

				if (venda != null) {
					int opcao = JOptionPane.showConfirmDialog(jErro1, "Confirma Exclusão => " + venda);
					if (opcao == 0) {
						loja.excluir(venda);
						JOptionPane.showMessageDialog(jErro1, "Venda Excluído com Sucesso");
					} else {
						JOptionPane.showMessageDialog(jErro1, "Exclusão Cancelada!");
					}
				} else {
					JOptionPane.showMessageDialog(jErro1, "Não existe venda com esse codigo");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirVenda.dispose();
			}
		});
	}

	protected void inserirVenda() {
		JFrame inserirVenda = new JFrame("Inserir Venda");
		inserirVenda.setVisible(true);
		inserirVenda.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("Digite o CPF ou CNPJ do Cliente:");
		JTextField txtF1 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		inserirVenda.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String cpfCnpj = txtF1.getText();
				Cliente cliente = loja.obterCliente(cpfCnpj);

				if (cliente != null) {
					Venda venda = new Venda(cliente);
					menuVenda(venda);
					loja.salvarVenda(venda);
					JOptionPane.showMessageDialog(jErro1, "Salvo com Sucesso");
				} else {
					JOptionPane.showMessageDialog(jErro1, "Não existe cliente com esse CPF ou CNPJ, insira o cliente antes");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inserirVenda.dispose();
			}
		});
	}

	private void menuVenda(Venda venda) {	
		JFrame menuVenda = new JFrame("Menu Venda");
		menuVenda.setVisible(true);
		menuVenda.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JButton btnInserir = new JButton("Inserir Item");
		JButton btnExcluir = new JButton("Excluir Item");
		JButton btnFechar = new JButton("Excluir Item");

		p1.add(btnInserir);
		p1.add(btnExcluir);
		p1.add(btnFechar);
		menuVenda.add(p1);

		btnInserir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				inserirItem(venda);
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				excluirItem(venda);
			}
		});

		btnFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuVenda.dispose();
			}
		});
	}

	private void excluirItem(Venda venda) {
		JFrame excluirItem = new JFrame("Excluir Item da Venda");
		excluirItem.setVisible(true);
		excluirItem.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("Codigo do Item:");
		JTextField txtF1 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		excluirItem.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String codigo = txtF1.getText();
				Item item = venda.obterItem(codigo);

				if (item != null) {
					int opcao = JOptionPane.showConfirmDialog(jErro1, "Confirma Exclusão => " + item);
					if (opcao == 0) {
						loja.excluir(venda);
						JOptionPane.showMessageDialog(jErro1, "Item Excluído com Sucesso");
					} else {
						JOptionPane.showMessageDialog(jErro1, "Exclusão Cancelada!");
					}
				} else {
					JOptionPane.showMessageDialog(jErro1, "Não existe item com esse codigo");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirItem.dispose();
			}
		});
	}

	private void inserirItem(Venda venda) {
		JFrame inserirItem = new JFrame("Inserir Item da Venda");
		inserirItem.setVisible(true);
		inserirItem.setSize(600, 130);

		JPanel p1 = new JPanel(new GridLayout(3,1));

		JLabel txt1 = new JLabel("Codigo do Produto:");
		JTextField txtF1 = new JTextField(50);

		JButton btnConfirma = new JButton("Confirma");
		JButton btnVoltar = new JButton("Voltar");

		p1.add(txt1);
		p1.add(txtF1);
		p1.add(btnConfirma);
		p1.add(btnVoltar);
		inserirItem.add(p1);

		JPopupMenu jErro1 = new JPopupMenu("Atenção!");

		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				String codigo = txtF1.getText();
				Produto produto = loja.obterProduto(codigo);

				if (produto != null) {
					venda.adicionaItem(produto);
					JOptionPane.showMessageDialog(jErro1, "Produto Adicionado!");
				} else {
					JOptionPane.showMessageDialog(jErro1, "Produto Não existe");
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inserirItem.dispose();
			}
		});
	}
}
