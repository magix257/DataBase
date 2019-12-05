  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
    <li class="breadcrumb-item active">Dodaj klienta</li>
  </ul>

 <div class="container">
<form action="addKlient" name="Dodaj_Klienta">
<div class="input-group mb-3">
<div class="input-group-prepend">
    <button class="btn btn-outline-primary" type="submit">Dodaj klienta do bazy</button>
  </div>
<input type="text" class="form-control" placeholder="Podaj nazwe klienta" id="nazwaKlienta" name="nazwaKlienta">
<input type="text" class="form-control" placeholder="Podaj numer klienta" id="numerKlienta" name="numerKlienta">
</div>
</form>
</div>
<div class="container">
 <input class="form-control" id="myInput" type="text" placeholder="Filtruj">
  <br>   
<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%"> 
  <thead>
    <tr>
   
   <th class="th-sm"><small><center><b>ID KLIENTA</b></center></small>
      </th>
   
      <th class="th-sm"><small><center><b>NUMER KLIENTA</b></center></small><div class="row mx-auto"><div class="w-50"><form action="addKlienciNumerKlientaDesc"><center><button class="btn btn-outline-info btn-sm" type="submit" style='font-size:10px'><i class='fas fa-caret-down'></i></button></center></form></div><div class="w-50"><form action="addKlienci"><center><button class="btn btn-outline-info btn-sm" type="submit" style='font-size:10px'><i class='fas fa-caret-up'></i></button></center></form></div></div>
      </th>
     
      <th class="th-sm"><small><center><b>NAZWA KLIENTA</b></center></small><div class="row mx-3"><div class="w-50"><form action="addKlienciNazwaKlientaDesc"><center><button class="btn btn-outline-info btn-sm" type="submit" style='font-size:10px'><i class='fas fa-caret-down'></i></button></center></form></div><div class="w-50"><form action="addKlienciNazwaKlientaAsc"><center><button class="btn btn-outline-info btn-sm" type="submit" style='font-size:10px'><i class='fas fa-caret-up'></i></button></center></form></div></div>
      </th>

     </tr>
  </thead>
   <tbody id="myTable">
    <c:forEach var="Klienci" items="${result }"><tr><td><center>${Klienci.id}</center></td><td><center>${Klienci.numerKlienta}</center></td><td><center>${Klienci.nazwaKlienta}</center></td>
    <td><center><form action="delKlienci"></center>
<button type="submit" name="id" value="${Klienci.id}" alt="USUN" class="btn btn-info btn-sm"><i class='fas fa-trash-alt'></i></button>
</form></td></tr></c:forEach>
  </tbody>
</table>
</div>



</body>
</html>		