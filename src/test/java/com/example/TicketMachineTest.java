package com.example;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.example.core.TicketMachine;
import com.example.exception.PapelMoedaInvalidaException;
import com.example.exception.SaldoInsuficienteException;

/**
 * Unit test for simple App.
 */
public class TicketMachineTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    // TESTES IMPRIMIR
    @Test
    public void ImprimirTicketComSaldoSuficiente() throws PapelMoedaInvalidaException , SaldoInsuficienteException{
    TicketMachine T = new TicketMachine(3);
    T.inserir(5); 

    T.imprimir();

    Assert.assertEquals(2, T.getSaldo());
    }


    @Test
    public void ImprimirTicketComSaldoInsuficiente() throws PapelMoedaInvalidaException{
    TicketMachine T = new TicketMachine(10);
    T.inserir(5); 

    try {
        T.imprimir();
        Assert.fail();
    } catch (Exception e) {
    
    }
    }


    @Test
    public void ImprimirTicketComSaldoZerado() throws PapelMoedaInvalidaException{
    TicketMachine T = new TicketMachine(10);
    try {
        T.imprimir();
        Assert.fail();
    } catch (Exception e) {
    
    }
    }


    // TESTES INSERIR
    @Test
    public void InserirPapelMoedaValido(){
    TicketMachine T = new TicketMachine(3);
    try {
        T.inserir(10);

    } catch (Exception e) {
        Assert.fail();
    }
    Assert.assertEquals(10, T.getSaldo());
    }


    @Test
    public void InserirPapelMoedaInvalido(){
    TicketMachine T = new TicketMachine(3);
    try {
        T.inserir(3);
        Assert.fail();

    } catch (Exception e) {
        
    }
    }


}
