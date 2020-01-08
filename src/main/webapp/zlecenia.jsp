  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <%@ page import="java.sql.*"%>
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<html>
<head>
<head>
  <meta charset=UTF-8>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="scripts.js"></script>
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
    <li class="breadcrumb-item active">Pokaż zlecenia</li>
  </ul>

 <div class="container-fluid">
    <input class="form-control" id="myInput" type="text" placeholder="Filtruj">
<br>
<table id="listaZlecen" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%"> 
  <thead>
    <tr>
    <th class="th-sm"><small><center><b>ID ZLECENIA</b></center></small><div class="btn-group btn-group-justified"><form action="getZleceniaIdDesc"><button class="btn btn-outline-primary btn-sm" type="submit" style='font-size:10px'><i class='fas fa-caret-down'></i></button></form><form action="getZlecenia"><button class="btn btn-outline-primary btn-sm" type="submit" style='font-size:10px'><i class='fas fa-caret-up'></i></button></form></div>
      </th>
      <th class="th-sm"><small><center><b>NUMER KLIENTA</b></center></small>
      </th>
     <th class="th-sm"><small><center><b>NUMER ETYKIETY</b></center></small><div class="row"><div class="col-sm-5"><form action="getZleceniaNumerEtykietyDesc"><button class="btn btn-outline-primary btn-sm" type="submit" style='font-size:10px'><i class='fas fa-caret-down'></i></button></form></div><div class="col-sm-5"><form action="getZlecenia"><button class="btn btn-outline-primary btn-sm" type="submit" style='font-size:10px'><i class='fas fa-caret-up'></i></button></form></div></div>
      </th>
       <th class="th-sm"><small><center><b>NAZWA ETYKIETY</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>NAZWA KLIENTA</b></center></small>
      </th>
       <th class="th-sm"><small><center><b>ILOŚĆ ETYKIET</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>PRIORYTET</b></center></small>
      </th>
        <th class="th-sm"><small><center><b>DATA WYSYŁKI</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>ID WYKROJNIKA</b></center></small>
      </th>
       <th class="th-sm"><small><center><b>RODZAJ SUROWCA</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>SZEROKOŚĆ MATERIAŁU</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>NUMER MASZYNY</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>GILZA</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>HANDLOWIEC</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>KOLOR 1</b></center></small>
      </th>
        <th class="th-sm"><small><center><b>KOLOR 2</b></center></small>
      </th>
        <th class="th-sm"><small><center><b>KOLOR 3</b></center></small>
      </th>
        <th class="th-sm"><small><center><b>KOLOR 4</b></center></small>
      </th>
        <th class="th-sm"><small><center><b>KOLOR 5</b></center></small>
      </th>
        <th class="th-sm"><small><center><b>KOLOR 6</b></center></small>
      </th>
        <th class="th-sm"><small><center><b>KOLOR 7</b></center></small>
      </th>
        <th class="th-sm"><small><center><b>KOLOR 8</b></center></small>
      </th>
     </tr>
  </thead>
  <tbody id="myTable">
    <c:forEach var="Zlecenia" items="${result }" ><tr><td><center>${Zlecenia.id}</center></td><td><center>${Zlecenia.numerKlienta}</center></td><td><center>${Zlecenia.numerEtykiety}</center>
    </td><td><center><small>${Zlecenia.nazwaEtykiety}</small></center></td><td><center>${Zlecenia.nazwaKlienta}</center></td><td><center>
    <fmt:formatNumber type="number"  pattern="###,###" value="${Zlecenia.iloscEtykiet}" /></center></td><td><center>${Zlecenia.priorytet}</center></td>
    <td><center>${Zlecenia.dataWysylki}</center></td><td><center>${Zlecenia.idWykrojnika}</center></td><td><center>${Zlecenia.rodzajSurowca}</center></td>
    <td><center>${Zlecenia.szerokoscSurowca}</center></td><td><center>${Zlecenia.maszyna}</center></td><td><center>${Zlecenia.gilza}</center></td>
    <td><center>${Zlecenia.wystawil}</center></td><td><center><small>${Zlecenia.kolor1}<br>
    
    <center><small><input class="form-control" onmouseover="pokazkolorwzleceniu(this)" disabled="disabled" id="${Zlecenia.kolor1}" style="background-color: rgb(${Kolory.r}, ${Kolory.g}, ${Kolory.b})"></small></center></small></center></td>
    
    <td><center><small>${Zlecenia.kolor2}</small></center></td><td><center><small>${Zlecenia.kolor3}</small></center></td><td><center><small>${Zlecenia.kolor4}</small></center></td>
    <td><center><small>${Zlecenia.kolor5}</small></center></td><td><center><small>${Zlecenia.kolor6}</small></center></td><td><center><small>${Zlecenia.kolor7}</small></center></td>
    <td><center><small>${Zlecenia.kolor8}</small></center></td><td><center><form action="delZlecenia" method="post"></center>
<form action="delZlecenia"><button type="submit" name="id" value="${Zlecenia.id}" alt="USUN" class="btn btn-info btn-sm"><i class='fas fa-trash-alt'></i></button>
</form></tr></c:forEach> 
  </tbody>
</table>

<datalist id="datalist_kolory"><c:forEach var="Kolory" items="${result2 }"><option value="${Kolory.nazwaKoloru}" data-rgb="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></c:forEach></datalist>
</div>


</body>
</html>		