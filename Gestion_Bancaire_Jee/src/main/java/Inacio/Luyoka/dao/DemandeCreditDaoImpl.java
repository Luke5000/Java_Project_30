package Inacio.Luyoka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Inacio.Luyoka.metier.Client;
import Inacio.Luyoka.metier.Compte;
import Inacio.Luyoka.metier.DemandeCredit;

public class DemandeCreditDaoImpl implements IDemandeCreditDao {
	
	Connection cnx = SingletonConnection.getConnection();

	@Override
	public ArrayList<DemandeCredit> getAll(int idClientDemandeur) {
		ArrayList<DemandeCredit> listDemandeCredit =  new ArrayList<DemandeCredit>();
		
		try {
			PreparedStatement cps = cnx.prepareStatement("SELECT * FROM demandecredit WHERE idClientDemandeur = ?");
			
			
			cps.setInt(1, idClientDemandeur);
			
			ResultSet crs = cps.executeQuery();
			
			DemandeCredit dc ;
			
			ClientDaoImpl cdi = new ClientDaoImpl()   ;  
			
			while(crs.next()) {
				dc = new DemandeCredit();
				dc.setNum(crs.getString("num"));
				dc.setDate(crs.getDate("date"));
				dc.setMontant(crs.getDouble("montant"));
				dc.setDuree(crs.getInt("duree"));
				dc.setTaux(crs.getDouble("taux"));
				dc.setMensualite(crs.getDouble("mensualite"));
				dc.setEtat(crs.getString("etat"));
				dc.setClientDemandeur(cdi.find(idClientDemandeur));
				
				listDemandeCredit.add(dc);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listDemandeCredit;
	}

	@Override
	public DemandeCredit save(DemandeCredit demandeCredit) {
		PreparedStatement cps;
		
		try {
			cps = cnx.prepareStatement("INSERT INTO demandecredit VALUES (?,?,?,?,?,?,?,?)");
			
			cps.setString(1, demandeCredit.getNum());
			cps.setDate(2, demandeCredit.getDate());
			cps.setDouble(3, demandeCredit.getMontant());
			cps.setInt(4, demandeCredit.getDuree());
			cps.setDouble(5, demandeCredit.getTaux());
			cps.setDouble(6, demandeCredit.getMensualite());
			cps.setString(7, demandeCredit.getEtat());
			cps.setInt(8, demandeCredit.getClientDemandeur().getId());
			
			cps.executeUpdate();
			cps.close();
			
			
			return demandeCredit ;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public int delete(DemandeCredit demandeCredit) {
		try {
			PreparedStatement cps = cnx.prepareStatement("DELETE FROM demandecredit WHERE num = ?");
			
			cps.setString(1, demandeCredit.getNum());
			
			return cps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void update(String numDemandeCredit , String nouvelEtat) {
		try {
			PreparedStatement cps = cnx.prepareStatement("UPDATE demandecredit SET etat = ? WHERE num = ?");
			
			cps.setString(1, nouvelEtat);
			cps.setString(2, numDemandeCredit);
			
			cps.executeUpdate();
			cps.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	
	
	

}
