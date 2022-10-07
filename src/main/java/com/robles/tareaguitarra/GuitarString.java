package com.robles.tareaguitarra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @autores Santiago Robles Victor Rios Gustavo Gutierrez
 */
public class GuitarString {

    Queue<Double> circularBuffer = new LinkedList<>();
    public static float energyDecay = 0.996f;

    public GuitarString(double frequency) {
        if (frequency <= 0) {
            throw new IllegalArgumentException("Frecuencia no válida");
        }
        int n = (int) Math.round(StdAudio.SAMPLE_RATE / frequency);
        if (n < 2) {
            throw new IllegalArgumentException("Error de buffer circular");
        }
        for (int i = 0; i < n; i++) {
            circularBuffer.add(0.0);
        }
    }

    public GuitarString(double[] init) {
        if (init.length < 2) {
            throw new IllegalArgumentException("Error de buffer circular");
        }
        for (double item : init) {
            circularBuffer.add(item);
        }
        System.out.println(circularBuffer);
    }

    public void pluck() {
        Random random = new Random();
        
    }
    
    public void tic(){
        double value1 = circularBuffer.peek();
        circularBuffer.remove();
        double value2 = circularBuffer.peek();
        double result = ((value1+value2)/2) * energyDecay;
        circularBuffer.add(result);
    }
}
