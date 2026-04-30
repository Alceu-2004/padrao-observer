import model.ListaCompras;
import observers.HistoricoObserver;
import observers.NotificacaoObserver;
import observers.SugestaoObserver;

public class Main {

    public static void main(String[] args) {

        ListaCompras lista = new ListaCompras();

        NotificacaoObserver notificacao = new NotificacaoObserver();
        SugestaoObserver sugestao = new SugestaoObserver();
        HistoricoObserver historico = new HistoricoObserver();

        lista.adicionarObserver(notificacao);
        lista.adicionarObserver(sugestao);
        lista.adicionarObserver(historico);

        lista.adicionarItem("Arroz");
        lista.adicionarItem("Leite");
        lista.removerItem("Leite");
    }
}