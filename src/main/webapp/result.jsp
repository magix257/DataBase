  <%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2" isELIgnored="false"%>
<!DOCTYPE html>
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
<ul class="breadcrumb">
    <li class="breadcrumb-item"><a href="http://localhost:8080/">Home</a></li>
    <li class="breadcrumb-item active">Result</li>
  </ul>

 <div class="container-fluid">

<script>
var $rows = $('#tabela tr');
$('#szukaj_osoby').keyup(function() {
	    
	    var val = '^(?=.*\\b' + $.trim($(this).val()).split(/\s+/).join('\\b)(?=.*\\b') + ').*$',
	        reg = RegExp(val, 'i'),
	        text;
	    
	    $rows.show().filter(function() {
	        text = $(this).text().replace(/\s+/g, ' ');
	        return !reg.test(text);
	    }).hide();
	});

</script>


<input type="text" id="szukaj_osoby" placeholder="wpisz imiê, nazwisko lub zawód">
<table id="tabela">
    <tr>
        <td>imie</td>
        <td>nazwisko</td>
        <td>zawod</td>
    </tr>
    
    <tr>
        <td>Marian</td>
        <td>Kononowicz</td>
        <td>polityk</td>
    </tr>


Rezultat to:${result}
</div>
</body>
</html>