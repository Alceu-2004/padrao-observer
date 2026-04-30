package observers;

import observer.Observer;

public class NotificacaoObserver implements Observer {

    @Override
    public void atualizar(String evento, String dado) {
        if (evento.equals("item_adicionado")) {
            System.out.println("[NOTIFICAÇÃO] Item '" + dado + "' foi adicionado!");
        }
    }
}