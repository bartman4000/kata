package com.infoshare;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bartman3000 on 10.06.17.
 */
public class AnagramTest {

    private static Anagram anagram;

    @Before
    public void setUp() throws Exception {
        anagram = new Anagram();
    }
    //check('kat',	'akt')
    @Test
    public void checkTrue() throws Exception {
        assertTrue(anagram.check("kat","akt"));
    }

    //check('dom',	'moce')
    @Test
    public void checkFalse() throws Exception {
        assertFalse(anagram.check("dom","moce"));
    }

    @Test
    public void checkTabletrue() throws Exception {
        //given
        String[] check= {"tak","kat","dom"};
        assertTrue(anagram.check(check));
    }
}