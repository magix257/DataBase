  <%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2" isELIgnored="false"%>
  <%@ page import="java.sql.*"%>
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset=UTF-8>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="scripts.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
<img src="logoetiko.svg" width="447.029" height="95.04" />
</div>


<ul class="breadcrumb">
    <li class="breadcrumb-item"><a href="http://localhost:8080/">Home</a></li>
    <li class="breadcrumb-item active">Dodaj kolor</li>
  </ul>

 <div class="container-fluid">
 <div class="input-group mb-3">
 <form action="getKolory" name="Pokaz_Kolory">
<button class="btn btn-danger" type="submit">POKA� KOLORY</button>
</form>
</div>
 
 
 
<form action="addKolor" name="Dodaj_Kolor">
<div class="input-group mb-3">
<div class="input-group-prepend">
    <button class="btn btn-outline-danger" type="submit">Dodaj kolor do bazy</button>
  </div>
<input type="text" class="form-control" placeholder="Podaj nazwe koloru" id="nazwaKoloru" name="nazwaKoloru">
<input type="text" class="form-control" placeholder="Podaj warto�� R" id="r" name="r">
<input type="text" class="form-control" placeholder="Podaj warto�� G" id="r" name="g">
<input type="text" class="form-control" placeholder="Podaj warto�� B" id="r" name="b">
</div>
</form>
 
</div>
</body>
</html>		