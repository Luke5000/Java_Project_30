package Inacio.Luyoka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Inacio.Luyoka.metier.Client;
import Inacio.Luyoka.metier.Compte;

public class CompteDaoImpl implements ICompteDao {
	
	
	Connection cnx = SingletonConnection.getConnection();
	
	
	
	@Override
	public Compte save(Compte c) {
		PreparedStatement cps;
		
		try {
			cps = cnx.prepareStatement("INSERT INTO compte VALUES (?,?,?,?,?,?,?) " );
			
			cps.setString(1, c.getNum());
			cps.setDate(2, c.getDateCreation());
			cps.setDouble(3, c.getSolde());
			cps.setString(4, c.getType());
			cps.setDouble(5, c.getTaux());
			cps.setDouble(6, c.getDecouvert());
			cps.setInt(7, c.getProprietaire().getId());
			
			cps.executeUpdate();
			cps.close();
			
			return c ;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public Compte update(Compte c) {
		
		try {
			PreparedStatement cps = cnx.prepareStatement("UPDATE compte set"
					+ " dateCreation = ?,"
					+ " solde = ?,"
					+ " type = ?,"
					+ " taux = ?,"
					+ " decouvert = ?,"
					+ " idProprietaire = ?"
					+ " where num = ?");
			
			cps.setDate(1, c.getDateCreation());
			cps.setDouble(2, c.getSolde());
			cps.setString(3, c.getType());
			cps.setDouble(4, c.getTaux());
			cps.setDouble(5, c.getDecouvert());
			cps.setInt(6, c.getProprietaire().getId());
			cps.setString(7, c.getNum());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(c.getNum());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int delete(Compte c) {
		
		try {
			PreparedStatement cps = cnx.prepareStatement("DELETE FROM compte WHERE num = ?");
			
			cps.setString(1, c.getNum());
			
			return cps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public ArrayList<Compte> getAll(int idClientProprietaire) {
		ArrayList<Compte> listCompte =  new ArrayList<Compte>();
		
		try {
			PreparedStatement cps = cnx.prepareStatement("SELECT * FROM compte WHERE idProprietaire = ?");
			
			cps.setInt(1, idClientProprietaire);
			
			ResultSet crs = cps.executeQuery();
			
			Compte cpt ;
			
			ClientDaoImpl clientdi = new ClientDaoImpl()   ; 
					
			while(crs.next()) {
				cpt = new Compte();
				cpt.setNum(crs.getString("num"));
				cpt.setDateCreation(crs.getDate("dateCreation"));
				cpt.setSolde(crs.getDouble("solde"));
				cpt.setType(crs.getString("type"));
				cpt.setTaux(crs.getDouble("taux"));
				cpt.setDecouvert(crs.getDouble("decouvert"));
				cpt.setProprietaire(clientdi.find(idClientProprietaire));
				
				listCompte.add(cpt);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCompte ;
		
	}

	@Override
	public Compte find(String num) {
		
		try {
			PreparedStatement cps = cnx.prepareStatement("SELECT * FROM client WHERE num = ? ");
			
			cps.setString(1, num);
			
			ResultSet crs = cps.executeQuery();
			
			ClientDaoImpl clientdi = new ClientDaoImpl()   ; 
			
			if(crs.next()) {
				Compte cpt = new Compte();
				
				cpt.setNum(crs.getString("num"));
				cpt.setDateCreation(crs.getDate("dateCreation"));
				cpt.setSolde(crs.getDouble("solde"));
				cpt.setType(crs.getString("type"));
				cpt.setTaux(crs.getDouble("taux"));
				cpt.setDecouvert(crs.getDouble("decouvert"));
		//  	cpt.setProprietaire(    ) ;   // Impossible de récuperer un client à partir du numéro d'un compte qui lui appartient ??
				
				
				return cpt;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
