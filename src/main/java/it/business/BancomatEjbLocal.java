package it.business;

import jakarta.ejb.Local;

@Local
public interface BancomatEjbLocal {

	public boolean controllaOperazione (String operazione, int numero, float quantita);
}
