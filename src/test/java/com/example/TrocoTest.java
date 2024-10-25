package com.example;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import com.example.core.PapelMoeda;
import com.example.core.TicketMachine;
import com.example.exception.PapelMoedaInvalidaException;
import com.example.exception.SaldoInsuficienteException;

/**
 * Unit test for simple App.
 */
public class TrocoTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }



    @Test
    public void RequisitarTrocoSemImprimirUmBilhete() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        TicketMachine T = new TicketMachine(3);
        T.inserir(5);
            
        Iterator<PapelMoeda> troco = T.getTroco();
        int last = 0;
        for(int i = 0;i <= 1;i++){
            last = troco.next().getValor();
        }
        Assert.assertEquals(5, last);
    }


    @Test
    public void RequisitarTrocoComSaldoZeradoAposImpressãoDoBilhete() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        TicketMachine T = new TicketMachine(5);
        T.inserir(5);
        T.imprimir();
        Iterator<PapelMoeda> troco = T.getTroco();
        int cont = 0;
        for(int i = 0;i < 6;i++){
            cont = troco.next().getQuantidade();
            if(cont != 0) {
                Assert.assertTrue(false);
            }
        }
        Assert.assertTrue(true);
    }


    @Test
    public void RequisitarTrocoComSaldoNaoZeradoAposImpressãoDoBilhete() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        TicketMachine T = new TicketMachine(3);
        T.inserir(5);
        T.imprimir();
        Iterator<PapelMoeda> troco = T.getTroco();
        int cont = 0;
        boolean ret = false;
        for(int i = 0;i < 6;i++){
            cont = troco.next().getQuantidade();
            if(cont != 0) {
                ret = true;
            }
        }
        Assert.assertTrue(ret);
    }

}
