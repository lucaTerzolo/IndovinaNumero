package it.polito.rdp.IndovinaNumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {

	private int segreto;
	private final int TMAX = 8;
	private final int NMAX = 100;
	private int tentativiFatti;
	private boolean inGioco=false;
	
	private Set<Integer> tentativi;
	
	public void nuovaPartita() {
		this.tentativi=new HashSet<Integer>();
		this.segreto = (int)((Math.random() * NMAX) +1);
		this.tentativiFatti = 0;
		this.inGioco=true;
	}
	
	public int tentativo(int tentativo) {
		
		if(!inGioco)
			throw new IllegalStateException("Hai perso! La partita è terminata");
		if (!tentativoValido(tentativo)) 
			throw new InvalidParameterException("Devi inserire un numero tra 1 e "+NMAX+" che non hai ancora utilizzato");
		
		tentativiFatti++;
		this.tentativi.add(tentativo);
		
		if (tentativiFatti==TMAX)
			inGioco=false;
		
		if(tentativo==segreto) {
			inGioco=true;
			return 0;
		}else if(tentativo<segreto)
			return -1;
			else 
				return 1;
		
	}
	
	private boolean tentativoValido(int tentativo) {
		if (tentativo<1||tentativo>NMAX||tentativi.contains(tentativo)) 
			return false;
		else
			return true;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}
	
}
