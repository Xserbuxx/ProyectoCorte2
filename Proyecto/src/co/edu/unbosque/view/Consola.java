package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
	private Scanner sc;

	public Consola() {
		sc = new Scanner(System.in);
	}

	public int leerInt() {
		return sc.nextInt();
	}

	public long leerLong() {
		return sc.nextLong();
	}

	public double leerDouble() {
		return sc.nextDouble();
	}

	public String leerLineaCompleta() {
		return sc.nextLine();
	}

	public String leerPalabra() {
		return sc.next();
	}

	public char leerChar() {
		return sc.next().charAt(0);
	}

	public float leerFloat() {
		return sc.nextFloat();
	}

	//
	public void escribirConSalto(String texto) {
		System.out.println(texto);
	}

	public void escribirSinSalto(String texto) {
		System.out.print(texto);
	}

	//
	public void quemarLinea() {
		sc.nextLine();
	}

	public boolean leerBooleano() {
		
		String entrada = leerLineaCompleta();

		if (entrada.toLowerCase().contains("si")) {
			return true;
		} else {
			return false;
		}
		
	}
}
