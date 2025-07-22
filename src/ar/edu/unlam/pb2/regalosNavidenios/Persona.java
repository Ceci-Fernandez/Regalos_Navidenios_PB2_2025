package ar.edu.unlam.pb2.regalosNavidenios;

import java.util.ArrayList;
import java.util.List;

public class Persona {

	private String dni;
	private Criterio criterio;
	private List <Regalo> regalosRecibidos;

	public Persona(String dni, Criterio criterio) {
		this.dni=dni;
		this.criterio=criterio;
		this.regalosRecibidos=new ArrayList<>();
		
	}

	public void recibirRegalo(Regalo regalo) {
	     regalosRecibidos.add(regalo);
	    }

	public String getDni() {
		return dni;
	}

	public Criterio getCriterio() {
		return criterio;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public List<Regalo> getRegalos() {
		return regalosRecibidos;
	}

	public void setRegalos(List<Regalo> regalos) {
		this.regalosRecibidos = regalos;
	}

	
}
