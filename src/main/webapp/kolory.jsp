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

<div class="jumbotron text-center style="margin-bottom:0">
<img src="logoetiko.svg" width="447.029" height="95.04" />
</div>
<ul class="breadcrumb">
    <li class="breadcrumb-item"><a href="http://localhost:8080/">Home</a></li>
    <li class="breadcrumb-item"><a href="http://localhost:8080/addKolory">Dodaj kolory</a></li>
    <li class="breadcrumb-item active">Poka¿ kolory</li>
  </ul>

 <div class="container-fluid">

  

    <br>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%"> 
  <thead>
    <tr>
   
      <th class="th-sm"><small><center><b>NAZWA KOLORU</b></center></small>
      </th>
     
      <th class="th-sm"><small><center><b>PODGL¡D</b></center></small>
      </th>

     </tr>
  </thead>
  <tbody>
    <c:forEach var="Kolory" items="${result }"><tr><td><center>${Kolory.nazwaKoloru}</center></td><td><center><input class="form-control" disabled="disabled" style="background-color:rgb(${Kolory.r}, ${Kolory.g}, ${Kolory.b})"></center></td>
    <td><center><form action="delKolory"></center>
<form action="delKolory"><button type="submit" name="id" value="${Kolory.id}" alt="USUN" class="btn btn-info btn-sm"><i class='fas fa-trash-alt'></i></button>
</form></tr></c:forEach> 
  </tbody>
</table>
</div>


</body>
</html>		