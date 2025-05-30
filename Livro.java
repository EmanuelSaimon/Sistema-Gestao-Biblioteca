class Livro {
	String titulo;
	String autor;
	String categoria;
	Boolean reserva;
	Boolean emprestado;
	Livro proximo;

	public Livro(String t, String a, String c) {
		titulo = t;
		autor = a;
		categoria = c;
		reserva = false;
		emprestado = false;
		proximo = null;
	}

	public boolean disponibilidade() {
		return emprestado == false;
	}

	public boolean reservado() {
		return reserva == true;
	}
}