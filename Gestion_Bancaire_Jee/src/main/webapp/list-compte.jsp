<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des comptes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@include file="layout/compte-navbar.jsp" %>

<div> Liste des comptes du client : Id client : ${idClient}   Prénom : ${prenomClient}     Nom : ${nomClient}  </div>

    

<table class="table">


<thead>
    <tr>
        <th>Numéro</th>
		<th>Date de création</th>
		<th>Solde</th>
		<th>Type</th>
		<th>Taux</th>
		<th>Découvert</th>
		
		<th></th>
    </tr>
</thead>

 <tbody>
 	<c:forEach var = "c" items="${comptes}">
  		<tr>
	      <th scope="row">${c.getNum() }</th>
	      <td>${c.getDateCreation() }</td>
	      <td>${c.getSolde() }</td>
	      <td>${c.getType() }</td>
	      <td>${c.getTaux() }</td>
	      <td>${c.getDecouvert() }</td>
	    </tr>
  	</c:forEach>
 		 
  </tbody>
  
  

</table>


</body>
</html>