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
<button class="btn btn-info" type="submit">POKAŻ ZLECENIA</button>
</form>

<form action="addKolory">
<button class="btn btn-danger" type="submit">DODAJ KOLORY</button>
</form>

<form action="addKlienci">
<button class="btn btn-primary" type="submit">DODAJ KLIENTA</button>
</form>



<form action="addSurowce">
<button class="btn btn-success" type="submit">DODAJ SUROWIEC</button>
</form>
</div>

<form action="addZlecenie" name="Dodaj Zlecenie">
<div class="input-group mb-3">

<div class="input-group-prepend">
    <span class="input-group-text">Podaj numer klienta:</span></div>
    <input list="datalist_numerKlienta" id="numerKlienta1" class="form-control" placeholder="NUMER KLIENTA" name="numerKlienta" onchange="wstawNazweKlienta(this)" >
   

<div class="input-group-prepend">
    <span class="input-group-text">Podaj numer etykiety:</span></div>
   <input type="text" class="form-control" placeholder="NUMER ETYKIETY" id="numerEtykiety" name="numerEtykiety">

<div class="input-group-append">
    <span class="input-group-text">Podaj nazwę etykiety:</span></div>
  <input type="text" class="form-control" placeholder="NAZWA ETYKIETY" id="nazwaEtykiety" name="nazwaEtykiety">
  </div>


<div class="input-group mb-3">
  
<div class="input-group-append">
    <span class="input-group-text">Podaj nazwę klienta:</span></div>
   <input list="nazwaKlienta" id="nazwaKlienta1" class="form-control" placeholder="NAZWA KLIENTA" name="nazwaKlienta"><datalist id="nazwaKlienta"><c:forEach var="Klienci" items="${result2 }"><option value="${Klienci.nazwaKlienta}"></c:forEach></datalist>
  
  

<div class="input-group-append">
    <span class="input-group-text">Podaj ilość etykiet:</span></div>
 <input type="text" class="form-control" placeholder="ILOSC ETYKIET" id="iloscEtykiet" name="iloscEtykiet">
  </div>


<div class="input-group mb-3">
  
<div class="input-group-append">
    <span class="input-group-text">Podaj priorytet:</span>
  </div><input type="text" class="form-control" placeholder="[1-PILNE ... 10-BEZ POŚPIECHU]" id="priorytet" name="priorytet">

<div class="input-group-append">
    <span class="input-group-text">Podaj datę wysyłki:</span>
  </div><input type="date" class="form-control" placeholder="DATA WYSYŁKI" id="dataWysylki" name="dataWysylki">
  </div>


<div class="input-group mb-3">
  
<div class="input-group-append">
    <span class="input-group-text">Podaj id Wykrojnika:</span>
  </div><input list="datalist_wykrojniki" class="form-control" onchange="szerokosc_papieru(this)" id="idWykrojnika" placeholder="ID WYKROJNIKA" name="idWykrojnika">

<div class="input-group-append">
    <span class="input-group-text">Podaj Szerokość Materiału:</span>
  </div><input type="text" class="form-control" placeholder="SZEROKOSC MATERIALU" id="szerokoscSurowca" name="szerokoscSurowca">
   </div>
 
 
 <div class="input-group mb-3">
 
 <div class="input-group-append">
    <span class="input-group-text">Podaj rodzaj Surowca:</span>
  </div><input list="datalist_surowce" class="form-control" id="rSurowca" placeholder="RODZAJ SUROWCA" name="rodzajSurowca">

<div class="input-group-append">
    <span class="input-group-text">Podaj numer Maszyny:</span>
  </div><input type="text" class="form-control" placeholder="MASZYNA" id="maszyna" name="maszyna">
   </div>
   
   
<div class="input-group mb-3">
 
 <div class="input-group-append">
    <span class="input-group-text">Podaj gilze:</span>
  </div><input type="text" class="form-control" placeholder="GILZA" id="gilza" name="gilza">

<div class="input-group-append">
    <span class="input-group-text">Wystawił:</span>
  </div><input type="text" class="form-control" placeholder="DANE HANDLOWCA" id="maszyna" name="wystawil">
   </div>

 
<div class="form-group">
<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 1:</span>
  </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k1" placeholder="KOLOR1" name="kolor1">
   <input class="form-control" disabled="disabled" id="k1out">

 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 2:</span>
  </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k2" placeholder="KOLOR2" name="kolor2">
   <input class="form-control" disabled="disabled" id="k2out">
  </div>


<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 3:</span>
  </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k3" placeholder="KOLOR3" name="kolor3">
   <input class="form-control" disabled="disabled" id="k3out">

 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 4:</span>
  </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k4" placeholder="KOLOR4" name="kolor4">
   <input class="form-control" disabled="disabled" id="k4out">
  </div>



<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 5:</span>
  </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k5" placeholder="KOLOR5" name="kolor5">
   <input class="form-control" disabled="disabled" id="k5out">
 
 
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 6:</span>
  </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k6" placeholder="KOLOR6" name="kolor6">
   <input class="form-control" disabled="disabled" id="k6out">
  </div>



<div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 7:</span>
  </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k7" placeholder="KOLOR7" name="kolor7">
   <input class="form-control" disabled="disabled" id="k7out">

<div class="input-group-append">
    <span class="input-group-text">Podaj kolor 8:</span>
  </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k8" placeholder="KOLOR8" name="kolor8">
   <input class="form-control" disabled="disabled" id="k8out">
  </div>
<datalist id="datalist_kolory"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}" data-rgb="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></c:forEach></datalist>
<datalist id="datalist_numerKlienta" ><c:forEach var="Klienci" items="${result2 }"><option value="${Klienci.numerKlienta}" data-nazwa_klienta="${Klienci.nazwaKlienta}"></c:forEach></datalist>
<datalist id="datalist_wykrojniki"><c:forEach var="Wykrojniki" items="${result3 }"><option value="${Wykrojniki.id}" data-szerokosc_papieru="${Wykrojniki.szerokoscPapieru}"></c:forEach></datalist>
<datalist id="datalist_surowce"><c:forEach var="Surowce" items="${result4 }"><option value="${Surowce.nazwaSurowca}"></c:forEach></datalist>


</div>
<div class="input-group mb-3">

    <button class="btn btn-primary btn-block" type="submit">DODAJ ZLECENIE DO BAZY</button>

  </div>
</form>
</div>
</body>
</html>		