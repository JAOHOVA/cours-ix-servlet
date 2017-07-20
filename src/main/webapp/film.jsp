<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Film</title>
</head>
<body>
  <h1>Titre : ${film.nom}</h1>
  <h2>Durée : ${film.duree} minutes</h2>
  <h3>Année : ${film.annee}</h3>
  <a href="${pageContext.request.contextPath}/film">Retour à la liste</a>
</body>
</html>