package br.unip.springboottest.model;

public class Calculadora {
	public double calculaMedia(double... notas) {
		double m = 0;
		for (Double d : notas) {
			m += d;
		}
		return m / notas.length;
	}
}
