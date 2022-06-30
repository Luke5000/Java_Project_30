
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle demande de crédit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script>

function afficher_mensualite(){
    let c = parseFloat(document.getElementById('montant').value) ;
    let t = parseFloat(document.getElementById('taux').value) ;
    let n = parseFloat(document.getElementById('duree').value) ;
    
    
    let m = (c * t/12) / ( 1 - Math.pow( ( 1 + t/12 ) , -n ) ) ;

    document.getElementById('simulation_mensualite').innerHTML = "mensualite : " + m ;
    
}
</script>
</head>
<body>
 <%@include file="layout/demande-credit-navbar.jsp" %> 
<div class="container">
<h3>Nouvelle demande de crédit pour le client n°${idClient}</h3>

<form method = "post" action = "save-demande-de-credit?idClientDemandeurDuCredit=${idClient}">
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Numéro : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="num" name="num">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Date : </label>
	    <div class="col-sm-4">
	      <input type="date" class="form-control" id="date" name="date">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Montant </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="montant" name="montant">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Durée </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="duree" name="duree">
	    </div>
	  </div>
		
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Taux : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="taux" name="taux">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Mensualite : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="mensualite" name="mensualite">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Etat : </label>
	    <div class="col-sm-4">
	      <select class="form-control" id="etat" name="etat">
	      	<option value="en_attente">En attente</option>
	      	<option value="refusee">Refusée</option>
	      	<option value="acceptee">Acceptée</option>
	      </select>
	    </div>
	  </div>
	  
	  
	  
	  
	  
	   <a href="#" onClick="afficher_mensualite()" class="btn btn-warning">Simuler la mensualité</a>
	  <button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
	</form>
	<br />
	<br />
	<br />
	<p id="simulation_mensualite"></p>
	  

</div>
</body>
</html>