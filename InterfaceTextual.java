import java.util.Locale;
import java.util.Scanner;


public class InterfaceTextual {
	private static Scanner sc;
	private static Fachada fachada;
	
	
	private static final int OP_CRIAR_ALUNO = 1;
	private static final int OP_CONSULTAR_ALUNO =2;
	private static final int OP_ATUALIZAR_ALUNO = 3;
	private static final int OP_REMOVER_ALUNO = 4;
	private static final int OP_CRIAR_CURSO= 5;
	private static final int OP_CONSULTAR_CURSO = 6;
	private static final int OP_ATUALIZAR_CURSO = 7;
	private static final int OP_REMOVER_CURSO = 8;
	private static final int OP_MATRICULAR_ALUNO = 9;
	private static final int OP_CONSULTAR_MATRICULA = 10;
	private static final int OP_REMOVER_MATRICULA = 11;
	private static final int OP_LISTAR_MATRICULAS = 12;
	private static final int OP_LISTAR_CURSOS = 13;
	private static final int OP_LISTAR_ALUNOS = 14;
	private static final int OP_LISTAR_ALUNOS_CURSO = 15;
	private static final int OP_LISTAR_ALUNOS_TODOS_CURSOS = 16;
	private static final int OP_LISTAR_TODOS_CURSOS_ALUNO = 17;
	private static final int OP_LISTAR_TODOS_CURSOS_TODOS_ALUNOS = 18;
	private static final int OP_LISTAR_TODAS_MATRICULAS_ALUNO = 19;
	private static final int OP_LISTAR_TODAS_MATRICULAS_CURSO = 20;
	private static final int OP_LISTAR_ALUNOS_SEM_CURSO = 21;
	private static final int OP_LISTAR_CURSOS_SEM_ALUNO = 22;
	private static final int OP_SAIR = 23;
	private static final int OP_INICIAL = -1;
	
	
	public static void main(String []args){
		
	
		init();
		int opcao = OP_INICIAL;
		do {
			imprimeTela();
			opcao = pegaOpcao();
			realizaOperacao(opcao);
		}while (opcao != OP_SAIR);

	}
	
