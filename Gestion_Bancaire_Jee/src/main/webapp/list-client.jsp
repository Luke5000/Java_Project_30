<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Liste des clients</title>
</head>
<body>
<%@include file="layout/navbar.jsp" %>
<div class="container" >
<h2 class="mt-4">Liste des clients</h2>

<form method = "post" action="find">
	 <div class="form-group row mb-3">
	    
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="nom" placeholder="Nom">
	    </div>
	    
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="prenom" placeholder="Prénom">
	    </div>
	    
	    <button type="submit" class="btn btn-primary col-sm-2 mb-2">Chercher</button>
	  </div>
	  
	 </form>



<table class="table">
  <thead>
    <tr>
      <th>Identifiant</th>
		<th>Nom</th>
		<th>Prénom</th>
		<th>Adresse</th>
		<th>Tél</th>
		<th>Date naissance</th>
		<th>@Mail</th>
		<th>Civilité</th>
		<th></th>
    </tr>
  </thead>
  <tbody>
 	<c:forEach var = "c" items="${clients}">
  		<tr>
	      <th scope="row">${c.getId() }</th>
	      <td>${c.getNom() }</td>
	      <td>${c.getPrenom() }</td>
	      <td>${c.getAdresse() }</td>
	      <td>${c.getTel() }</td>
	      <td>${c.getDateNaissance() }</td>
	      <td>${c.getMail() }</td>
	      <td>${c.getCivilite() }</td>
	      <td><a href="delete-client?idClient=${c.getId() }">Supprimer</a></td>
	       <td><a href="details-client?idClient=${c.getId() }">plus</a></td>
	      
	    </tr>
  	</c:forEach>
 		 
  </tbody>
</table>
</div>
</body>
</html>

