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
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="scripts.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
<img src="logoetiko.svg" width="447.029" height="95.04" />
</div>

 <div class="container-fluid">
 
<div class="input-group mb-3">
<div class="input-group-prepend">
<form action="getMetrics">
<button class="btn btn-info" type="submit">WCZYTAJ METRYKE</button>
</form>
</div>
</div>

<form action="saveMetrics" name="saveMetrics">

<div class="input-group mb-3">
<div class="input-group-prepend">
    <span class="input-group-text">Podaj numer klienta:</span></div>
    <input list="datalist_numerKlienta" id="numerKlienta1" class="form-control" placeholder="NUMER KLIENTA" name="numerKlienta" onchange="wstawNazweKlienta(this)" >
<div class="input-group-prepend">
    <span class="input-group-text">Podaj numer etykiety:</span></div>
    <input type="text" class="form-control" placeholder="NUMER ETYKIETY" id="numerEtykiety" name="numerEtykiety">
</div>

<div class="input-group mb-3">
<div class="input-group-append">
<span class="input-group-text">Podaj id Wykrojnika:</span>
</div><input list="datalist_wykrojniki" class="form-control" onchange="szerokosc_papieru(this)" id="idWykrojnika" placeholder="ID WYKROJNIKA" name="idWykrojnika">
<div class="input-group-append">
<span class="input-group-text">Podaj nawinięcie:</span></div>
<input list="datalist_nawiniecie" class="form-control" placeholder="NAWINIĘCIE" id="nawiniecie" name="nawiniecie">
</div>


<div class="form-group">

<div class="input-group mb-3">
 <div class="input-group-prepend">
   <span class="input-group-text"><input type="checkbox" name="kolor1swiec"> &nbsp&nbsp Kolor 1:</span>
   </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k1" placeholder="KOLOR1" name="kolor1">
   <input class="form-control" disabled="disabled" id="k1out">
   <input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k1z"  placeholder="KOLOR_ZALEWANY"  name="zalewany1">
   <input class="form-control" disabled="disabled" id="k1zout">
   <input type="text" class="form-control" id="wspolne1"  placeholder="WSPOLNE_Z"  name="wspolne1">
   <input list="datalist_katy" class="form-control" id="kat1"  placeholder="KĄT_KOLOR_1"  name="kat1">
   <input list="datalist_liniatura" class="form-control" id="liniatura1"  placeholder="LINIATURA"  name="liniatura1">
</div>

<div class="input-group mb-3">
 <div class="input-group-prepend">
   <span class="input-group-text"><input type="checkbox" name="kolor2swiec"> &nbsp&nbsp Kolor 2:</span>
   </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k2" placeholder="KOLOR2" name="kolor2">
   <input class="form-control" disabled="disabled" id="k2out">
   <input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k2z"  placeholder="KOLOR_ZALEWANY"  name="zalewany2">
   <input class="form-control" disabled="disabled" id="k2zout">
   <input type="text" class="form-control" id="wspolne2"  placeholder="WSPOLNE_Z"  name="wspolne2">
   <input list="datalist_katy" class="form-control" id="kat2"  placeholder="KĄT_KOLOR_2"  name="kat2">
   <input list="datalist_liniatura" class="form-control" id="liniatura2"  placeholder="LINIATURA"  name="liniatura2">
</div>

<div class="input-group mb-3">
 <div class="input-group-prepend">
   <span class="input-group-text"><input type="checkbox" name="kolor3swiec"> &nbsp&nbsp Kolor 3:</span>
   </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k3" placeholder="KOLOR3" name="kolor3">
   <input class="form-control" disabled="disabled" id="k3out">
   <input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k3z"  placeholder="KOLOR_ZALEWANY"  name="zalewany3">
   <input class="form-control" disabled="disabled" id="k3zout">
   <input type="text" class="form-control" id="wspolne3"  placeholder="WSPOLNE_Z"  name="wspolne3">
   <input list="datalist_katy" class="form-control" id="kat3"  placeholder="KĄT_KOLOR_3"  name="kat3">
   <input list="datalist_liniatura" class="form-control" id="liniatura3"  placeholder="LINIATURA"  name="liniatura3">
