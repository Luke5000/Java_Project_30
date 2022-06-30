<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

 <%@include file="layout/demande-credit-navbar.jsp" %> 
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Confirmation </h5>
    <p>La nouvelle demande de cr�dit a bien �t� enregistr� !</p>
    <p class="card-text">Id client demandeur du cr�dit : ${demandeCredit.getClientDemandeur().getId()}</p>
    <p class="card-text">Num�ro : ${demandeCredit.getNum()}</p>
    <p class="card-text">Date : ${demandeCredit.getDate()}</p>
    <p class="card-text">Montant : ${demandeCredit.getMontant()}</p>
    <p class="card-text">Dur�e : ${demandeCredit.getDuree()}</p>
    <p class="card-text">Taux : ${ demandeCredit.getTaux()}</p>
    <p class="card-text">Mensualit� : ${demandeCredit.getMensualite()}</p>
    <p class="card-text">Etat : ${demandeCredit.getEtat()}</p>
    <a href="list-demande-de-credit?idClient=${demandeCredit.getClientDemandeur().getId()}&prenom=${demandeCredit.getClientDemandeur().getPrenom()}&nom=${demandeCredit.getClientDemandeur().getNom()}" class="btn btn-primary">Liste des demandes de cr�dit du client n�${demandeCredit.getClientDemandeur().getId()}</a>
  </div>
</div>



