package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	private static File archivo;
	private static PrintWriter escritor;
	private static Scanner lector;

	public static void escribirEnArchivoTexto(String url, String contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al crear y escribir el archivode texto" + "\n" + e.getMessage());
		}
	}

	public static String leerArchivoTexto(String url) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lector = new Scanner(archivo);

			String contenido = "";

			while (lector.hasNext()) {
				contenido += lector.nextLine() + "\n";
			}

			lector.close();
			return contenido;

		} catch (IOException e) {
			System.out.println("Error al crear y leer el archivo de texto" + "\n" + e.getMessage());
			return null;
		}
	}

	public static boolean eliminarArchivo(String url) {
		archivo = new File(url);
		if (archivo.exists()) {
			return archivo.delete();
		} else {
			return false;
		}
	}
}
