package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.*;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) throws IOException {
		try {
			Innlegg[] tab = samling.getSamling();
			PrintWriter printWriter = new PrintWriter(MAPPE+filnavn);
			for (int i = 0; i < samling.getAntall(); i++) {
				printWriter.printf(tab[i].toString());
			}
			printWriter.close();

			return true;
		}
		catch (FileNotFoundException var7) {
			JOptionPane.showMessageDialog(null, "Filen " + filnavn + " finnes ikke. \n" + var7.getMessage());
		}
		return false;
	}
}
