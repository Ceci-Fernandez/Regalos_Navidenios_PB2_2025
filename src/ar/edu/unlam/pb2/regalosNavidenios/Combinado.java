package ar.edu.unlam.pb2.regalosNavidenios;

import java.util.List;

public class Combinado implements Criterio {

private List<Criterio> criterios;

public Combinado(List<Criterio> criterios) {
	this.criterios = criterios;
	    }

 @Override
 public Boolean leGusta(Regalo regalo) {
  for (Criterio criterio : criterios) {
     if (!criterio.leGusta(regalo)) {
             return false;
         }
	        }
	        return true;
	    }

}
