package ar.edu.unlam.pb2.regalosNavidenios;

public class Interesado implements Criterio {

	private Integer valorMinimo;

	public Interesado(Integer valorMinimo) {
	this.valorMinimo=valorMinimo;
	}

	@Override
	public Boolean leGusta(Regalo regalo) {
	
		return regalo.getValor() > valorMinimo;
	}

	public Integer getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Integer valorMinimo) {
		this.valorMinimo =valorMinimo;
	}
	

}
