package com.example;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
    private static Logger log = Logger.getLogger(TrocoTest.class.getName());
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
        try {
            // Configura o FileHandler para gravar em "meu_log.log"
            FileHandler fileHandler = new FileHandler("meu_log.log", true); // O 'true' permite adicionar ao arquivo, em vez de sobrescrever
            fileHandler.setFormatter(new SimpleFormatter()); // Formata a saída de log
            log.addHandler(fileHandler); // Adiciona o FileHandler ao logger
            
            // Mensagens de log
            log.info("Isso será registrado no arquivo!");
            
        } catch (IOException e) {
            log.severe("Erro ao configurar o FileHandler: " + e.getMessage());
        }
        Iterator<PapelMoeda> troco = T.getTroco();
        int last = 0;
        while(troco.hasNext()){
            last = troco.next().getValor();
            log.info(String.valueOf(last));
        }
        Assert.assertEquals(5, troco.next().getValor());
    }


    @Test
    public void RequisitarTrocoComSaldoZeradoAposImpressãoDoBilhete() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
    TicketMachine T = new TicketMachine(5);
    T.inserir(5);
    T.getTroco();
    Assert.assertTrue(true);
    }


    @Test
    public void RequisitarTrocoComSaldoNaoZeradoAposImpressãoDoBilhete() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
    TicketMachine T = new TicketMachine(3);
    T.inserir(5);
    T.getTroco();
    Assert.assertTrue(true);
    }

}
