package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor >= 100) {
            count++;
            valor -= 100;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor >= 50) {
            count++;
            valor -= 50;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor >= 20) {
            count++;
            valor -= 20;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor >= 10) {
            count++;
            valor -= 10;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor >= 5) {
            count++;
            valor -= 5;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor >= 2) {
            count++;
            valor -= 2;
        }
        papeisMoeda[0] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;
        private int currentIndex = 5; // Índice inicial (100 reais)

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            while (currentIndex >= 0) {
                if (troco.papeisMoeda[currentIndex] != null && troco.papeisMoeda[currentIndex].getQuantidade() > 0) {
                    return true;
                }
                currentIndex--;
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            if (!hasNext()) {
                throw new IllegalStateException("Não há mais elementos.");
            }
            PapelMoeda ret = troco.papeisMoeda[currentIndex];
            // Atualiza a quantidade de papel moeda após entregar
            troco.papeisMoeda[currentIndex].setQuantidade(ret.getQuantidade() - 1);
            if (troco.papeisMoeda[currentIndex].getQuantidade() == 0) {
                troco.papeisMoeda[currentIndex] = null; // Remove a denominação se a quantidade chegar a zero
            }
            return ret;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operação de remoção não suportada.");
        }
    }
}
