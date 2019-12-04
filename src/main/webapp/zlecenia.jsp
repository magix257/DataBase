  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <%@ page import="java.sql.*"%>
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<html>
<head>
  <meta charset=UTF-8>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="resources/jsFiles/jquery-1.10.1.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src="scripts.js"></script>
<style>
input[type="search"]{
display:block;width:100%;height:calc(1.5em + .75rem + 2px);padding:.375rem .75rem;
font-size:1rem;font-weight:400;line-height:1.5;color:#495057;background-color:#fff;
background-clip:padding-box;border:1px solid #ced4da;border-radius:.25rem;
transition:border-color .15s ease-in-out,box-shadow .15s ease-in-out
}
</style>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="jquery.table-filter.min.js"></script>
    <script type="text/javascript">
      $(function () {
        $("table").addTableFilter();
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
       <th class="th-sm"><small><center><b>SZEROKOŚĆ MATERIAŁU</b></center></small>
      </th>
      <th class="th-sm"><small><center><b>RODZAJ SUROWCA</b></center></small>
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
  <tbody>
    <c:forEach var="Zlecenia" items="${result }"><tr><td><center>${Zlecenia.id}</center></td><td><center>${Zlecenia.numerKlienta}</center></td><td><center>${Zlecenia.numerEtykiety}</center></td><td><center><small>${Zlecenia.nazwaEtykiety}</small></center></td><td><center>${Zlecenia.nazwaKlienta}</center></td><td><center><fmt:formatNumber type="number"  pattern="###,###" value="${Zlecenia.iloscEtykiet}" /></center></td><td><center>${Zlecenia.priorytet}</center></td><td><center>${Zlecenia.dataWysylki}</center></td><td><center>${Zlecenia.idWykrojnika}</center></td><td><center>${Zlecenia.szerokoscSurowca}</center></td><td><center>${Zlecenia.rodzajSurowca}</center></td><td><center>${Zlecenia.maszyna}</center></td><td><center>${Zlecenia.gilza}</center></td><td><center>${Zlecenia.wystawil}</center></td><td><center><small>${Zlecenia.kolor1}</small></center></td><td><center><small>${Zlecenia.kolor2}</small></center></td><td><center><small>${Zlecenia.kolor3}</small></center></td><td><center><small>${Zlecenia.kolor4}</small></center></td><td><center><small>${Zlecenia.kolor5}</small></center></td><td><center><small>${Zlecenia.kolor6}</small></center></td><td><center><small>${Zlecenia.kolor7}</small></center></td><td><center><small>${Zlecenia.kolor8}</small></center></td><td><center><form action="delZlecenia" method="post"></center>
<form action="delZlecenia"><button type="submit" name="id" value="${Zlecenia.id}" alt="USUN" class="btn btn-info btn-sm"><i class='fas fa-trash-alt'></i></button>
</form></tr></c:forEach> 
  </tbody>
</table>
</div>


</body>
</html>		