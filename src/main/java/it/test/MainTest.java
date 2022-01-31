package it.test;

import java.sql.Connection;

import it.data.ConnectionFactory;
import it.data.ContoCorrente;
import it.data.ContoCorrenteDAO;

public class MainTest {

	public static void main(String[] args) {
		
ContoCorrente a = ContoCorrenteDAO.getInstance().getConto(100);
		
if (a != null) System.out.println(" Numero conto ->  " + a.getNumero()+ " Intestato a :" + a.getIntestatario() + " Saldo attuale: " + a.getSaldo());
else System.out.println("Conto non trovato!"); 
		
		ContoCorrenteDAO idao = new ContoCorrenteDAO(ConnectionFactory.getConnection());
		
		
		idao.preleva(100, 799);
		

	}

}
