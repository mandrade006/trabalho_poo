
public class Curso {

	
	private String codigo;
	private String nome;
	private String instrutor;
	private int numeroAlunos;
	
	public Curso(String codigo, String nome, String instrutor){
		this.codigo = codigo;
		this.nome = nome;
		this.instrutor = instrutor;
		this.numeroAlunos =0;
	}

	public Curso(String codigo){
		this.codigo= codigo;
	}
	
	public Curso (){
		this.numeroAlunos = 0;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public int getNumeroAlunos() {
		return numeroAlunos;
	}

	public void setNumeroAlunos(int numeroAlunos) {
		this.numeroAlunos = numeroAlunos;
	}
	
	
}