</div>

<div class="input-group mb-3">
 <div class="input-group-prepend">
   <span class="input-group-text"><input type="checkbox" name="kolor4swiec"> &nbsp&nbsp Kolor 4:</span>
   </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k4" placeholder="KOLOR4" name="kolor4">
   <input class="form-control" disabled="disabled" id="k4out">
   <input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k4z"  placeholder="KOLOR_ZALEWANY"  name="zalewany4">
   <input class="form-control" disabled="disabled" id="k4zout">
   <input type="text" class="form-control" id="wspolne4"  placeholder="WSPOLNE_Z"  name="wspolne4">
   <input list="datalist_katy" class="form-control" id="kat4"  placeholder="KĄT_KOLOR_4"  name="kat4">
   <input list="datalist_liniatura" class="form-control" id="liniatura4"  placeholder="LINIATURA"  name="liniatura4">
</div>

<div class="input-group mb-3">
 <div class="input-group-prepend">
   <span class="input-group-text"><input type="checkbox" name="kolor5swiec"> &nbsp&nbsp Kolor 5:</span>
   </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k5" placeholder="KOLOR5" name="kolor5">
   <input class="form-control" disabled="disabled" id="k5out">
   <input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k5z"  placeholder="KOLOR_ZALEWANY"  name="zalewany5">
   <input class="form-control" disabled="disabled" id="k5zout">
   <input type="text" class="form-control" id="wspolne5"  placeholder="WSPOLNE_Z"  name="wspolne5">
   <input list="datalist_katy" class="form-control" id="kat5"  placeholder="KĄT_KOLOR_5"  name="kat5">
   <input list="datalist_liniatura" class="form-control" id="liniatura5"  placeholder="LINIATURA"  name="liniatura5">
</div>

<div class="input-group mb-3">
 <div class="input-group-prepend">
   <span class="input-group-text"><input type="checkbox" name="kolor6swiec"> &nbsp&nbsp Kolor 6:</span>
   </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k6" placeholder="KOLOR6" name="kolor6">
   <input class="form-control" disabled="disabled" id="k6out">
   <input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k6z"  placeholder="KOLOR_ZALEWANY"  name="zalewany6">
   <input class="form-control" disabled="disabled" id="k6zout">
   <input type="text" class="form-control" id="wspolne6"  placeholder="WSPOLNE_Z"  name="wspolne6">
   <input list="datalist_katy" class="form-control" id="kat6"  placeholder="KĄT_KOLOR_6"  name="kat6">
   <input list="datalist_liniatura" class="form-control" id="liniatura6"  placeholder="LINIATURA"  name="liniatura6">
</div>

<div class="input-group mb-3">
 <div class="input-group-prepend">
   <span class="input-group-text"><input type="checkbox" name="kolor7swiec"> &nbsp&nbsp Kolor 7:</span>
   </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k7" placeholder="KOLOR7" name="kolor7">
   <input class="form-control" disabled="disabled" id="k7out">
   <input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k7z"  placeholder="KOLOR_ZALEWANY"  name="zalewany7">
   <input class="form-control" disabled="disabled" id="k7zout">
   <input type="text" class="form-control" id="wspolne7"  placeholder="WSPOLNE_Z"  name="wspolne7">
   <input list="datalist_katy" class="form-control" id="kat7"  placeholder="KĄT_KOLOR_7"  name="kat7">
   <input list="datalist_liniatura" class="form-control" id="liniatura7"  placeholder="LINIATURA"  name="liniatura7">
</div>

