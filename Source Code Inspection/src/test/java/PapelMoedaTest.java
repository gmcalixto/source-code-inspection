package br.calebe.ticketmachine.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PapelMoedaTest {

    @Test
    public void testPapelMoedaCreation() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 1);
        assertEquals(10, papelMoeda.getValor(), "The value should be 10");
        assertEquals(1, papelMoeda.getQuantidade(), "The quantity should be 1");
    }

    @Test
    public void testNegativeValue() {
        PapelMoeda papelMoeda = new PapelMoeda(-5, 2);
        assertTrue(papelMoeda.getValor() < 0, "The value should be negative");
    }
}
