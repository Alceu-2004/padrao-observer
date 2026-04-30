package observers;

import observer.Observer;

public class SugestaoObserver implements Observer {

    @Override
    public void atualizar(String evento, String dado) {
        if (evento.equals("item_adicionado") && dado.equalsIgnoreCase("arroz")) {
            System.out.println("[SUGESTÃO] Que tal adicionar feijão também?");
        }
    }
}