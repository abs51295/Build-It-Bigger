package com.example.test;

import com.example.Joker;
import org.junit.Test;

/**
 * Created by Aagam Shah on 6/29/2016.
 */


public class JokerTest {
    @Test
    public void test(){
        Joker joker = new Joker();
        assert joker.getJoke().length()!=0;
    }
}
