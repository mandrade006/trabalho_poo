

public class RepositorioMatriculasArray {

	private Matricula[] matriculas;
	private int indice;
	private final static int tamanhoCache = 100;

	public RepositorioMatriculasArray(){
		indice = 0;
		matriculas = new Matricula[tamanhoCache];

	}

	public Matricula[] getMatriculas() {
		return matriculas;
	}

	public int getIndice() {
		return indice;
	}

	public void inserir(Matricula matricula){
		matriculas[indice] = matricula;
		indice = indice +1;
	}
	
	private int procurarIndice(int numero){
		int i = 0;
		boolean achou = false;
		int ind = -1;
				
				
		while(i<indice && !achou){
			if(matriculas[i].getNumero() == numero){
				ind= i;
				achou = true;
			}
			i++;
		}
		return ind;
	}
	
	public int procurarIndice(String nome, String codigo){
		int i = 0;
		boolean achou = false;
		int ind = -1;
		
		while(i<indice && !achou){
			if(matriculas[i].getAluno().getNome().equals(nome) && matriculas[i].getCurso().getCodigo().equals(codigo) ){
				ind= i;
				achou = true;
			}
			i++;
		}
		return ind;
	}
	
	public int procurarIndicePorNomeCurso(String nome, String nomeCurso){
		int i = 0;
		boolean achou = false;
		int ind = -1;
		
		while(i<indice && !achou){
			if(matriculas[i].getAluno().getNome().equals(nome) && matriculas[i].getCurso().getNome().equals(nomeCurso) ){
				ind= i;
				achou = true;
			}
			i++;
		}
		return ind;
	}
	
	
	public Matricula procurar(int numero){
		int i = 0;
		Matricula matricula = null;
		
		if(existe(numero)){
			i = procurarIndice(numero);
			matricula = matriculas[i];
		}else {
			InterfaceTextual.reportar_erro("Matricula nao encontrado");
		}
		return matricula;
	}
	
	public Matricula procurar(String nome, String codigo){
		int i = 0;
		Matricula matricula = null;
		
		if(existe(nome, codigo)){
			i = procurarIndice(nome, codigo);
			matricula = matriculas[i];
		}else {
			InterfaceTextual.reportar_erro("Matricula nao encontrado");
		}
		return matricula;
		
		
	}
	
	public Matricula procurarPorNomeCurso(String nome, String nomeCurso){
		int i = 0;
		Matricula matricula = null;
		
		if(existeNomeCurso(nome, nomeCurso)){
			i = procurarIndicePorNomeCurso(nome, nomeCurso);
			matricula = matriculas[i];
		}else {
			InterfaceTextual.reportar_erro("Matricula nao encontrada");
		}
		return matricula;
		
		
	}
	
	public boolean existeNomeCurso(String nome, String nomeCurso){
		boolean resp = false;
		int i = this.procurarIndicePorNomeCurso(nome, nomeCurso);
		if(i != -1){
			resp = true;
		}
		return resp;
	}
	
	public boolean existe(String nome, String codigo){
		boolean resp = false;
		int i = this.procurarIndice(nome, codigo);
		if(i != -1){
			resp = true;
		}
		return resp;
	}

	public boolean existe(int numero){
		boolean resp = false;
		int i = this.procurarIndice(numero);
		if(i != -1){
			resp = true;
		}
		return resp;
	}

	public void atualizar(Matricula matricula){
		int i = procurarIndice(matricula.getNumero());
		
		if(i != -1){
			matriculas[i] = matricula;
		}else{
			InterfaceTextual.reportar_erro("Matricula nao encontrado!");
		}
	}
	
	public void remover(int numero){
		int i = procurarIndice(numero);
		
		if(i != -1){
			matriculas[i] = matriculas[indice-1];
			matriculas[indice-1] =null;
			indice = indice -1;
		}else {
			InterfaceTextual.reportar_erro("Matricula nao encontrado");
		}
	}
	
	public void remover(String nome, String nomeCurso){
		int i = procurarIndicePorNomeCurso(nome, nomeCurso);
		
		if(i != -1){
			matriculas[i] = matriculas[indice-1];
			matriculas[indice-1] =null;
			indice = indice -1;
		}else {
			InterfaceTextual.reportar_erro("Matricula nao encontrada");
		}
	}
	
}
