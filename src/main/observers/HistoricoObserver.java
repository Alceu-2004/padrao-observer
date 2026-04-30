package observers;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class HistoricoObserver implements Observer {

    private List<String> historico = new ArrayList<>();

    @Override
    public void atualizar(String evento, String dado) {
        historico.add(evento + ":" + dado);
    }

    public List<String> getHistorico() {
        return historico;
    }
}