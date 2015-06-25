
public class CadastroMatriculas {

	private RepositorioMatriculasArray matriculas;
	
	public CadastroMatriculas(RepositorioMatriculasArray r){
		this.matriculas = r;
	}
	
	public void cadastrar(Matricula matricula){
		if(!matriculas.existe(matricula.getAluno().getNome(), matricula.getCurso().getCodigo())){
			matriculas.inserir(matricula);
			
		}else {
			InterfaceTextual.reportar_erro("Matricula ja realizada");
		}
		
	}
	public Matricula[] getListaMatriculas(){
		return matriculas.getMatriculas();
	}
	public int getIndice(){
		return matriculas.getIndice();
	}
	public Matricula procurar(String nome, String nomeCurso){
		return matriculas.procurarPorNomeCurso(nome, nomeCurso);
	}
	

	public void descadastrar(String nome, String nomeCurso){
		matriculas.remover(nome, nomeCurso);
	}
	
	public ListaMatriculas listaMatriculasAluno(String nome){
		Matricula[] matriculas = null;
		Matricula matricula = null;
		Aluno aluno = null;
		
		
		matriculas = this.matriculas.getMatriculas();
		int numeroMatriculas = this.matriculas.getIndice();
		
		ListaMatriculas lm = new ListaMatriculas();
		for(int i =0;i<numeroMatriculas;i++){
			matricula = matriculas[i];
			aluno = matricula.getAluno();
			if(aluno.getNome().equals(nome)){
				lm.insert(matricula);
			}
		}
		return lm;
	}
	
	public ListaMatriculas listaMatriculasCursos(String codigo){
		Matricula[] matriculas = null;
		Matricula matricula = null;
		Curso curso = null;
		
		matriculas = this.matriculas.getMatriculas();
		int numeroMatriculas = this.matriculas.getIndice();
		
		ListaMatriculas lm = new ListaMatriculas();
		for(int i =0;i<numeroMatriculas;i++){
			matricula = matriculas[i];
			curso = matricula.getCurso();
			if(curso.getCodigo().equals(codigo)){
				lm.insert(matricula);
			}
		}
		return lm;
	}
	
	public Curso pegarTodasMatriculas(){
		Matricula[] matriculas = null;
		Curso[] cursos = new Curso[100];
		Curso curso = new Curso();
		
		matriculas = this.matriculas.getMatriculas();
		int numeroMatriculas = this.matriculas.getIndice();
		
		int ind =0;
		int aux=0;
		boolean achou = false;
		
		for(int i=0; i<numeroMatriculas; i++){
			for(int k = 0; k<ind;k++){
				if(cursos[k] == matriculas[i].getCurso()){
					//cursos[i] = matriculas[i].getCurso();
					achou= true;
				}
				
			}
			if(achou == false){
			cursos[ind] = matriculas[i].getCurso();
			for(int j=0;j<numeroMatriculas;j++){
				if(matriculas[j].getCurso().getCodigo().equals(cursos[ind].getCodigo())){
					aux = cursos[ind].getNumeroAlunos();
					cursos[ind].setNumeroAlunos(aux+1);
				}

			}
			ind++;
		}
			
			achou = false;
		}
		// funcao pra pegar o curso  menor numero de alunos
		for(int i=0; i<=ind;i++){
			if(curso.getNumeroAlunos() > cursos[i].getNumeroAlunos()){
				curso  = cursos[i];
			}
		}
		// retorna o curso com o menor numero de alunos
		return curso;
	}
}
