package Inacio.Luyoka.metier;

import java.sql.Date;

public class DemandeCredit {
	
	private String num ;
	private Date date ;
	private double montant ;
	private int duree ;
	private double taux ;
	private double mensualite ;
	private String etat ;
	private Client clientDemandeur ;
	
	public DemandeCredit() {
	}

	public DemandeCredit(String num, Date date, Double montant, int duree, double taux, double mensualite, String etat,
			Client clientDemandeur) {
		this.num = num;
		this.date = date;
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
		this.mensualite = mensualite;
		this.etat = etat;
		this.clientDemandeur = clientDemandeur;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getMensualite() {
		return mensualite;
	}

	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Client getClientDemandeur() {
		return clientDemandeur;
	}

	public void setClientDemandeur(Client clientDemandeur) {
		this.clientDemandeur = clientDemandeur;
	}
	
	
	
	

}
