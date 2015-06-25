
public class ListaAlunos {


	private RepositorioAlunosArray alunos;
	private int indiceLista;
		
	public ListaAlunos() {
		alunos = new RepositorioAlunosArray();
		indiceLista = 0;
	}
	
	public boolean hasNext() {
		
		return  indiceLista < alunos.getIndice();
	}
	
	public Aluno next () {
		Aluno aluno = alunos.getAlunos()[indiceLista];
		indiceLista = indiceLista + 1;
		return aluno;
	}
	
	public void insert (Aluno aluno) {
		alunos.inserir(aluno);
		
	}


	
}
