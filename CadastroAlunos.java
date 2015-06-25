
public class CadastroAlunos {

	private RepositorioAlunosArray alunos;
	
	public CadastroAlunos(RepositorioAlunosArray r){
		this.alunos = r;
	}

	public void cadastrar(Aluno aluno){
	
		if(!alunos.existe(aluno.getNome())){
			alunos.inserir(aluno);
		}else {
			InterfaceTextual.reportar_erro("Aluno ja cadastrado");
		}
		
	}
	
	public Aluno procurar(String nome){
		return alunos.procurar(nome);
	}
	
	public void atualizar(Aluno aluno){
		Aluno al = alunos.procurar(aluno.getNome());
		if(al != null){
			alunos.atualizar(aluno);
			InterfaceTextual.reportar_erro("Aluno atualizado com sucesso");
		}
	}
	
	
	public void descadastrar(String nome){
		alunos.remover(nome);
	}


public Aluno[] getListaAlunos(){
		return alunos.getAlunos();
	}
	public int getIndice(){
		return alunos.getIndice();
	}
}
