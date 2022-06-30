package Inacio.Luyoka.dao;

import java.util.ArrayList;

import Inacio.Luyoka.metier.Client;
import Inacio.Luyoka.metier.DemandeCredit;

public interface IDemandeCreditDao {
	
	ArrayList<DemandeCredit> getAll(int idClientDemadeur);
	
	DemandeCredit save(DemandeCredit demandeCredit) ;
	
	int delete(DemandeCredit demandeCredit);
	
	void update(String numDemandeCredit , String nouvelEtat);
	
	

}
