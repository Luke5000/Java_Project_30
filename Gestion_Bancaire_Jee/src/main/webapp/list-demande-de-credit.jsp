<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Liste des comptes</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	
	 <%@include file="layout/demande-credit-navbar.jsp" %> 
	
		<br />
		<h3> Liste des demandes de crédit du client : &nbsp;&nbsp; Id client : ${idClient}  </h3>
		<br />
		    
		
		<table class="table">
		
		
		<thead>
		    <tr>
		        <th>Numéro</th>
				<th>Date de la demande</th>
				<th>montant</th>
				<th>durée</th>
				<th>Taux</th>
				<th>Mensualité</th>
				<th>Etat</th>
				<th></th>
		    </tr>
		</thead>
		
		 <tbody>
		 	<c:forEach var = "c" items="${demandesCredit}">
		  		<tr>
			      <th scope="row">${c.getNum() }</th>
			      <td>${c.getDate() }</td>
			      <td>${c.getMontant() }</td>
			      <td>${c.getDuree() }</td>
			      <td>${c.getTaux() }</td>
			      <td>${c.getMensualite() }</td>
			       <td>${c.getEtat() }</td>
			      
			      <td><a href="delete-demande-de-credit?num=${c.getNum() }&idClient=${idClient}">Supprimer</a></td>
			      <td><a href="modification-demande-de-credit?num=${c.getNum()}&date=${c.getDate()}&montant=${c.getMontant()}&duree=${c.getDuree()}&taux=${c.getTaux() }&mensualite=${c.getMensualite()}&etat=${c.getEtat()}&idClient=${idClient}"> Modifier </a></td>
			    </tr>
		  	</c:forEach>
		  	  </tbody>
		  
		  </table>
		
		 <a href="formulaire-new-demande-de-credit?idClientDemandeurDuCredit=${idClient}" class="btn btn-success">Nouvelle demande de credit pour le client n°${idClient}</a>
		
	
	</body>
</html>