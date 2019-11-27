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


 <div class="container-fluid">
 <br>
 
<form action="addKolor" name="Dodaj Kolor">
<br>
<div class="input-group mb-3">
<div class="input-group-prepend">
    <button class="btn btn-outline-primary" type="submit">Dodaj kolor do bazy</button>
  </div>
<input type="text" class="form-control" placeholder="Podaj nazwe koloru" id="nazwaKoloru" name="nazwaKoloru">
<input type="text" class="form-control" placeholder="Podaj Wartosc R" id="r" name="r">
<input type="text" class="form-control" placeholder="Podaj Wartosc G" id="g" name="g">
<input type="text" class="form-control" placeholder="Podaj Wartosc B" id="b" name="b"></div>
</form>

</div>
</body>
</html>		