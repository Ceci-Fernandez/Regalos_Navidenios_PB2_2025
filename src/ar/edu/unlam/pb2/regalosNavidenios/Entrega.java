package ar.edu.unlam.pb2.regalosNavidenios;

public class Entrega {

	private Persona persona;
	private Regalo regalo;

	public Entrega(Persona persona, Regalo regalo) {
		this.persona = persona;
		this.regalo = regalo;
	}

	public Persona getPersona() {
		return persona;
	}

	public Regalo getRegalo() {
		return regalo;
	}
}
