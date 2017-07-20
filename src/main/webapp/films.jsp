<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Films</title>
</head>
<body>
  <h1>Liste des films</h1>
  <ul>
	<c:forEach var="film" items="${ films}"> 
	
		<li>
			<p>
				<b><c:out value="${ film.nom }"/></b>
			</p>
			<ul>
				<li><b><c:out value="${ film.duree }"/> minutes</b></li>
				<li><b><c:out value="${ film.annee}"/></b></li>
			</ul>
		</li>
	</c:forEach>
</ul>
</body>
</html>
