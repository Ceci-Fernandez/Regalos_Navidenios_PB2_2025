package ar.edu.unlam.pb2.regalosNavidenios;

import java.util.ArrayList;
import java.util.List;

public class Regalon {
	private List<Regalo> bolsa;
    private List<Entrega> entregas;

    public Regalon() {
        this.bolsa = new ArrayList<>();
        this.entregas = new ArrayList<>();
    }

    public void agregarRegalo(Regalo regalo) {
        if (regalo.getValor() > 0 && regalo.getAntiguedad() >= 0) {
            bolsa.add(regalo);
        }
        
    }

    public void visitar(Persona persona) {
        Regalo regaloAdecuado = null;

        for (Regalo regalo : bolsa) {
            if (persona.getCriterio().leGusta(regalo)) {
                regaloAdecuado = regalo;
                break;
            }
        }

        if (regaloAdecuado == null) {
            regaloAdecuado = new Regalo("voucher", "Papapp", 20000, 0);
        } else {
            bolsa.remove(regaloAdecuado);
        }

        persona.recibirRegalo(regaloAdecuado);
        entregas.add(new Entrega(persona, regaloAdecuado));
    }

    public List<Regalo> getBolsa() {
        return bolsa;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }
}
