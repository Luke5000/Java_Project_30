
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouveau Client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="layout/navbar.jsp" %>
<div class="container">
<h3>Nouveau client</h3>

<form method = "post" action = "save-client">
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Nom : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="nom">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Prénom : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="prenom">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Date de naissance : </label>
	    <div class="col-sm-4">
	      <input type="date" class="form-control" name="date-naissance">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Adresse : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="adresse">
	    </div>
	  </div>
		
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Tél : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="tel">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Mail : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="mail">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Civilité : </label>
	    <div class="col-sm-4">
	      <select class="form-control" name="civilite">
	      	<option value="Monsieur">Monsieur</option>
	      	<option value="Madame">Madame</option>
	      	<option value="Mademoiselle">Mademoiselle</option>
	      </select>
	    </div>
	  </div>
	  <button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
	</form>
	  

</div>
</body>
</html>