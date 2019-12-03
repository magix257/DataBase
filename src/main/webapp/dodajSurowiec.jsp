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
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
<img src="logoetiko.svg" width="447.029" height="95.04" />
</div>
<ul class="breadcrumb">
    <li class="breadcrumb-item"><a href="http://localhost:8080/">Home</a></li>
    <li class="breadcrumb-item active">Dodaj surowiec</li>
  </ul>

 <div class="container-fluid">
<form action="addSurowiec" name="Dodaj_Surowiec">
<div class="input-group mb-3">
<div class="input-group-prepend">
    <button class="btn btn-outline-primary" type="submit">Dodaj surowiec do bazy</button>
  </div>
<input type="text" class="form-control" placeholder="NAZWA SUROWCA" id="nazwaSurowca" name="nazwaSurowca">
<input list="rodzajSurowca" id="rodzajSurowca1" class="form-control" placeholder="RODZAJ SUROWCA" name="rodzajSurowca"><datalist id="rodzajSurowca">
    <option value="PAPIER NIETERMICZNY">
    <option value="PAPIER NIETERMICZNY PET23">
    <option value="PAPIER TERMICZNY">
    <option value="PAPIER TERMICZNY PET23">
    <option value="PAPIER SREBRNY">
    <option value="FOLIA SREBRNA">
    <option value="FOLIA BIA£A">
    <option value="FOLIA BIA£A PET23">
    <option value="FOLIA BIA£A TERMICZNA">
    <option value="FOLIA BIA£A TERMICZNA PET23">
    <option value="FOLIA TRANSPARENTNA">
    <option value="FOLIA TRANSPARENTNA PET23">
    <option value="FOLIA TRANSPARENTNA TERMICZNA">
    <option value="FOLIA TRANSPARENTNA TERMICZNA PET23">
    <option value="GLOSS">
    <option value="HIGH GLOSS">
    <option value="RADIANT">
    <option value="INNY">
</datalist>
</div>
</form>

<form action="getSurowce" name="Pokaz_Surowce">
 <button class="btn btn-primary" type="submit">Pokaz Surowce</button>
</form>

</div>
</body>
</html>		