

public class Boletim {
	
	

		private String nome;
		private double am;
		private double nac;
		private double ps;
		
		
		
		
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getAm() {
			return am;
		}
		public void setAm(double am) {
			this.am = am;
		}
		public double getNac() {
			return nac;
		}
		public void setNac(double nac) {
			this.nac = nac;
		}
		public double getPs() {
			return ps;
		}
		public void setPs(double ps) {
			this.ps = ps;
		}
		
		

		public double getMedia() {
			return nac * 02+ am * 0.3 + ps * 0.5;
		}

		
		public String getSituacao() {
			if( getMedia() < 4.0 ) {
				return "que peninha :("; 
			}else {
				if( getMedia() < 6.0 ) {
					return "jogue outra vez";
				}else {
					return "Triteza";
				}
			}
		}
		
		

}
