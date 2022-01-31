package it.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ContoCorrenteDAO {

public static final String SELECT_BY_NUMERO = "SELECT numero, intestatario, saldo FROM contocorrente WHERE numero=?";
public static final String VERSAMENTO_BY_NUMERO = "UPDATE contocorrente SET saldo= saldo + ? WHERE numero =?;";
public static final String PRELEVA_BY_NUMERO = "UPDATE contocorrente SET  saldo = saldo -? WHERE numero = ? and saldo > ?;";


	
	private static final String FLD_NUMERO = "numero";
	private static final String FLD_INTESTATARIO = "intestatario";
	private static final String FLD_SALDO = "saldo";	
	
	private Connection conn;
	
	private static ContoCorrenteDAO instance = null;
	
	public static ContoCorrenteDAO getInstance() {
		if (instance == null) instance = new ContoCorrenteDAO (ConnectionFactory.getConnection());
		return instance;
	}
	
	public ContoCorrenteDAO(Connection conn) {
		this.conn = conn;
	}
	
	public ContoCorrente getConto (int numero) {
		PreparedStatement ps  = null;
		ResultSet rs = null;
		
		try {
			ps= conn.prepareStatement(SELECT_BY_NUMERO);
			ps.setInt(1, numero);
			
			rs = ps.executeQuery();
			
			ContoCorrente cc = new ContoCorrente ();
			
			if (rs.next()) {
				cc.setNumero(rs.getInt(FLD_NUMERO));
				cc.setIntestatario(rs.getString(FLD_INTESTATARIO));
				cc.setSaldo(rs.getFloat(FLD_SALDO));
			}
			
			return cc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
		
		public boolean versa(int numeroconto, float importo) {
			 PreparedStatement ps = null;
		        int results = 0;
		        
		        try {
		            ps = conn.prepareStatement(VERSAMENTO_BY_NUMERO);
		            ps.setInt(2, numeroconto);
		            ps.setFloat(1, importo);
		            results = ps.executeUpdate();
		            
		            if(results == 0) {
		                System.out.println("Versamento non riuscito");
		                return false;
		            }
		            
		            System.out.println("Versamento di " + importo + " euro riuscito");
		            return true;
		        } catch (SQLException e) {
		            e.printStackTrace();
		            System.out.println("Non è stato possibile versare.");
		            return false;
		        }     
		}
		

		public boolean preleva(int numeroconto, float importo) {
			 PreparedStatement ps = null;
		        int results = 0;
		        
		        try {
		            ps = conn.prepareStatement(PRELEVA_BY_NUMERO);
		            ps.setInt(2, numeroconto);
		            ps.setFloat(1, importo);
		            ps.setFloat(3,  importo);
		            results = ps.executeUpdate();
		            
		            if(results == 0) {
		                System.out.println("Prelievo non riuscito");
		                return false;
		            }
		            
		            System.out.println("Prelievo di " + importo + " euro riuscito");
		            return true;
		        } catch (SQLException e) {
		            e.printStackTrace();
		            System.out.println("Non è stato possibile versare.");
		            return false;
		        }     
		}
		
		
		
}
		
	

