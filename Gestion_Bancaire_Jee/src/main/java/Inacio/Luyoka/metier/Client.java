package Inacio.Luyoka.metier;

import java.sql.Date;
import java.util.ArrayList;



public class Client{
	
	private int id ;
	private String nom ;
	private String prenom ;
	private Date dateNaissance ;
	private String adresse ;
	private String tel ;
	private String mail ;
	private String civilite ;
	
	//private ArrayList<Compte> comptes = new ArrayList<Compte>() ;
	//private ArrayList<DemandeCredit> demandesCredit = new ArrayList<DemandeCredit>() ;
	//private static int nombreClient = 0 ;
	
	// N'aurait il pas été plus judicieux de créer deux ArrayList distincts : l'un pour CompteEpargne et l'autre pour CompteCourant
	//private ArrayList<CompteEpargne> comptesEpargne = new ArrayList<CompteCourant>() ;
	//private ArrayList<Compte> comptes = new ArrayList<Compte>() ;
	//private ArrayList<Compte> comptes = new ArrayList<Compte>() ;
	
	
	public Client() {
		//nombreClient++ ;
	}
	
	public Client( String nom, String prenom, Date dateNaissance, String adresse, String tel, String mail,
			String civilite) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.civilite = civilite;
		
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id ;
	}

	

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the civiliteClient
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * @param civiliteClient the civiliteClient to set
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	

	/**
	 * @return the nombreClient
	 */
/*	public static int getNombreClient() {
		return nombreClient;
	}

	/**
	 * @param nombreClient the nombreClient to set
	 */
/*	public static void setNombreClient(int nombreClient) {
		Client.nombreClient = nombreClient;
	} */

	/*public void ajouterUnCompte(Compte c) {
		this.comptes.add(c);
	} */

	/*@Override
	public String toString() {
		return "Client [nom=" + nom + ", code=" + code + "]";
	} */
	
	/*public void ajouterDemandeDeCredit(DemandeCredit d){
		this.demandesCredit.add(d);
	}*/
	
	public void afficher() {
		System.out.println("Id : " + this.id);
		System.out.println("Nom : " + this.nom);
		System.out.println("Prenom : " + this.prenom);
		System.out.println("Date de naissance : " + this.dateNaissance);
		System.out.println("Adresse : " + this.adresse);
		System.out.println("Numero de telephone : " + this.tel);
		System.out.println("Adresse mail : " + this.mail);
		System.out.println("Civilite : " + this.civilite);
		/*System.out.println("Comptes : " );
		for(Compte c1:this.comptes) {
			System.out.println("N° du compte : " + c1.getNumeroCompte());
			System.out.println("Solde : " + c1.getSolde());
			System.out.println("Date de création : " + c1.getDateDeCreation());
			System.out.println("\n");
		}  */ 
	}
	
	
	
	 
	
	
	
	
	
}
