package ar.edu.unlam.pb2.regalosNavidenios;

public class Anticuarios implements Criterio {
	
	
 @Override
 public Boolean leGusta(Regalo regalo) {
	        return regalo.getAntiguedad() >= 20;
	    }
}