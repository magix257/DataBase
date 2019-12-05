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
 <script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
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
<br> 
<form action="addSurowiec" name="Dodaj_Surowiec">
<div class="input-group mb-3">
<div class="input-group-prepend">
    <button class="btn btn-outline-success" type="submit">Dodaj surowiec do bazy</button>
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

<div class="container">
 <input class="form-control" id="myInput" type="text" placeholder="Filtruj">
  <br>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%"> 
  <thead>
    <tr>
   
   <th class="th-sm"><small><center><b>ID SUROWCA</b></center></small>
      </th>
   
      <th class="th-sm"><small><center><b>NAZWA SUROWCA</b></center></small>
      </th>
     
      <th class="th-sm"><small><center><b>RODZAJ SUROWCA</b></center></small>
      </th>

     </tr>
  </thead>
   <tbody id="myTable">
    <c:forEach var="Surowce" items="${result }"><tr><td><center>${Surowce.id}</center></td><td><center>${Surowce.nazwaSurowca}</center></td><td><center>${Surowce.rodzajSurowca}</center></td>
    <td><div class="form-group"><form action="delSurowce"><button type="submit" name="id" value="${Surowce.id}" class="btn btn-primary btn-sm"><i class='fas fa-trash-alt fa-xs'></i></button></form></div></td></tr></c:forEach>
  </tbody>
</table>
</div>

</form>
</div>
</body>
</html>		