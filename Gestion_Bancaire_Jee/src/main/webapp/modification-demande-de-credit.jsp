<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Modification demande de crédit</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	 <%@include file="layout/demande-credit-navbar.jsp" %> 
	<div class="card" style="width: 18rem;">
		<div class="card-body">
			 <h5 class="card-title">Demande de crédit </h5>
			<p class="card-text">Numero : ${numeroDemandeCredit } </p>
			<p class="card-text">Date : ${dateDemandeCredit }  </p>
			<p class="card-text">Montant : ${montantDemandeCredit } </p>
			<p class="card-text">Durée : ${dureeDemandeCredit } </p>
			<p class="card-text">Taux : ${tauxDemandeCredit } </p>
			<p class="card-text">Mensualite : ${mensualiteDemandeCredit } </p>
			<p class="card-text">
				<form method="post" action="enregistrement-modification-demande-de-credit?numDemandeCredit=${numeroDemandeCredit}&idClient=${idClient}">
					
					Etat : 
					<select name="etat">
						<option value="en_attente">en attente</option>
						<option value="acceptee">acceptée</option>
						<option value="refusee">refusée</option>
					</select>
					<br /><br />
					
					<input type="submit" value="Enregistrer" />
					
				</form>
			
			</p>
		</div>
	
	</div>
	
	
	
	</body>
</html>