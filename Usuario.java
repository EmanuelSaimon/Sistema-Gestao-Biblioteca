class Usuario {
	String email;
	String nome;
	String senha;
	Tipo tipo;
	Relatorio relatorio;
	int livros;

	public Usuario(String e, String n, String s, Tipo t) {
		email = e;
		nome = n;
		senha = s;
		tipo = t;
		relatorio = new Relatorio();
		livros = 0;
	}

	public Livro pesquisarLivro(Acervo acervo, String titulo) {
		Livro atual = acervo.inicio;

		while(atual != null) {
			if(atual.titulo == titulo) {
				System.out.println(atual.titulo + " existe!");
				return atual;
			}
			atual = atual.proximo;
		}
		System.out.println("Livro inexistente");
		return null;
	}

	public void verificarDispLivro(Acervo acervo, String titulo) {
		Livro procurado = pesquisarLivro(acervo, titulo);
		if(procurado != null) {
			if(procurado.disponibilidade())
				System.out.println("Livro disponivel");
			else
				System.out.println("Livro indisponivel");
		}
	}

	public void alugarLivro(Acervo acervo, String titulo) {
		Livro procurado = acervo.inicio;

		while(procurado != null) {
			if(procurado.titulo == titulo) {
				break;
			}
			procurado = procurado.proximo;
		}

		if(tipo == Tipo.ALUNO) {
			if(livros > 5) {
				System.out.println("Limite de livros atingidos");
			}
			else {
				if(procurado.disponibilidade()) {
					System.out.println("O livro foi alugado!");
					procurado.emprestado = true;
					relatorio.alugueis++;
					livros++;
				} else {
					System.out.println("Livro indisponivel");
				}
			}
		} else {
			if(procurado.disponibilidade()) {
				System.out.println("O livro foi alugado!");
				procurado.emprestado = true;
				relatorio.alugueis++;
			} else {
				System.out.println("Livro indisponivel");
			}
		}

	}

	public void reservarLivro(Acervo acervo, String titulo) {
		Livro procurado = pesquisarLivro(acervo, titulo);
		if(procurado.reservado()) {
			System.out.println("Livro jC! reservado");
		}
		else {
			System.out.println("O livro foi reservado!");
			procurado.reserva = true;
		}
	}
}