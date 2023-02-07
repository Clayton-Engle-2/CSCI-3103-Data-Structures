/**
 * This is the Junit Test file for MyArrayList class
 */


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Zheng Li
 *
 */
public class TestMyArrayList {

		private MyArrayList<String>  list;
		
		@Before
		public void setUp(){
			list = new MyArrayList<String>();
		}
		
		@Test
		public void testListInit(){
			assertTrue(list.isEmpty());
			assertTrue(list.size() == 0);
		}
				
		@Test
		public void testAddElements(){
			list.add(0, "Karol");
			list.add(1, "Vanessa");
			list.add(2, "Amanda");
			
			assertEquals("Karol", list.get(0));
			assertEquals("Vanessa", list.get(1));
			assertEquals("Amanda", list.get(2));
			
			list.add(1, "Mariana");
			
			assertEquals("Karol", list.get(0));
			assertEquals("Mariana", list.get(1));
			assertEquals("Vanessa", list.get(2));
			assertEquals("Amanda", list.get(3));	
			
			assertTrue(list.size()==4);
		}
		
		//@Test (expected = NullPointerException.class)
		public void testAddElementNull(){
			list.add(0, null);
		}
		
		//@Test (expected = NullPointerException.class)
		public void testSetElementNull(){
			list.add(0, "Kheyla");
			list.set(0, null);
		}
		
		@Test
		public void testSetElement(){
			list.add(0, "Karol");
			list.add(1, "Vanessa");
			list.add(2, "Amanda");
			
			list.set(1, "Livia");
			
			assertEquals("Karol", list.get(0));
			assertEquals("Livia", list.get(1));
			assertEquals("Amanda", list.get(2));
		}
		
		@Test
		public void testRemoveElement1(){
			list.add(0, "Karol");
			list.add(1, "Vanessa");
			list.add(2, "Amanda");
			
			assertEquals("Amanda", list.remove(2));
			assertTrue(list.size() == 2);
		}
		
		@Test
		public void testRemoveElement2(){
			list.add(0, "Karol");
			list.add(1, "Vanessa");
			list.add(2, "Amanda");
			
			list.remove(0);
			assertEquals("Vanessa", list.get(0));
			assertEquals("Vanessa", list.get(0));
			assertEquals("Amanda", list.get(1));
		}
				
		//@Test (expected = IndexOutOfBoundsException.class)
		public void testRemoveWithEmptyList(){
			list.remove(0);
		}
				
		@Test
		public void testIndexof1(){
			list.add(0, "Karol");
			list.add(1, "Vanessa");
			list.add(2, "Amanda");
			
			assertEquals(2, list.indexOf("Amanda"));
			assertEquals(0, list.indexOf("Karol"));
			assertEquals(-1, list.indexOf("jack"));
		}
		
		@Test
		public void testIndexof2(){
			list.add(0, "Karol");
			list.add(1, "Vanessa");
			list.add(2, "Amanda");
			list.add(3, "Karol");
			
			assertEquals(0, list.indexOf("Karol"));			
		}
		
		
		@Test
		public void testcountApperance(){
			list.add(0, "Karol");
			list.add(1, "Vanessa");
			list.add(2, "Karol");
			list.add(3, "Karol");
			
			assertEquals(3, list.countApperance("Karol"));			
		}
		
		

		@Test
		public void testremoveDuplicate(){
			list.add(0, "Karol");
			list.add(1, "Karol");
			list.add(2, "Amanda");
			list.add(3, "Karol");
			
			list.removeDuplicate("Karol");	
			assertEquals(1, list.countApperance("Karol"));	
		}
		
		
	
}
