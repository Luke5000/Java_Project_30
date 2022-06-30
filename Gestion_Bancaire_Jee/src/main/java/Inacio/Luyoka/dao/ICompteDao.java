package Inacio.Luyoka.dao;

import java.util.ArrayList;

import Inacio.Luyoka.metier.Client;
import Inacio.Luyoka.metier.Compte;

public interface ICompteDao {
	
	Compte save(Compte c) ;
	Compte update(Compte c);
	int delete(Compte c);
	
	
	ArrayList<Compte> getAll(int idClientProprietaire) ;
	
	
	Compte find(String num);
	
	
	
	
	

}
