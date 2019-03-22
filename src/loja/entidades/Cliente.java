package loja.entidades;

public class Cliente {

	
	
	private String cpfCnpj;
	
	private String nome;
	
	
   

	public Cliente(String cpfCnpj, String nome) {
		super();
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
	}
	
	public Cliente() {
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
	
	@Override
	public String toString() {
		return "Cliente [cpfCnpj=" + cpfCnpj + ", nome=" + nome + "]";
	}
	
	@Override
	protected Cliente clone() {
		Cliente copia = new Cliente(cpfCnpj, nome);
		return copia;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		return true;
	}
	
}
