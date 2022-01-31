package it.business;

import it.data.ContoCorrenteDAO;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;


/**
 * Session Bean implementation class BancomatEjb
 */
@Stateful
@LocalBean
public class BancomatEjb implements BancomatEjbLocal {

    private ContoCorrenteDAO ContoCorrenteDAO;
    
    public ContoCorrenteDAO getNumero() {return ContoCorrenteDAO;}
    public void setNumero(ContoCorrenteDAO numero) {this.ContoCorrenteDAO = numero;}


	public BancomatEjb() {

    }

    
    /*La richiesta della form sarà inviata ad una servlet che demanderà ad un EJB il controllo dei dati attraverso un metodo specifico:
• public boolean controllaOperazione(String operazione, int numero, float quantita)
Tale metodo tornerà false se i dati sono errati (ad esempio se la quantità è negativa, se il numero del conto non esiste o se la quantità da prelevare supera il saldo).
Per semplicità puoi effettuare solo i controlli principali. */
    
	@Override
	public boolean controllaOperazione(String operazione, int id_conto, float quantita) {

	if (quantita >= 0) {
		if(operazione == "saldo") {
			ContoCorrenteDAO.getConto(id_conto);
		}
	}
		
		
		
		
		return false;
	}

}
