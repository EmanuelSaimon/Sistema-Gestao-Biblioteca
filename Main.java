
public class Main
{
	public static void main(String[] args) {
		Usuario emanuel = new Usuario("abc@gmail.com", "Emanuel","senha", Tipo.ALUNO);
		Acervo acervoGru = new Acervo();
		Bibliotecario bliFatec = new Bibliotecario("abc@gmail.com", "bibi", "1234");
		bliFatec.cadastrarLivro(new Livro("Metamorfose", "Franz Kafka", "Conto"), acervoGru);
		bliFatec.cadastrarLivro(new Livro("Calafrios", "Junji Ito", "Manga"), acervoGru);
		emanuel.alugarLivro(acervoGru, "Calafrios");
		bliFatec.gerarRelatorio(emanuel);
	}
}
