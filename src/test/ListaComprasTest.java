import model.ListaCompras;
import observers.HistoricoObserver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaComprasTest {

    @Test
    void deveNotificarAoAdicionarItem() {
        ListaCompras lista = new ListaCompras();
        HistoricoObserver historico = new HistoricoObserver();

        lista.adicionarObserver(historico);
        lista.adicionarItem("Arroz");

        assertEquals(1, historico.getHistorico().size());
        assertEquals("item_adicionado:Arroz", historico.getHistorico().get(0));
    }

    @Test
    void deveNotificarAoRemoverItem() {
        ListaCompras lista = new ListaCompras();
        HistoricoObserver historico = new HistoricoObserver();

        lista.adicionarObserver(historico);
        lista.adicionarItem("Leite");
        lista.removerItem("Leite");

        assertEquals(2, historico.getHistorico().size());
    }

    @Test
    void deveNotificarMultiplosObservers() {
        ListaCompras lista = new ListaCompras();
        HistoricoObserver h1 = new HistoricoObserver();
        HistoricoObserver h2 = new HistoricoObserver();

        lista.adicionarObserver(h1);
        lista.adicionarObserver(h2);

        lista.adicionarItem("Pão");

        assertEquals(1, h1.getHistorico().size());
        assertEquals(1, h2.getHistorico().size());
    }

    @Test
    void naoDeveNotificarObserverRemovido() {
        ListaCompras lista = new ListaCompras();
        HistoricoObserver historico = new HistoricoObserver();

        lista.adicionarObserver(historico);
        lista.removerObserver(historico);

        lista.adicionarItem("Café");

        assertEquals(0, historico.getHistorico().size());
    }

    @Test
    void deveAdicionarItemNaLista() {
        ListaCompras lista = new ListaCompras();

        lista.adicionarItem("Arroz");

        assertTrue(lista.getItens().contains("Arroz"));
    }

    @Test
    void naoDeveRemoverItemInexistente() {
        ListaCompras lista = new ListaCompras();

        lista.removerItem("ItemInexistente");

        assertEquals(0, lista.getItens().size());
    }
}