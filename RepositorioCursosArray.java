
public class RepositorioCursosArray {

	private Curso[] cursos;
	private int indice;
	private final static int tamanhoCache = 100;

	public RepositorioCursosArray(){
		indice = 0;
		cursos = new Curso[tamanhoCache];

	}

	public Curso[] getCursos(){
		return cursos;
	}

	public int getIndice(){
		return indice;
	}

	public void inserir(Curso curso){
		cursos[indice] = curso;
		indice = indice + 1;
	}

	private int procurarIndice(String codigo){
		int i = 0;
		boolean achou = false;
		int ind = -1;
				
				
		while(i<indice && !achou){
			if(cursos[i].getCodigo().equals(codigo)){
				ind= i;
				achou = true;
			}
			i++;
		}
		return ind;
	}
	
	private int procurarIndicePorNome(String nomeCurso){
		int i = 0;
		boolean achou = false;
		int ind = -1;
				
				
		while(i<indice && !achou){
			if(cursos[i].getNome().equals(nomeCurso)){
				ind= i;
				achou = true;
			}
			i++;
		}
		return ind;
	}

	public Curso procurar(String codigo){
		int i = 0;
		Curso curso = null;
		
		if(existe(codigo)){
			i = procurarIndice(codigo);
			curso = cursos[i];
		}else {
			InterfaceTextual.reportar_erro("Curso nao encontrado");
		}
		return curso;
	}
	
	public Curso procurarPorNome(String nomeCurso){
		int i = 0;
		Curso curso = null;
		
		if(existeNomeCurso(nomeCurso)){
			i = procurarIndicePorNome(nomeCurso);
			curso = cursos[i];
		}else {
			InterfaceTextual.reportar_erro("Curso nao encontrado");
		}
		return curso;
	}

	public boolean existeNomeCurso(String nomeCurso){
		boolean resp = false;
		int i = this.procurarIndicePorNome(nomeCurso);
		if(i != -1){
			resp = true;
		}
		return resp;
	}
	
	public boolean existe(String codigo){
		boolean resp = false;
		int i = this.procurarIndice(codigo);
		if(i != -1){
			resp = true;
		}
		return resp;
	}

	public void atualizar(Curso curso){
		int i = procurarIndice(curso.getCodigo());
		
		if(i != -1){
			cursos[i] = curso;
		}else{
			InterfaceTextual.reportar_erro("Curso nao encontrado!");
		}
	}	
	
	public void remover(String codigo){
		int i = procurarIndice(codigo);
		
		if(i != -1){
			cursos[i] = cursos[indice-1];
			cursos[indice-1] =null;
			indice = indice -1;
		}else {
			InterfaceTextual.reportar_erro("Curso nao encontrado");
		}
	}
	


}
