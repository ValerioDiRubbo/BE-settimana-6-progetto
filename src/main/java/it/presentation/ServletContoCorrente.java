package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import it.business.BancomatEjb;
import it.data.ConnectionFactory;
import it.data.ContoCorrente;
import it.data.ContoCorrenteDAO;



@WebServlet ("/servletcontocorrente")
public class ServletContoCorrente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @EJB
   BancomatEjb bancomat;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContoCorrenteDAO cc = new ContoCorrenteDAO(ConnectionFactory.getConnection());
		bancomat.setNumero(cc);
		
		// saldo, prelievo, versamento, euro
		
		String operazione = request.getParameter("operazione");
		Integer id = Integer.valueOf(request.getParameter("numeroconto"));
		Float euro = Float.valueOf(request.getParameter("euro"));
		ContoCorrente a = ContoCorrenteDAO.getInstance().getConto(id);
		
        if(operazione.equals("3")) {
        	
            cc.versa(id, euro);
            PrintWriter out = response.getWriter();
            out.println("Hai versato " + euro + " euro");

        }

        
      
        if(operazione.equals("2")) {
            cc.preleva(id, euro);
            PrintWriter out = response.getWriter();
            out.println("Hai prelevato " + euro + " euro");}
       {
        
        }
       
        if (operazione.equals("1")) {
        	
        	
        	cc.getConto(id);
        	ContoCorrente a1 = ContoCorrenteDAO.getInstance().getConto(id);
        	 
        	if (a1 != null) System.out.println(" Numero conto ->  " + a1.getNumero()+ " Intestato a :" + a1.getIntestatario() + " Saldo attuale: " + a1.getSaldo());
        	else System.out.println("Conto non trovato!"); 
        	
        	PrintWriter out = response.getWriter();
            out.println(" Numero conto ->  " + a1.getNumero()+ " Intestato a :" + a1.getIntestatario() + " Saldo attuale: " + a1.getSaldo());
        }
            
            
            
            
            
            

	

}
	
}
