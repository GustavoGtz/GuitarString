package com.robles.tareaguitarra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Santiago Robles Victor Rios Gustavo Gutierrez
 */
public class GuitarString {

	Queue<Double> circularBuffer = new LinkedList<>();

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
	}

	public void pluck() {
		double randomValue;

		for (int i = 0; i < circularBuffer.size(); i++) {
			randomValue = Math.random() * (0.49999 + 0.5) - 0.5; //TODO: MEJORAR FORMULA
			circularBuffer.remove();
			circularBuffer.add(randomValue);
		}

	}

}
