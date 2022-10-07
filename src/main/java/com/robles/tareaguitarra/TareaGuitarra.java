package com.robles.tareaguitarra;

/**
 *
 * @author santiagorobles
 *         Victor Rios
 *         Gustavo Gutierrez
 */
public class TareaGuitarra {

    public static void main(String[] args) {
        GuitarString test = new GuitarString(10000);
	test.pluck();
	    System.out.println("sample: " + test.sample());
    }
}
