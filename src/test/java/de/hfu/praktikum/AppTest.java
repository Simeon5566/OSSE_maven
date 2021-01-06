package de.hfu.praktikum;
import Queue.Util;

import static org.junit.Assert.*;
import org.junit.Test;



public class AppTest 
{
    
    @Test
    public void testIstErstesHalbjahr()
    {
      assertEquals(true, Util.istErstesHalbjahr(7));
      assertEquals(true, Util.istErstesHalbjahr(1));
      
     try {
    	 Util.istErstesHalbjahr(-1);
     } catch( IllegalArgumentException e) {
     }
     try {
    	 Util.istErstesHalbjahr(13);
     } catch( IllegalArgumentException e) {
     }
    }
    @Test
    public void testQeue() {
    	
    }
}