<div class="input-group mb-3">
 <div class="input-group-prepend">
   <span class="input-group-text"><input type="checkbox" name="kolor8swiec"> &nbsp&nbsp Kolor 8:</span>
   </div><input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k8" placeholder="KOLOR8" name="kolor8">
   <input class="form-control" disabled="disabled" id="k8out">
   <input list="datalist_kolory" class="form-control" onchange="pokazKolor(this)" id="k8z"  placeholder="KOLOR_ZALEWANY"  name="zalewany8">
   <input class="form-control" disabled="disabled" id="k8zout">
   <input type="text" class="form-control" id="wspolne8"  placeholder="WSPOLNE_Z"  name="wspolne8">
   <input list="datalist_katy" class="form-control" id="kat8"  placeholder="KĄT_KOLOR_8"  name="kat8">
   <input list="datalist_liniatura" class="form-control" id="liniatura8"  placeholder="LINIATURA"  name="liniatura8">
</div>

<div class="input-group mb-3">
  <div class="input-group-append">
    <span class="input-group-text">Podaj liniature:</span></div>
<input value="150" class="form-control" id="liniatura"  name="liniatura">
</div>

<div class="input-group mb-3">
  <div class="input-group-append">
    <span class="input-group-text">Podaj nazwę etykiety:</span></div>
  <input type="text" class="form-control" placeholder="NAZWA ETYKIETY" id="nazwaEtykiety" name="nazwaEtykiety">
  </div>

<div class="input-group mb-3">
<div class="input-group-append">
    <span class="input-group-text">Podaj nazwę klienta:</span></div>
   <input list="nazwaKlienta" id="nazwaKlienta1" class="form-control" placeholder="NAZWA KLIENTA" name="nazwaKlienta">
 </div> 

<div class="input-group mb-3">
<div class="input-group-append">
    <span class="input-group-text">Świecił Grafik:</span>
  </div><input list="datalist_graficy" class="form-control" placeholder="ŚWIECIŁ GRAFIK" id="grafik" name="grafik">
</div>

<div class="input-group mb-3">
  <div class="input-group-append">
    <span class="input-group-text">Data Produkcji:</span>
  </div><input type="date" class="form-control" placeholder="DATA WYSYŁKI" id="dataWysylki" name="dataWysylki">
</div>

<div class="input-group mb-3">
  <div class="input-group-append">
    <span class="input-group-text">UWAGI:</span>
  </div><textarea class="form-control" rows="3" id="uwagi" name="uwagi"></textarea>
</div>
</div>

<datalist id="datalist_kolory"><c:forEach var="Kolory" items="${result }"><option value="${Kolory.nazwaKoloru}" data-rgb="${Kolory.r}, ${Kolory.g}, ${Kolory.b}"></c:forEach></datalist>
<datalist id="datalist_numerKlienta" ><c:forEach var="Klienci" items="${result2 }"><option value="${Klienci.numerKlienta}" data-nazwa_klienta="${Klienci.nazwaKlienta}"></c:forEach></datalist>
<datalist id="datalist_wykrojniki"><c:forEach var="Wykrojniki" items="${result3 }"><option value="${Wykrojniki.id}" data-szerokosc_papieru="${Wykrojniki.szerokoscPapieru}"></c:forEach></datalist>
<datalist id="datalist_surowce"><c:forEach var="Surowce" items="${result4 }"><option value="${Surowce.nazwaSurowca}"></c:forEach></datalist>
<datalist id="datalist_katy"><option value=">0"><option value=">7.5"><option value=">22.5"><option value=">37.5"><option value=">45"><option value=">52.5"><option value=">67.5"><option value=">82.5"></datalist>
<datalist id="datalist_nawiniecie"><option value="1"><option value="2"><option value="3"><option value="4"><option value="5"><option value="6"><option value="7"><option value="8"></datalist>
<datalist id="datalist_liniatura"><option value="120"><option value="133"><option value="150"><option value="175"><option value="200"></datalist>
<datalist id="datalist_graficy"><option value="KM"><option value="KP"><option value="SB"></datalist>
<datalist id="nazwaKlienta"><c:forEach var="Klienci" items="${result2 }"><option value="${Klienci.nazwaKlienta}"></c:forEach></datalist>


<div class="input-group mb-3">
<button class="btn btn-primary btn-block" type="submit">ZAPISZ METRYKE</button>
</div>

</form>
</div>
</body>
</html>		