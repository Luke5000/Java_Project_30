package Inacio.Luyoka.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Inacio.Luyoka.dao.ClientDaoImpl;
import Inacio.Luyoka.dao.CompteDaoImpl;
import Inacio.Luyoka.dao.DemandeCreditDaoImpl;
import Inacio.Luyoka.dao.SingletonConnection;
import Inacio.Luyoka.metier.Client;
import Inacio.Luyoka.metier.Compte;
import Inacio.Luyoka.metier.DemandeCredit;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class ClientServlet
 */


@WebServlet("/")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientDaoImpl clientdi = new ClientDaoImpl() ;
	ArrayList<Client> clients ;
	Client c ;
	int idClient ;
	ArrayList<Compte> comptes ;
	CompteDaoImpl comptedi = new CompteDaoImpl() ;
	String prenomClient ;
	String nomClient ;
	ArrayList<DemandeCredit> demandesCredit ;
	DemandeCreditDaoImpl dcdi = new DemandeCreditDaoImpl();
	
	String numeroDemandeCredit ;
	String dateDemandeCredit ;
	String montantDemandeCredit ;
	String dureeDemandeCredit ;
	String tauxDemandeCredit ;
	String mensualiteDemandeCredit ;
	String etatDemandeCredit ;
	
	DemandeCredit demandeCredit ;
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}




	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath()   ;
		
		
		
		System.out.println(path);
		
		switch(path) {
			case "/new-client" : 
							
							   request.getRequestDispatcher("new-client.jsp").forward(request, response);
							   break ;
							   
			case "/list-client" : 
								  clients = clientdi.getAll() ;
								  request.setAttribute("clients" , clients);
								  request.getRequestDispatcher("list-client.jsp").forward(request, response);
												 
							     break ;
			
			case "/delete-client" :
								   int id = Integer.parseInt(request.getParameter("idClient"));
								    c = new Client() ;
								   c.setId(id);
								   clientdi.delete(c);
								   
								   response.sendRedirect("list-client");
								   
								  
								   break ;
								   
								   
			case "/delete-demande-de-credit" :
				
					String num_demandeDeCredit = request.getParameter("num");
					idClient = Integer.parseInt(request.getParameter("idClient"));
					demandeCredit = new DemandeCredit();
					demandeCredit.setNum(num_demandeDeCredit);
					dcdi.delete(demandeCredit);
					
					request.setAttribute("idClient",idClient);
					
					request.getRequestDispatcher("list-demande-de-credit").forward(request, response);
					
					break ;
					
								   
								   
								   
				
								   
			case "/save-client":
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String dateNaissance = request.getParameter("date-naissance");
				String tel = request.getParameter("tel");
				String mail = request.getParameter("mail");
				String civilite = request.getParameter("civilite");
				String adresse = request.getParameter("adresse");
				
				c = new Client(nom, prenom, Date.valueOf(dateNaissance), adresse, tel, mail, civilite);
				
				
				c = clientdi.save(c);
				
				request.setAttribute("client", c);
				request.getRequestDispatcher("confirmation-new-client.jsp").forward(request, response);

				
				break;
				
			case "/save-demande-de-credit" :
				Connection cnx = SingletonConnection.getConnection();
				PreparedStatement cps ;
				idClient = Integer.parseInt(request.getParameter("idClientDemandeurDuCredit"))  ;
			    request.setAttribute("idClient",idClient);
				
				try {
					cps = cnx.prepareStatement("SELECT * FROM demandecredit WHERE etat = 'en_attente' ");
					ResultSet crs = cps.executeQuery();
					
					if(crs.next()) {
						String message_refus = "Impossible , il y'a encore au moins une demande de crédit en attente avant " ;
						request.setAttribute("message_refus", message_refus);
						request.getRequestDispatcher("refus-new-demande-de-credit.jsp").forward(request, response);
					}
					
					else {
						
					
						String num = request.getParameter("num");
						String date = request.getParameter("date");
						double montant = Double.parseDouble(request.getParameter("montant"));
						int duree = Integer.parseInt(request.getParameter("duree"))  ;
						double taux = Double.parseDouble(request.getParameter("taux"));
						double mensualite = Double.parseDouble(request.getParameter("mensualite"));
						String etat = request.getParameter("etat");
						
					    demandeCredit = new DemandeCredit(num, Date.valueOf(date) , montant , duree , taux , mensualite , etat , clientdi.find(idClient) );
					    
					    demandeCredit = dcdi.save(demandeCredit);
					    
					    request.setAttribute("demandeCredit",demandeCredit);
				
						request.getRequestDispatcher("confirmation-new-demande-credit.jsp").forward(request, response);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			
			    
				break;
				
				
				
			case "/details-client" :
				int idclient = Integer.parseInt(request.getParameter("idClient"));
				c = clientdi.find(idclient);
				
				request.setAttribute("client" , c);
				request.getRequestDispatcher("details-client.jsp").forward(request, response);
				break;
				
				
				
				
			case "/find":
				nom = request.getParameter("nom");
				prenom = request.getParameter("prenom");
				
				clients = clientdi.getAll(nom, prenom);
				
				//Passer le tableau des clients a la vue (list-client.jsp)
				request.setAttribute("clients", clients);
				//afficher une page jsp
				request.getRequestDispatcher("list-client.jsp").forward(request, response);
				
				break;
				
			case "/list-compte" :
				 idClient = Integer.parseInt(request.getParameter("idClient"));
				
			     prenomClient = request.getParameter("prenom");
			     nomClient = request.getParameter("nom");
			    
				 comptes = comptedi.getAll(idClient);
				 request.setAttribute("comptes", comptes);
				
				 request.setAttribute("prenomClient", prenomClient);
				 request.setAttribute("nomClient", nomClient);
				 
				 request.setAttribute("idClient",idClient);
				
				request.getRequestDispatcher("list-compte.jsp").forward(request, response);
				break ;
				
			case "/list-demande-de-credit" :
				idClient = Integer.parseInt(request.getParameter("idClient"));
				
			   
			    
				 demandesCredit = dcdi.getAll(idClient);
				 request.setAttribute("demandesCredit", demandesCredit);
				
				
				
				 
				 request.setAttribute("idClient",idClient);
				
				request.getRequestDispatcher("list-demande-de-credit.jsp").forward(request, response);
				break ; 
				
			case "/modification-demande-de-credit" :
				numeroDemandeCredit = request.getParameter("num");
				dateDemandeCredit = request.getParameter("date");
				montantDemandeCredit = request.getParameter("montant");
				dureeDemandeCredit = request.getParameter("duree");
				tauxDemandeCredit = request.getParameter("taux");
				mensualiteDemandeCredit = request.getParameter("mensualite");
				etatDemandeCredit = request.getParameter("etat");
				idClient = Integer.parseInt(request.getParameter("idClient"));
				
				request.setAttribute("numeroDemandeCredit",numeroDemandeCredit);
				request.setAttribute("dateDemandeCredit",dateDemandeCredit);
				request.setAttribute("montantDemandeCredit",montantDemandeCredit);
				request.setAttribute("dureeDemandeCredit",dureeDemandeCredit);
				request.setAttribute("tauxDemandeCredit",tauxDemandeCredit);
				request.setAttribute("mensualiteDemandeCredit",mensualiteDemandeCredit);
				request.setAttribute("etatDemandeCredit",etatDemandeCredit);
				request.setAttribute("idClient",idClient);
				
				request.getRequestDispatcher("modification-demande-de-credit.jsp").forward(request, response);
				break ; 

				
			case "/enregistrement-modification-demande-de-credit" :
				
				numeroDemandeCredit = request.getParameter("numDemandeCredit");
				etatDemandeCredit = request.getParameter("etat");
				idClient = Integer.parseInt(request.getParameter("idClient") )  ;
				
				dcdi.update(numeroDemandeCredit, etatDemandeCredit);
				
				
				request.setAttribute("idClient",idClient);
				request.getRequestDispatcher("list-demande-de-credit").forward(request, response);  
				// response.sendRedirect("list-demande-de-credit");
				
				
				
				break ; 
				
			
			case "/formulaire-new-demande-de-credit" :  idClient = Integer.parseInt(request.getParameter("idClientDemandeurDuCredit"));
														request.setAttribute("idClient",idClient);
														request.getRequestDispatcher("formulaire-new-demande-de-credit.jsp").forward(request, response);
														break ;

			
			
			
			default : request.getRequestDispatcher("index.jsp").forward(request, response);
			
							  
		}
			
		
	}
       
   

	
	
}
