
public class CadastroCursos {

	private RepositorioCursosArray cursos;
	
	public CadastroCursos(RepositorioCursosArray r){
		this.cursos = r;
	}
	
	public void cadastrar(Curso curso){
		
		if(!cursos.existe(curso.getCodigo())){
			cursos.inserir(curso);
		}else{
			InterfaceTextual.reportar_erro("Curso ja cadastrado!");		
		}

	}
	public Curso[] getListaCursos(){
		return cursos.getCursos();
	}
	public int getIndice(){
		return cursos.getIndice();
	}
	
	public Curso procurar(String codigo){
		return cursos.procurar(codigo);
	}
	
	public Curso procurarPorNome(String nomeCurso){
		return cursos.procurarPorNome(nomeCurso);
	}

	public void atualizar(Curso curso){
		
		Curso c = cursos.procurar(curso.getCodigo());
		if(c != null){
			cursos.atualizar(curso);
			InterfaceTextual.reportar_erro("Curso atualizado com sucesso");
		}
	}

	public void descadastrar(String codigo){
		cursos.remover(codigo);
	}
	
	


}
