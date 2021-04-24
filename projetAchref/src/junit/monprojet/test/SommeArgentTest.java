package junit.monprojet.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.monprojet.SommeArgent;
import junit.monprojet.UniteDistincteException;

public class SommeArgentTest {
	
	private SommeArgent m12CHF; 
	private SommeArgent m14CHF; 
	
	private static int nbPasseDansInit = 0; 
	private static int nbPasseDansAfter = 0;
	
	@Before 
	public void mesInitialisations() { 
		//fixtures:
	 m12CHF= new SommeArgent(12, "CHF"); 
	 m14CHF= new SommeArgent(14, "CHF"); 
	 
	 System.out.println(++nbPasseDansInit + "ime passage avant exécution d'une méthode de test");
	 } 
	
	@After 
	public void apresExecution() { 
		System.out.println(++nbPasseDansAfter + "ime passage apres exécution d'une méthode de test");
	}

	@Test
	public void test() throws UniteDistincteException {
		SommeArgent expected = new SommeArgent(26, "CHF");
		SommeArgent result = m12CHF.add(m14CHF); 
		
		Assert.assertTrue(expected.equals(result)); 
	}
	
	@Test
	public void testEquals() {
		SommeArgent m14USD= new SommeArgent(14, "USD");
		
		Assert.assertTrue(!m12CHF.equals(null));
		Assert.assertEquals(m12CHF, m12CHF);
		Assert.assertEquals(m12CHF, new SommeArgent(12, "CHF"));
		//Quantity test
		Assert.assertTrue(!m12CHF.equals(m14CHF));
		//Unit test
		Assert.assertTrue(!m14USD.equals(m14CHF));
	}
	
	@Test(expected = UniteDistincteException.class) 
	public void exceptionAdd() throws UniteDistincteException { 
		SommeArgent autreSomme = new SommeArgent(12, "USD"); 
		m12CHF.add(autreSomme); 
	 }

}
