class Bibliotecario {
	String email;
	String nome;
	String senha;

	public Bibliotecario(String e, String n, String s) {
		email = e;
		nome = n;
		senha = s;
	}

	public boolean cadastrarLivro(Livro livreto, Acervo acervo) {
		Livro novo = livreto;

		if(acervo.inicio == null) {
			acervo.inicio = novo;
			return true;
		}

		Livro atual = acervo.inicio;

		while(atual.proximo != null) {
			atual = atual.proximo;
		}

		atual.proximo = novo;
		return true;
	}

	public boolean atualizarLivro(String titulo,String autor, String categoria, Acervo acervo) {
		Livro atual = acervo.inicio;


		while(atual != null) {
			if(atual.titulo == titulo) {
				break;
			}
			atual = atual.proximo;
		}
		if(atual.titulo == titulo) {
			atual.autor = autor;
			atual.categoria = categoria;
			return true;
		} else {
			System.out.println("Livro inexistente");
			return false;
		}

	}

	public void gerarRelatorio(Usuario usuario) {
		System.out.println("Alugueis: " + usuario.relatorio.alugueis);
		System.out.println("Atrasos: " + usuario.relatorio.atrasos);
	}
}