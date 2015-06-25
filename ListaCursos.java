
public class ListaCursos {


	private RepositorioCursosArray cursos;
	private int indiceLista;
		
	public ListaCursos() {
		cursos = new RepositorioCursosArray();
		indiceLista = 0;
	}
	
	public boolean hasNext() {
		
		return  indiceLista < cursos.getIndice();
	}
	
	public Curso next () {
		Curso curso = cursos.getCursos()[indiceLista];
		indiceLista = indiceLista + 1;
		return curso;
	}
	
	public void insert (Curso curso) {
		cursos.inserir(curso);
		
	}

	
}
