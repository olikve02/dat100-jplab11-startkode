package no.hvl.dat100.jplab11.oppgave1;

import no.hvl.dat100.jplab11.common.TODO;

public abstract class Innlegg {

	protected int id;
	protected String bruker;
	protected String dato;
	protected int likes;

	public Innlegg() {

	}

	public Innlegg(int id, String bruker, String dato) {

		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		likes = 0;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;

	}

	public String getBruker() {

		return bruker;

	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return dato;

	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return id;

	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLikes() {
		return likes;
	}

	public void doLike () {
		this.likes += 1;
	}

	public boolean erLik(Innlegg innlegg) {
		boolean lik = false;
		if(innlegg != null) {
			if(this.getId() == innlegg.getId()) {
				lik = true;
			}
		}
		return lik;

	}

	@Override
	public String toString() {

		return this.id+"\n"+this.bruker+"\n"+this.dato+"\n"+this.likes+"\n";

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {

		return "<h2>"+bruker+"@"+dato+" [0]<h2>";

	}
}