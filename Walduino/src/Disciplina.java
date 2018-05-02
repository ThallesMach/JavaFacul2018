
//

public class Disciplina {
	
	private String nomeDisciplina;
	private int tempoAula;
	
	
	
	public Disciplina() {
		super();
	}
	public Disciplina(String nomeDisciplina, int tempoAula) {
		super();
		this.nomeDisciplina = nomeDisciplina;
		this.tempoAula = tempoAula;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public int getTempoAula() {
		return tempoAula;
	}
	public void setTempoAula(int tempoAula) {
		this.tempoAula = tempoAula;
	}
	
	

}
