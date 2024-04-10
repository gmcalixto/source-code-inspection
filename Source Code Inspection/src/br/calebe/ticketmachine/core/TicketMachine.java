package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

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
            if (papelMoeda[i] == quantia) { /* verificacao de papel moeda */
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

    public Map<Integer, Integer> getTroco() {/**Implementacao getTroco */
        Map<Integer, Integer> trocoMap = new HashMap<>();
        int troco = saldo - valor;
        for (int i = papelMoeda.length - 1; i >= 0; i--) {
            if (troco >= papelMoeda[i]) {
                int quantidade = troco / papelMoeda[i];
                trocoMap.put(papelMoeda[i], quantidade);
                troco -= quantidade * papelMoeda[i];
            }
        }
        return trocoMap;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        saldo -= valor; /* Atualiza saldo, antes de imprimir */
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
