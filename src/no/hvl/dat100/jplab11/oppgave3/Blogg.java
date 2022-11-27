package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg{

	private Innlegg[] innleggtabell;
	private int	nesteLedige;

	public Blogg() {
		innleggtabell = new Innlegg[20];
	}
	
	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteLedige = 0;
	}

	public int getAntall() {
		return nesteLedige;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		int pos = -1;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				pos = i;
				break;
			}
		}
		return pos;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean svar = false;
		
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				svar = true;
				break;
			}
		}
		return svar;
	}

	public boolean ledigPlass() {
		boolean svar = false;
			if(getAntall() < innleggtabell.length) {
				svar = true;
			}
			return svar;
	}

	public boolean leggTil(Innlegg innlegg) {
		boolean svar = false;
		
		if (finnes(innlegg) == false && ledigPlass() == true) {
			innleggtabell[getAntall()] = innlegg;
			nesteLedige++;
			svar = true;
		}
		return svar;
	}
	
	public String toString() {
		String str = innleggtabell.length+"\n";
		for (int i = 0; i < innleggtabell.length; i++) {
			str += innleggtabell[i].toString(); 
		}
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] temp = new Innlegg[getAntall()*2];
		for (int i = 0; i < innleggtabell.length; i++) {
			temp[i] = innleggtabell[i];
		}
		
		innleggtabell = temp;
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean svar = false;
		if(ledigPlass() != true) {
			Innlegg[] temp = new Innlegg[getAntall()*2];
			for (int i = 0; i < innleggtabell.length; i++) {
				temp[i] = innleggtabell[i];
			}
			
			innleggtabell = temp;
		}
		if (finnes(innlegg) == false && ledigPlass() == true) {
			innleggtabell[getAntall()] = innlegg;
			nesteLedige++;
			svar = true;
		}
		return svar;
	}
	
	public boolean slett(Innlegg innlegg) {
		boolean svar = false;
		if (finnes(innlegg)) {
			innleggtabell[finnInnlegg(innlegg)] = null;
			nesteLedige--;
		}
		return svar;
	}
	
	public int[] search(String keyword) {
		int[] tab = new int[innleggtabell.length];
		int j = 0;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i].getBruker() == keyword) {
				tab[j] = innleggtabell[i].getId();
			}
		}
		return tab;

	}
}