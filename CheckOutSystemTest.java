package test.com.checkout.shop.preinterview.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.checkout.shop.preinterview.java.CheckOutSystem;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckOutSystemTest {
	private double cost;
	private List<String> itemsScanned;

	@Test(expected = IllegalArgumentException.class)
	public void test01CheckOutSystemWithProductsOtherThanAppleAndOranges() {
		CheckOutSystem coSystem = new CheckOutSystem();
		itemsScanned = new ArrayList<String>();
		appItems(itemsScanned,3,"apple");
		appItems(itemsScanned,2,"orange");
		itemsScanned.add("grapes");
		cost =coSystem.performCheckout(itemsScanned);
		
	}

	private void appItems(List<String> itemsScanned2, int i,String item) {
		for(int number=0;number<i;number++)
		{
			itemsScanned2.add(item);
		}
	}

	@Test
	public void test02CheckOutSystemWithApplesAndOrangesScanned() {
		CheckOutSystem coSystem = new CheckOutSystem();
		itemsScanned = new ArrayList<String>();
		appItems(itemsScanned,2,"apple");
		appItems(itemsScanned,1,"orange");
		appItems(itemsScanned,1,"apple");
		cost =coSystem.performCheckout(itemsScanned);
		assertEquals(1.45, cost,1);
		System.out.println("cost value: "+cost);
	}
	@Test
	public void test03CheckOutSystemWithOnlyApplesScanned() {
		CheckOutSystem coSystem = new CheckOutSystem();
		itemsScanned = new ArrayList<String>();
		appItems(itemsScanned,10,"apple");
		cost =coSystem.performCheckout(itemsScanned);
		assertEquals(3.0, cost,1);
		System.out.println("cost value of apples only: "+cost);
	}
	@Test
	public void test04CheckOutSystemWithOnlyOrangesScanned() {
		CheckOutSystem coSystem = new CheckOutSystem();
		itemsScanned = new ArrayList<String>();
		appItems(itemsScanned,10,"orange");
		cost =coSystem.performCheckout(itemsScanned);
		assertEquals(1.75, cost,1);
		System.out.println("cost value of oranges only: "+cost);
	}
	
	@Test
	public void test05CheckOutSystemWithOnlyNoProdcuts() {
		CheckOutSystem coSystem = new CheckOutSystem();
		itemsScanned = new ArrayList<String>();
		cost =coSystem.performCheckout(itemsScanned);
		assertEquals(0, cost,1);
		System.out.println("cost value of no products: "+cost);
	}

	@Test
	public void test06CheckOutSystemWithoffers() {
		CheckOutSystem coSystem = new CheckOutSystem();
		itemsScanned = new ArrayList<String>();
		appItems(itemsScanned,1,"orange");
		appItems(itemsScanned,1,"apple");
		cost =coSystem.performCheckout(itemsScanned);
		assertEquals(0.85, cost,1);
		System.out.println("cost value of  products after offer: "+cost);
	}
	
}
