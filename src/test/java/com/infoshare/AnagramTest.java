package com.infoshare;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void checkGetAnagrams() throws Exception {
        //given
        String[] check= {"tak","kat","dom"};

        String[] row1 = new String[2];
        row1[0] = "kat";
        row1[1] = "kat";

        String[] row2 = new String[2];
        row2[0] = "akt";
        row2[1] = "dom";

        Map<String, String[]> mapa = new HashMap<>();
        mapa.put("akt", row1);
        mapa.put("kat", row2);

        assertFalse(anagram.check(check));
    }
}