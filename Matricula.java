
public class Matricula {

	
	private Aluno aluno;
	private Curso curso;
	private final int numero;
	private static int numeroMatricula=-1;
	
	public static Matricula inicializarMatricula(Aluno al, Curso cur){
		if(numeroMatricula ==-1){
			numeroMatricula = 0;
			
		}else {
			numeroMatricula++;
		}
		Matricula matricula = new Matricula(al, cur, numeroMatricula);
		return matricula;
		
	}

	private Matricula(Aluno aluno, Curso curso, int nmatricula){
		this.aluno = aluno;
		this.curso = curso;
		this.numero = nmatricula;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getNumero() {
		return numero;
	}
	
	
	
}
