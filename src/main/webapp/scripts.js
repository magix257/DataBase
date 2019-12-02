
function zmiana()
{
var element = document.getElementById("numerKlienta1").value;
var element2 = document.getElementById("nazwaKlienta1");
var element3 = document.getElementById("nazwaKlienta").options[element-1].value;
element2.value = element3;
	}




//USTAWIENIA KOLORU
function zmianakolor()
{
	for (x = 1; x < 9; x++){
		
	
var kolor = document.getElementById("k"+x+"in").value;
var kolorkoloruj = document.getElementById("k"+x+"out");
var kolorrgb = document.getElementById(kolor).value;
kolorkoloruj.style.backgroundColor="rgb("+kolorrgb+")";
	}
	}
