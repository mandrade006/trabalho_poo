
public class Fachada {

	private static Fachada instancia;
	private CadastroAlunos alunos;
	private CadastroCursos cursos;
	private CadastroMatriculas matriculas;
	
	public static Fachada obterInstancia(){
		if(instancia ==null){
			instancia = new Fachada();
		}
		return instancia;
	}
	
	private Fachada(){
		initCadastros();
	}
	
	private void initCadastros(){
		RepositorioAlunosArray repoAlunos = new RepositorioAlunosArray();
		alunos = new CadastroAlunos(repoAlunos);
		RepositorioCursosArray repoCursos = new RepositorioCursosArray();
		cursos = new CadastroCursos(repoCursos);
		RepositorioMatriculasArray repoMatriculas = new RepositorioMatriculasArray();
		matriculas  = new CadastroMatriculas(repoMatriculas);
	}
	
	
	public void cadastrar(Aluno aluno){
		alunos.cadastrar(aluno);
	}
	
	public void cadastrar(Curso curso){
		cursos.cadastrar(curso);
	}
	
	public void cadastrar(Aluno aluno, Curso curso){
		Matricula matricula;
		Aluno alunoExistente;
		Curso cursoExistente;
		if(aluno != null && curso!= null){
			alunoExistente = alunos.procurar(aluno.getNome());
			cursoExistente  = cursos.procurar(curso.getCodigo());
			if(alunoExistente != null && cursoExistente != null){
				matricula = Matricula.inicializarMatricula(alunoExistente, cursoExistente);
				matriculas.cadastrar(matricula);
			}
		}
	}
	
	public Aluno procurarAluno(String nome){
		return alunos.procurar(nome);
	}
	
	public Curso procurarCurso(String codigo){
		return cursos.procurar(codigo);
	}
	public Matricula procurarMatricula(String nome, String nomeCurso){
		return matriculas.procurar(nome, nomeCurso);
	}
	public void atualizar(Aluno aluno){
		alunos.atualizar(aluno);
	}
	public void atualizar(Curso curso){
		cursos.atualizar(curso);
	}
	
	public void removerAluno(String nome){
		Matricula matricula = null;
		ListaMatriculas lm = listaMatriculasAlunos(nome);
		while(lm.hasNext()){
			matricula = lm.next();
			matriculas.descadastrar(matricula.getAluno().getNome(), matricula.getCurso().getNome());
		}
		alunos.descadastrar(nome);
	}
	public void removerCurso(String codigo){
		Matricula matricula = null;
		ListaMatriculas lm = listaMatriculasCursos(codigo);
		while(lm.hasNext()){
			matricula = lm.next();
			matriculas.descadastrar(matricula.getAluno().getNome(), matricula.getCurso().getNome());
		}
		cursos.descadastrar(codigo);
	}
	
	public void cadastrarEmCursoMenosAlunos(Aluno aluno){
		Curso curso;
		
		
		
		curso= listaTodasMatriculas();
		System.out.println(curso.getCodigo());
//		while(lm.hasNext()){
//			
//			curso[i] = lm.next().getCurso();
//			
//		}
	}
	
	public void removerMatricula(String nome, String nomeCurso){
		matriculas.descadastrar(nome, nomeCurso);
	}
	

	public Aluno[] getListaAlunos(){
		return alunos.getListaAlunos();
	}
	public int getIndiceAlunos(){
		return alunos.getIndice();
	}
	
	public ListaMatriculas listaMatriculasAlunos(String nome){
		ListaMatriculas lm = null;
		Aluno aluno = alunos.procurar(nome);
		if(aluno != null){
			lm = matriculas.listaMatriculasAluno(nome);
		}
		return lm;
	}

	public ListaMatriculas listaMatriculasCursos(String codigo){
		ListaMatriculas lm = null;
		Curso curso= cursos.procurar(codigo);
		if(curso != null){
			lm = matriculas.listaMatriculasCursos(codigo);
		}
		
		return lm;
	}
	
	public Curso listaTodasMatriculas(){
		Curso curso;
		curso= matriculas.pegarTodasMatriculas();
		return curso;
	}
	
	
	
	

	public Curso[] getListaCursos(){
		return cursos.getListaCursos();
	}
	public int getIndiceCursos(){
		return cursos.getIndice();
	}
	
	public Matricula[] getListaMatriculas(){
		return matriculas.getListaMatriculas();
	}
	public int getIndiceMatriculas(){
		return matriculas.getIndice();
	}
	
}
