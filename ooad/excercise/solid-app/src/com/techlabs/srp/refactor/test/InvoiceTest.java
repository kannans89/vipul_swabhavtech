package com.techlabs.srp.refactor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.srp.refactor.*;

public class InvoiceTest {
	
	Invoice invoice = new Invoice(1,"testItem",100,20);
	InvoicePrinter printer = new InvoiceConsolePrinter();
	
	@Test
	public void testFields(){
		int number=1;
		String name="testItem";
		double cost=100;
		double discount=20;
		
		assertTrue(invoice.getNumber()==number);
		assertTrue(invoice.getName()==name);
		assertTrue(invoice.getCost()==cost);
		assertTrue(invoice.getDiscount()==discount);
	}
	
	@Test
	public void testCalcTotalCost() {
		int expectedCost = 92;
		assertTrue(invoice.calcTotalCost()==expectedCost);
	}
	
	@Test
	public void testInvoicePrinter() {
		printer.print(invoice);
	}
}
