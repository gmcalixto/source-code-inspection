package com.mycompany.app;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PapelMoeda {

    private int valor;
    private int quantidade;

    public PapelMoeda(int valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
