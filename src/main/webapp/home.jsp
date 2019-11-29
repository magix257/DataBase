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


<ul class="breadcrumb ">
    <li class="breadcrumb-item active">Home</li>
  </ul>

 <div class="container-fluid">
 <div class="input-group mb-3">

<form action="getZlecenia">
<button class="btn btn-info" type="submit">POKA¯ ZLECENIA</button>
</form>

<form action="addKolory">
<button class="btn btn-danger" type="submit">DODAJ KOLORY</button>
</form>

<form action="addKlienci">
<button class="btn btn-primary" type="submit">DODAJ KLIENTA</button>
</form>
</div>

<form action="addZlecenie" name="Dodaj Zlecenie">
<div class="input-group mb-3">

<div class="input-group-prepend">
    <span class="input-group-text">Podaj numer klienta:</span></div>
    <input list="numerKlienta" id="numerKlienta1" class="form-control" placeholder="NUMER KLIENTA" name="numerKlienta" onchange="zmiana()" ><datalist id="numerKlienta" ><c:forEach var="Klienci" items="${result2 }"><option value="${Klienci.numerKlienta}"></c:forEach></datalist>
   

<div class="input-group-prepend">
    <span class="input-group-text">Podaj numer etykiety:</span></div>
   <input type="text" class="form-control" placeholder="NUMER ETYKIETY" id="numerEtykiety" name="numerEtykiety">

<div class="input-group-append">
    <span class="input-group-text">Podaj nazwê etykiety:</span></div>
  <input type="text" class="form-control" placeholder="NAZWA ETYKIETY" id="nazwaEtykiety" name="nazwaEtykiety">
  </div>

<div class="input-group mb-3">
  
<div class="input-group-append">
    <span class="input-group-text">Podaj nazwê klienta:</span></div>
   <input list="nazwaKlienta" id="nazwaKlienta1" class="form-control" placeholder="NAZWA KLIENTA" name="nazwaKlienta"><datalist id="nazwaKlienta"><c:forEach var="Klienci" items="${result2 }"><option value="${Klienci.nazwaKlienta}"></c:forEach></datalist>
  
  <script type="text/javascript">
function zmiana()
{
var element = document.getElementById("numerKlienta1").value;
var element2 = document.getElementById("nazwaKlienta1");
var element3 = document.getElementById("nazwaKlienta").options[element-1].value;
element2.value = element3;
//alert(element3)
//.options[element.selectedIndex].value

//element2.selectedIndex.value = element.value;
	}
  
  </script>
  

<div class="input-group-append">
    <span class="input-group-text">Podaj ilo¶æ etykiet:</span></div>
 <input type="text" class="form-control" placeholder="ILOSC ETYKIET" id="iloscEtykiet" name="iloscEtykiet">
  </div>


<div class="input-group mb-3">
  
<div class="input-group-append">
    <span class="input-group-text">Podaj priorytet:</span>
  </div><input type="text" class="form-control" placeholder="[1-PILNE ... 10-BEZ PO¦PIECHU]" id="priorytet" name="priorytet">

<div class="input-group-append">
    <span class="input-group-text">Podaj datê wysy³ki:</span>
  </div><input type="date" class="form-control" placeholder="DATA WYSY£KI" id="dataWysylki" name="dataWysylki">
  </div>


<div class="input-group mb-3">
  
<div class="input-group-append">
    <span class="input-group-text">Podaj id Wykrojnika:</span>
  </div><input type="text" class="form-control" placeholder="ID WYKROJNIKA" id="idWykrojnika" name="idWykrojnika">

<div class="input-group-append">
    <span class="input-group-text">Podaj Szeroko¶æ Materia³u:</span>
  </div><input type="text" class="form-control" placeholder="SZEROKOSC MATERIALU" id="szerokoscSurowca" name="szerokoscSurowca">
   </div>
 
 
 <div class="input-group mb-3">
 
 <div class="input-group-append">
    <span class="input-group-text">Podaj rodzaj Surowca:</span>
  </div><input type="text" class="form-control" placeholder="RODZAJ SUROWCA" id="rodzajSurowca" name="rodzajSurowca">

<div class="input-group-append">
    <span class="input-group-text">Podaj numer Maszyny:</span>
  </div><input type="text" class="form-control" placeholder="MASZYNA" id="maszyna" name="maszyna">
   </div>
   
<div class="input-group mb-3">
 
 <div class="input-group-append">
    <span class="input-group-text">Podaj gilze:</span>
  </div><input type="text" class="form-control" placeholder="GILZA" id="gilza" name="gilza">

<div class="input-group-append">
    <span class="input-group-text">Wystawi³:</span>
  </div><input type="text" class="form-control" placeholder="DANE HANDLOWCA" id="maszyna" name="wystawil">
   </div>

 
<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 1:</span>
  </div><input list="k1" class="form-control" onchange="zmianakolor1()" id="k1in" padding: 1px;" placeholder="KOLOR1" name="kolor1"><datalist id="k1"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
 <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
  <script type="text/javascript">
  
function zmianakolor1()
{
var element = document.getElementById("k1in").value;
var element3 = document.getElementById("k1in");
var element2 = document.getElementById(element).value;
element3.style.backgroundColor="rgb("+element2+")";
	}
  
  </script>
 

 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 2:</span>
  </div><input list="k2" class="form-control" placeholder="KOLOR2" name="kolor2"><datalist id="k2"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}"></c:forEach></datalist>
  
   <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 3:</span>
  </div><input list="k3" class="form-control" placeholder="KOLOR3" name="kolor3"><datalist id="k3"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}"></c:forEach></datalist>

 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 4:</span>
  </div><input list="k4" class="form-control" placeholder="KOLOR4" name="kolor4"><datalist id="k4"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}"></c:forEach></datalist>
   </div>


<div class="input-group mb-3">
 
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 5:</span>
  </div><input list="k5" class="form-control" placeholder="KOLOR5" name="kolor5"><datalist id="k5"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}"></c:forEach></datalist>
  
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 6:</span>
  </div><input list="k6" class="form-control" placeholder="KOLOR6" name="kolor6"><datalist id="k6"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}"></c:forEach></datalist>
  
   <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 7:</span>
  </div><input list="k7" class="form-control" placeholder="KOLOR7" name="kolor7"><datalist id="k7"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}"></c:forEach></datalist>

 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 8:</span>
  </div><input list="k8" class="form-control" placeholder="KOLOR8" name="kolor8"><datalist id="k8"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}"></c:forEach></datalist>
   </div>
<div class="input-group mb-3">

    <button class="btn btn-primary btn-block" type="submit">DODAJ ZLECENIE DO BAZY</button>

  </div>
</form>
</div>
</body>
</html>		