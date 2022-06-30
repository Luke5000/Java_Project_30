<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@include file="layout/navbar.jsp" %>

<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Confirmation </h5>
    <p>Le nouveau client a bien �t� enregistr� !</p>
    <p class="card-text">Id : ${client.getId()}</p>
    <p class="card-text">Nom : ${client.getNom()}</p>
    <p class="card-text">Pr�nom : ${client.getPrenom()}</p>
    <p class="card-text">Date de naissance : ${client.getDateNaissance()}</p>
    <p class="card-text">Adresse : ${client.getAdresse()}</p>
    <p class="card-text">T�l : ${client.getTel()}</p>
    <p class="card-text">Mail : ${client.getMail()}</p>
    <p class="card-text">Civilit� : ${client.getCivilite()}</p>
    <a href="list-client" class="btn btn-primary">Liste des clients</a>
  </div>
</div>






</body>
</html>