	public static void reportar_erro(String msg){
		System.out.println(msg);
	}
	
	
	public static void realizaOperacao(int opcao){
		String nome, endereco, telefone;
		String codigo, instrutor, nomeCurso;
		codigo = instrutor = nomeCurso = null;
		nome = endereco = telefone = null;
		int idade;
		
		Aluno aluno = null;
		Curso curso = null;
		Matricula matricula = null;
		
		int achou;
		Curso[] arr_cursos = fachada.getListaCursos();
        	int n_arr_cursos = fachada.getIndiceCursos();
        	Aluno[] arr_alunos = fachada.getListaAlunos();
        	int n_arr_alunos = fachada.getIndiceAlunos();
        	Matricula[] arr_matriculas = fachada.getListaMatriculas();
        	int n_arr_matriculas = fachada.getIndiceMatriculas();	
		
		switch (opcao){
		case OP_CRIAR_ALUNO:
			System.out.println("Favor informe o nome do aluno e tecle Enter: ");
			nome = sc.nextLine();
			System.out.println("Favor informe o endereco do aluno e tecle Enter: ");
			endereco = sc.nextLine();
			System.out.println("Favor informe o telefone do aluno e tecle Enter: ");
			telefone = sc.nextLine();
			System.out.println("Favor informe a idade do aluno e tecle Enter: ");
			idade = sc.nextInt();
			aluno = new Aluno(nome, endereco, telefone, idade);
			fachada.cadastrar(aluno);
			break;
		case OP_CONSULTAR_ALUNO:
			System.out.println("Favor informe o nome do aluno");
			nome = sc.nextLine();
			aluno = fachada.procurarAluno(nome);
			if (aluno != null) {
				System.out.println("Nome do aluno: " + aluno.getNome());
				System.out.println("Endereco do aluno: " + aluno.getEndereco());
				System.out.println("Telefone do aluno: " + aluno.getTelefone());
				System.out.println("Idade do aluno: " + aluno.getIdade());
				
			}
			break;
		case OP_ATUALIZAR_ALUNO:
			System.out.println("Favor informe o nome do aluno a ser atualizado");
			nome = sc.nextLine();
			System.out.println("Favor informe o novo endereco do aluno");
			endereco = sc.nextLine();
			System.out.println("Favor informe o novo telefone do aluno");
			telefone = sc.nextLine();
			System.out.println("Favor informe a nova idade do aluno");
			idade = sc.nextInt();
			aluno = new Aluno(nome, endereco, telefone, idade);
			fachada.atualizar(aluno);
			break;
			
		case OP_REMOVER_ALUNO:
			System.out.println("Favor informe o nome do aluno a ser removido");
			nome = sc.nextLine();
			fachada.removerAluno(nome);
			break;
			
		case OP_CRIAR_CURSO:
			System.out.println("Favor informe o nome do curso: ");
			nomeCurso = sc.nextLine();
			System.out.println("Favor informe o codigo do curso: ");
			codigo = sc.nextLine();
			System.out.println("Favor informe o instrutor do curso:");
			instrutor = sc.nextLine();
			curso = new Curso(codigo, nomeCurso, instrutor);
			fachada.cadastrar(curso);
			break;
			
		case OP_CONSULTAR_CURSO:
			System.out.println("Favor informe o codigo do curso: ");
			codigo = sc.nextLine();
			curso = fachada.procurarCurso(codigo);
			if(curso!=null){
				System.out.println("Nome do curso: " + curso.getNome());
				System.out.println("Codigo do curso: " + curso.getCodigo());
				System.out.println("Instrutor do curso: " + curso.getInstrutor());
				
			}
			break;
		case OP_ATUALIZAR_CURSO:
			System.out.println("Favor informe o codigo do curso a ser atualizado: ");
			codigo = sc.nextLine();
			System.out.println("Favor informe o novo nome do curso: ");
			nomeCurso = sc.nextLine();
			System.out.println("Favor informe o novo instrutor do curso:");
			instrutor = sc.nextLine();
			curso = new Curso(codigo, nomeCurso, instrutor);
			fachada.atualizar(curso);
			break;
			
		case OP_REMOVER_CURSO:
			System.out.println("Favor informe o codigo do curso a ser removido");
			codigo = sc.nextLine();
			fachada.removerCurso(codigo);
			break;
			
		case OP_MATRICULAR_ALUNO:
			System.out.println("Favor informe o nome do aluno");
			nome = sc.nextLine();
			System.out.println("Favor informe o codigo do curso:");
			codigo = sc.nextLine();
			aluno  = new Aluno(nome);
			if(codigo.equals("")){
				fachada.cadastrarEmCursoMenosAlunos(aluno);
			}
			
			curso = new Curso(codigo);
			fachada.cadastrar(aluno, curso);
			break;
		case OP_CONSULTAR_MATRICULA:
			System.out.println("Favor informe o nome do aluno:");
			nome = sc.nextLine();
			System.out.println("Favor informe o nome do curso: ");
			nomeCurso = sc.nextLine();
			matricula = fachada.procurarMatricula(nome, nomeCurso);
			if(matricula!=null){
				System.out.println("Nome do curso: " + matricula.getCurso().getNome());
				System.out.println("Nome do aluno: " + matricula.getAluno().getNome());
				System.out.println("Numero de matricula: " + matricula.getNumero());
				
			}
			break;
		case OP_REMOVER_MATRICULA:
			System.out.println("Favor informe o nome do curso da matricula ser removida");
			nomeCurso = sc.nextLine();
			System.out.println("Favor informe o nome do aluno da matricula ser removida");
			nome = sc.nextLine();
			fachada.removerMatricula(nome, nomeCurso);
			break;
			
		case OP_LISTAR_MATRICULAS:
			//Matricula[] arr_matriculas = fachada.getListaMatriculas();
	         //int n_arr_matriculas = fachada.getIndiceMatriculas();
	          for (int i = 0; i < n_arr_matriculas ; i++) {
	            matricula = arr_matriculas[i];
	            System.out.println("Nome do aluno: " + matricula.getAluno().getNome());
	            System.out.println("Curso: "  + matricula.getCurso().getNome());
	            System.out.println("Numero: "  + matricula.getNumero());
	            System.out.println();
	          }
			break;
		case OP_LISTAR_CURSOS:
			//Curso[] arr_cursos = fachada.getListaCursos();
	         //int n_arr_cursos = fachada.getIndiceCursos();
	          for (int i = 0; i < n_arr_cursos ; i++) {
	            curso = arr_cursos[i];
	            System.out.println("Codigo do Curso: " + curso.getCodigo());
	            System.out.println("Nome: "  + curso.getNome ());
	            System.out.println("Instrutor: "  + curso.getInstrutor ());
	            System.out.println();
	          }

	          break;
			
			
		case OP_LISTAR_ALUNOS:
			 //Aluno[] arr_alunos = fachada.getListaAlunos();
	         //int n_arr_alunos = fachada.getIndiceAlunos();
	          for (int i = 0; i < n_arr_alunos ; i++) {
	            aluno = arr_alunos[i];
	            System.out.println("Nome do aluno: " + aluno.getNome());
	            System.out.println("Endereço: "  + aluno.getEndereco ());
	            System.out.println("Telefone: "  + aluno.getTelefone ());
	            System.out.println("Idade: "  + aluno.getIdade ());
	            System.out.println();
	          }

	          break;
	          case OP_LISTAR_ALUNOS_CURSO:
	  			System.out.println("Digite o curso a ser procurado:");
	  			codigo = sc.nextLine();
	  			//Matricula[] arr_matricula = fachada.getListaMatriculas();
	  	        //int n_arr_matricula = fachada.getIndiceMatriculas();
	  	        for (int i = 0; i < n_arr_matriculas ; i++) {
	  	        	matricula = arr_matriculas[i];
	  	        	if (matricula.getCurso().getCodigo().equals(codigo)){
	  	        		System.out.println("Nome do aluno: " + matricula.getAluno().getNome());
	  	        		System.out.println();
	  	        	}
	  	        }
	  	        
	  	        break;
	  	        
	  		case OP_LISTAR_ALUNOS_TODOS_CURSOS:
	  			for(int i = 0; i < n_arr_cursos; i++){
	  				curso = arr_cursos[i];
	  				System.out.println("Curso: " + curso.getCodigo());
	  				for(int j = 0; j < n_arr_matriculas; j++){
	  					matricula = arr_matriculas[j];
	  					if (curso.getCodigo().equals(matricula.getCurso().getCodigo())){
	  						System.out.println("Nome do aluno: " + matricula.getAluno().getNome());
	  					}
	  				}
	  			}
	  			break;
	  	        
	  		case OP_LISTAR_TODOS_CURSOS_ALUNO:
	  			System.out.println("Digite o aluno a ser procurado:");
	  			nome = sc.nextLine();
	  			//Matricula[] arr_matricula = fachada.getListaMatriculas();
	  	        //int n_arr_matricula = fachada.getIndiceMatriculas();
	  	        for (int i = 0; i < n_arr_matriculas ; i++) {
	  	        	matricula = arr_matriculas[i];
	  	        	if (matricula.getAluno().getNome().equals(nome)){
	  	        		System.out.println("Curso: " + matricula.getCurso().getCodigo());
	  	        		}
	  	        }
	  	        
	  	        break;
	  	        
	  		case OP_LISTAR_TODOS_CURSOS_TODOS_ALUNOS:
	  			for(int i = 0; i < n_arr_alunos; i++){
	  				aluno = arr_alunos[i];
	  				System.out.println("Aluno: " + aluno.getNome());
	  				for(int j = 0; j < n_arr_matriculas; j++){
	  					matricula = arr_matriculas[j];
	  					if (aluno.getNome().equals(matricula.getAluno().getNome())){
	  						System.out.println("Nome do curso: " + matricula.getCurso().getCodigo());
	  					}
	  				}
	  			}
	  	        break;
	  	        
	  		case OP_LISTAR_TODAS_MATRICULAS_ALUNO:
	  			System.out.println("Digite o aluno a ser procurado:");
	  			nome = sc.nextLine();
	  			//Matricula[] arr_matricula = fachada.getListaMatriculas();
	  	        //int n_arr_matricula = fachada.getIndiceMatriculas();
	  	        for (int i = 0; i < n_arr_matriculas ; i++) {
	  	        	matricula = arr_matriculas[i];
	  	        	if (matricula.getAluno().getNome().equals(nome)){
	  	        		System.out.println("Curso: " + matricula.getCurso().getCodigo());
	  	        		System.out.println("Numero: " + matricula.getNumero());
	  	        	}
	  	        }
	  			break;
	  			
	  		case OP_LISTAR_TODAS_MATRICULAS_CURSO:
	  			System.out.println("Digite o curso a ser procurado:");
	  			codigo = sc.nextLine();
	  			//Matricula[] arr_matricula = fachada.getListaMatriculas();
	  	        //int n_arr_matricula = fachada.getIndiceMatriculas();
	  	        for (int i = 0; i < n_arr_matriculas ; i++) {
	  	        	matricula = arr_matriculas[i];
	  	        	if (matricula.getCurso().getCodigo().equals(codigo)){
	  	        		System.out.println("Aluno: " + matricula.getAluno().getNome());
	  	        		System.out.println("Numero: " + matricula.getNumero());
	  	        	}
	  	        }
	  			break;
	  		
	  		case OP_LISTAR_ALUNOS_SEM_CURSO:
	  			for(int i = 0; i < n_arr_alunos; i++){
	  				aluno = arr_alunos[i];
	  				achou = 0;
	  				for(int j = 0; j < n_arr_matriculas; j++){
	  					matricula = arr_matriculas[j];
	  					if (aluno.getNome().equals(matricula.getAluno().getNome()))
	  						achou = 1;
	  				}
	  				if (achou == 0){
	  					System.out.println("Aluno: " + aluno.getNome());
	  				}
	  			}
	  			break;
	  			
	  		case OP_LISTAR_CURSOS_SEM_ALUNO:
	  			for(int i = 0; i < n_arr_cursos; i++){
	  				curso = arr_cursos[i];
	  				achou = 0;
	  				for(int j = 0; j < n_arr_matriculas; j++){
	  					matricula = arr_matriculas[j];
	  					if (curso.getCodigo().equals(matricula.getCurso().getCodigo()))
	  						achou = 1;
	  				}
	  				if (achou == 0){
	  					System.out.println("Curso: " + curso.getCodigo());
	  				}
	  			}
	  			break;
			
		}
	
		
	}
	
	
	
