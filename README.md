# Sistema de Gestão de Biblioteca Universitária

Este projeto tem como objetivo desenvolver um sistema informatizado e responsivo para a gestão de empréstimos, devoluções, reservas e acervos de uma Biblioteca Universitária, substituindo os processos manuais e otimizando a autonomia dos usuários e a geração de relatórios estratégicos.

## Visão Geral e Funcionalidades

O sistema visa modernizar a gestão da Biblioteca Central da Universidade Nova Esperança, oferecendo uma plataforma intuitiva e eficiente para:

* **Cadastro de Usuários:** Alunos e professores poderão se registrar no sistema.
* **Busca e Consulta de Livros:** Pesquisa de títulos por título, autor ou categoria, com verificação de disponibilidade.
* **Empréstimos e Renovações:**
    * Alunos poderão emprestar até cinco livros simultaneamente.
    * Prazo padrão de devolução de 14 dias.
    * Possibilidade de prorrogação por mais 7 dias (se o livro não estiver reservado).
* **Reservas:** Permite reservar títulos indisponíveis, com notificação automática por e-mail quando o exemplar estiver disponível.
* **Gestão de Acervo (Bibliotecários):**
    * Cadastro de novos livros.
    * Atualização de informações de livros.
* **Relatórios e Estatísticas (Bibliotecários):**
    * Geração de relatórios de uso do acervo.
    * Geração de relatórios de atrasos.
    * Sinalização automática de livros com mais de 30 dias de atraso para aplicação de sanções.
* **Controle de Acesso por Perfil:** Diferenciação de funcionalidades entre usuários (alunos/professores) e bibliotecários.
* **Responsividade:** O sistema será compatível com desktops e tablets, facilitando o uso no balcão da biblioteca e por parte dos usuários.

## Motivação

Atualmente, todos os processos de empréstimo, devolução e reserva são realizados manualmente, gerando transtornos e falta de controle sobre os livros mais requisitados. Este projeto busca informatizar essas operações para:

* Reduzir atrasos e melhorar a gestão do acervo.
* Oferecer mais autonomia aos usuários para consultar e gerenciar seus empréstimos.
* Fornecer dados e relatórios precisos para auxiliar a direção da biblioteca na tomada de decisões estratégicas.

## Estrutura do Código

O projeto está organizado em classes Java, onde cada classe representa uma entidade ou funcionalidade do sistema.

* `Acervo.java`: Representa a coleção de livros da biblioteca, utilizando uma lista encadeada simples para armazenar os livros.
* `Bibliotecario.java`: Contém as funcionalidades específicas para o perfil do bibliotecário, como cadastrar e atualizar livros, e gerar relatórios.
* `Livro.java`: Define a estrutura de um livro, incluindo seu título, autor, categoria, e status de reserva e empréstimo.
* `Relatorio.java`: Armazena informações de relatórios de uso do usuário, como número de aluguéis e atrasos.
* `Tipo.java`: Um `enum` para definir os tipos de usuário (ALUNO, PROFESSOR).
* `Usuario.java`: Define a estrutura de um usuário e suas ações, como pesquisar, verificar disponibilidade, alugar e reservar livros.
* `Main.java`: A classe principal para executar o programa e demonstrar suas funcionalidades.

## Como Executar o Projeto

Para rodar este projeto em sua máquina, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter o Java Development Kit (JDK) instalado em seu sistema. Você pode baixá-lo e instalá-lo a partir do site oficial da Oracle ou de outras distribuições OpenJDK.

### Compilação e Execução

1.  **Clone o repositório (se aplicável):**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    cd [NOME_DO_SEU_REPOSITORIO]
    ```

2.  **Compile os arquivos `.java`:**
    Abra o terminal na pasta raiz do projeto (onde estão os arquivos `.java`) e execute o seguinte comando para compilar todas as classes:
    ```bash
    javac *.java
    ```
    Isso criará os arquivos `.class` correspondentes.

3.  **Execute o programa:**
    Após a compilação, execute a classe `Main`:
    ```bash
    java Main
    ```

### Exemplo de Uso (contido em `Main.java`)

O arquivo `Main.java` contém um exemplo básico de como as classes interagem:

```java
public class Main
{
	public static void main(String[] args) {
		Usuario emanuel = new Usuario("abc@gmail.com", "Emanuel","senha", Tipo.ALUNO);
		Acervo acervoGru = new Acervo();
		Bibliotecario bliFatec = new Bibliotecario("abc@gmail.com", "bibi", "1234");

		// Cadastra livros no acervo
		bliFatec.cadastrarLivro(new Livro("Metamorfose", "Franz Kafka", "Conto"), acervoGru);
		bliFatec.cadastrarLivro(new Livro("Calafrios", "Junji Ito", "Manga"), acervoGru);

		// Emanuel (aluno) aluga um livro
		emanuel.alugarLivro(acervoGru, "Calafrios");

		// Bibliotecário gera relatório para Emanuel
		bliFatec.gerarRelatorio(emanuel);
	}
}
