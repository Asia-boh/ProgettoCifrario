package cifrario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(input);
		System.out.println("inserisci un messaggio da cifrare");
		String messaggio;
		try {
			messaggio = keyboard.readLine();
			ArrayList<String> cifratura = new ArrayList<>();
			ArrayList<String> keyS = new ArrayList<>();
			ArrayList<Integer> keyI = new ArrayList<>();
			String lettera;
			String quit = "";
			while (!quit.equals("q")) {
				System.out.println("inserisci:\n" + "\"c\" se vuoi utilizzare il cifrario di cesare\n"
						+ "\"i\" se vuoi utilizzare il cifrario ad inversione\n"
						+ "\"b\" se vuoi utilizzare il cifrario a blocchi\n"
						+ "\"d\" se vuoi utilizzare il cifrario del dizionario\n"
						+ "\"o\" se vuoi utilizzare il cifrario delle occorrenze");
				try {
					lettera = keyboard.readLine();
					switch (lettera) {
					case "c":
						cifratura.add(lettera);
						System.out.println("inserisci un numero come chiave per il cifrario di cesare");
						int keyInt = Integer.parseInt(keyboard.readLine());
						messaggio = CifrarioDICesare.cifratura(messaggio, keyInt);
						keyI.add(keyInt);
						keyS.add(null);
						break;
					case "i":
						cifratura.add(lettera);
						messaggio = CifrarioadInversione.cifra(messaggio);
						keyI.add(null);
						keyS.add(null);
						break;
					case "b":
						cifratura.add(lettera);
						System.out.println("inserisci una stringa come chiave per il cifrario di cesare");
						String keyString = keyboard.readLine();
						messaggio = CifrarioBlocchi.cripta(messaggio, keyString);
						keyI.add(null);
						keyS.add(keyString);
						break;
					case "d":
						cifratura.add(lettera);
						messaggio = CifrarioDizionario.cripta(messaggio);
						keyI.add(null);
						keyS.add(null);
						break;
					case "o":
						cifratura.add(lettera);
						messaggio = CifrarioOccorrenze.cripta(messaggio);
						keyI.add(null);
						keyS.add(null);
						break;
					default:
						System.out.println("Non hai inserito correttamente una lettera tra c,i,b,d,o");
					}
					System.out.println(
							"Vuoi continuare a cifrare? Digita \"q\" se vuoi smettere, qualsiasi altro tasto altrimenti");
					quit = keyboard.readLine();
				} catch (IOException e) {
				}
			}
			System.out.println("questo è il messaggio cifrato:\n" + messaggio);

			for (int i = cifratura.size() - 1; i >= 0; i--) {
				switch (cifratura.get(i)) {
				case "c":
					messaggio = CifrarioDICesare.decifratura(messaggio, keyI.get(i));
					break;
				case "i":
					messaggio = CifrarioadInversione.decifra(messaggio);
					break;
				case "b":
					messaggio = CifrarioBlocchi.decripta(messaggio, keyS.get(i));
					break;
				case "d":
					messaggio = CifrarioDizionario.decripta(messaggio);
					break;
				case "o":
					messaggio = CifrarioOccorrenze.decripta(messaggio);
					break;
				}
			}
			System.out.println("questo è il messaggio decifrato:\n" + messaggio);
		} catch (IOException e) {
		}
	}
}
