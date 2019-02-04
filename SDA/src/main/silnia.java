package main;

import java.util.Scanner;

public class silnia {
	public static long liczeniesilnia(int liczba) {
		long silnia = 1;
		for (int i = 1; i <= liczba; i++) {
			silnia = silnia * i;
		}

		System.out.println("silnia wynosi: " + silnia);
		return silnia;
	}

	public static boolean sprawdzanie(long liczba) {
		for (int i = 2; i < liczba; i++) {

			if (liczba % i == 0) {
				System.out.printf("%d nie jest pierwsza\n", liczba);
				return false;
			}

		}

		System.out.printf("%d jest liczbą pierwszą\n", liczba);
		return true;
	}

	public static void main(String[] args) {
		Scanner odczyt = new Scanner(System.in);
		System.out.printf("Podaj ile: ");
		int liczba = odczyt.nextInt();
		odczyt.close();

		sprawdzanie(liczeniesilnia(liczba));
	}

}
