package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

public Iterator<Integer> getTroco() {
    int troco = saldo;
    List<Integer> trocoList = new ArrayList<>();

    for (int i = papelMoeda.length - 1; i >= 0; i--) {
        while (troco >= papelMoeda[i]) {
            trocoList.add(papelMoeda[i]);// notes: seria bom fazer a verificação se o papelMoeda está em "estoque" na máquina
            troco -= papelMoeda[i];
        }
    }

    saldo = 0;// nas especificações estava pedindo para zerar o saldo

    return trocoList.iterator();
}

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        return String.format("*****************\n*** R$ %d,00 ****\n*****************\n", valor);
    }
}
