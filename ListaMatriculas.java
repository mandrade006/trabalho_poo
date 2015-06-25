
public class ListaMatriculas {


	private RepositorioMatriculasArray matriculas;
	private int indiceLista;
		
	public ListaMatriculas() {
		matriculas = new RepositorioMatriculasArray();
		indiceLista = 0;
	}
	
	public boolean hasNext() {
		
		return  indiceLista < matriculas.getIndice();
	}
	
	public Matricula next () {
		Matricula matricula = matriculas.getMatriculas()[indiceLista];
		indiceLista = indiceLista + 1;
		return matricula;
	}
	
	public void insert (Matricula matricula) {
		matriculas.inserir(matricula);
		
	}
	
}