	public static int pegaOpcao(){
		int i = sc.nextInt();
		sc.nextLine();
		return i;
	}
	
	public static void init(){
		sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		fachada = Fachada.obterInstancia();
	}
		
	
	public static void imprimeTela(){
		System.out.println(" ****************************");
		System.out.println(" *** Centro de Ensino XYZ *** ");
		System.out.println();
		System.out.println();
		System.out.println(" Operacoes disponiveis: ");
		System.out.println(OP_CRIAR_ALUNO + "- Cadastrar aluno ");
		System.out.println(OP_CONSULTAR_ALUNO + "- Procurar aluno ");
		System.out.println(OP_ATUALIZAR_ALUNO + "- Atualizar aluno ");
		System.out.println(OP_REMOVER_ALUNO + "- Descadastrar aluno ");
		System.out.println();
		System.out.println(OP_CRIAR_CURSO + "- Cadastrar curso");
		System.out.println(OP_CONSULTAR_CURSO + "- Procurar curso ");
		System.out.println(OP_ATUALIZAR_CURSO + "- Atualizar curso ");
		System.out.println(OP_REMOVER_CURSO + "- Decadastrar curso");
		System.out.println();
		System.out.println(OP_MATRICULAR_ALUNO + "- Matricular aluno ");
		System.out.println(OP_CONSULTAR_MATRICULA + "- Procurar matricula");
		System.out.println(OP_REMOVER_MATRICULA + "- Cancelar matricula ");
		System.out.println();
		System.out.println( OP_LISTAR_MATRICULAS + "- Listar todas as matriculas feitas");
		System.out.println(OP_LISTAR_CURSOS + "- Listar todos os cursos cadastrados");
		System.out.println(OP_LISTAR_ALUNOS + "- Listar todos os alunos cadastrados");
		System.out.println(OP_LISTAR_ALUNOS_CURSO + "- Listar todos os alunos de um curso ");
		System.out.println(OP_LISTAR_ALUNOS_TODOS_CURSOS + "- Listar todos os alunos de todos os cursos");
		System.out.println(OP_LISTAR_TODOS_CURSOS_ALUNO + "- Listar todos os cursos de um aluno");
		System.out.println(OP_LISTAR_TODOS_CURSOS_TODOS_ALUNOS + "- Listar todos os cursos de todos os alunos");
		System.out.println(OP_LISTAR_TODAS_MATRICULAS_ALUNO + "- Listar todas as matriculas de um aluno");
		System.out.println(OP_LISTAR_TODAS_MATRICULAS_CURSO + "- Listar todas as matriculas de um curso");
		System.out.println(OP_LISTAR_ALUNOS_SEM_CURSO + "- Listar alunos cadastrados sem curso");
		System.out.println(OP_LISTAR_CURSOS_SEM_ALUNO + "- Listar cursos cadastrados sem alunos");
		System.out.println(OP_SAIR + "- Sair da aplicacao ");
		System.out.println();
		System.out.println(" Favor escolher uma opcao: ");

	}
}
