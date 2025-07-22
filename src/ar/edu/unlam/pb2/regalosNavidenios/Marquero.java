package ar.edu.unlam.pb2.regalosNavidenios;

import java.util.List;

public class Marquero implements Criterio{

	 private List<String> marcas;

	    public Marquero(List<String> marcas) {
	        this.marcas = marcas;
	    }

	    @Override
	    public Boolean leGusta(Regalo regalo) {
	        return marcas.contains(regalo.getMarca());
	    }
}
