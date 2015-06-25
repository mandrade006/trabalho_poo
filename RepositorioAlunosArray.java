
public class RepositorioAlunosArray {

	private Aluno[] alunos;
	private int indice;
	private final static int tamanhoCache = 100;
	
	public RepositorioAlunosArray(){
		indice = 0;
		alunos = new Aluno[tamanhoCache];
		
	}

	public Aluno[] getAlunos() {
		return alunos;
	}

	public int getIndice() {
		return indice;
	}
	
	public void inserir(Aluno aluno){
		alunos[indice] = aluno;
		indice = indice +1;
	}
	
	private int procurarIndice(String nome){
		int i = 0;
		boolean achou = false;
		int ind = -1;
				
				
		while(i<indice && !achou){
			if(alunos[i].getNome().equals(nome)){
				ind= i;
				achou = true;
			}
			i++;
		}
		return ind;
	}
	
	public Aluno procurar(String nome){
		int i = 0;
		Aluno aluno = null;
		
		if(existe(nome)){
			i = procurarIndice(nome);
			aluno = alunos[i];
		}else {
			InterfaceTextual.reportar_erro("Aluno nao encontrado");
		}
		return aluno;
		
	}
	
	public boolean existe(String nome){
		boolean resp = false;
		int i = this.procurarIndice(nome);
		if(i != -1){
			resp = true;
		}
		return resp;
	}
	
	public void atualizar(Aluno aluno){
		int i = procurarIndice(aluno.getNome());
		
		if(i != -1){
			alunos[i] = aluno;
		}else{
			InterfaceTextual.reportar_erro("Aluno nao encontrado!");
		}
	}	
	
	public void remover(String nome){
		int i = procurarIndice(nome);
		
		if(i != -1){
			alunos[i] = alunos[indice-1];
			alunos[indice-1] =null;
			indice = indice -1;
		}else {
			InterfaceTextual.reportar_erro("Aluno nao encontrado");
		}
	}
	
	
	
}
