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

 

 
 
 
 
 
 
<div class="form-group">
<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 1:</span>
  </div><input list="k1" class="form-control" onchange="zmianakolor()" id="k1in" placeholder="KOLOR1" name="kolor1"><datalist id="k1"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
 <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
   <input class="form-control" disabled="disabled" id="k1out">
 
 
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 2:</span>
  </div><input list="k2" class="form-control" onchange="zmianakolor()" id="k2in" placeholder="KOLOR2" name="kolor2"><datalist id="k2"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
   <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
   <input class="form-control" disabled="disabled" id="k2out">
  </div>


<div class="form-group">
<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 3:</span>
  </div><input list="k3" class="form-control" onchange="zmianakolor()" id="k3in" placeholder="KOLOR3" name="kolor3"><datalist id="k3"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
 <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
   <input class="form-control" disabled="disabled" id="k3out">

<div class="input-group-append">
    <span class="input-group-text">Podaj kolor 4:</span>
  </div><input list="k4" class="form-control" onchange="zmianakolor()" id="k4in" placeholder="KOLOR4" name="kolor4"><datalist id="k4"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
   <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
   <input class="form-control" disabled="disabled" id="k4out">
  </div>


<div class="form-group">
<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 5:</span>
  </div><input list="k5" class="form-control" onchange="zmianakolor()" id="k5in" placeholder="KOLOR5" name="kolor5"><datalist id="k5"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
 <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
   <input class="form-control" disabled="disabled" id="k5out">
 
 
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 6:</span>
  </div><input list="k6" class="form-control" onchange="zmianakolor()" id="k6in" placeholder="KOLOR6" name="kolor6"><datalist id="k6"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
   <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
   <input class="form-control" disabled="disabled" id="k6out">
  </div>


<div class="form-group">
<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 7:</span>
  </div><input list="k7" class="form-control" onchange="zmianakolor()" id="k7in" placeholder="KOLOR7" name="kolor7"><datalist id="k7"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
 <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
   <input class="form-control" disabled="disabled" id="k7out">

<div class="input-group-append">
    <span class="input-group-text">Podaj kolor 8:</span>
  </div><input list="k8" class="form-control" onchange="zmianakolor()" id="k8in" placeholder="KOLOR8" name="kolor8"><datalist id="k8"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}">
   <button type="button" name="rgb" id="${Kolory.nazwaKoloru}" value="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></button>
  </c:forEach></datalist>
   <input class="form-control" disabled="disabled" id="k8out">
  </div>


<div class="input-group mb-3">

    <button class="btn btn-primary btn-block" type="submit">DODAJ ZLECENIE DO BAZY</button>

  </div>
</form>
</div>
</body>
</html>		