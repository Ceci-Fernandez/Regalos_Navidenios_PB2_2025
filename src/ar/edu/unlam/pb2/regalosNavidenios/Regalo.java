package ar.edu.unlam.pb2.regalosNavidenios;

import java.util.Objects;

public class Regalo {

	private String nombre;
	private String marca;
	private double valor;
	private int antiguedad;

	public Regalo(String nombre, String marca, double valor, int antiguedad) {
		this.nombre = nombre;
		this.marca = marca;
		this.valor = (valor < 0) ? 0 : valor;
		this.antiguedad = (antiguedad < 0) ? 0 : antiguedad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public double getValor() {
		return valor;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Regalo)) return false;
		Regalo regalo = (Regalo) o;
		return Objects.equals(nombre, regalo.nombre) &&
				Objects.equals(marca, regalo.marca);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, marca);
	}

}
