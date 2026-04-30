package model;

import subject.Subject;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ListaCompras implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private List<String> itens = new ArrayList<>();

    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(String evento, String dado) {
        for (Observer observer : observers) {
            observer.atualizar(evento, dado);
        }
    }

    public void adicionarItem(String item) {
        itens.add(item);
        notificarObservers("item_adicionado", item);
    }

    public void removerItem(String item) {
        if (itens.remove(item)) {
            notificarObservers("item_removido", item);
        }
    }

    public List<String> getItens() {
        return itens;
    }
}