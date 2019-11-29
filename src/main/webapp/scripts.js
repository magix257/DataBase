
function zmiana()
{
var element = document.getElementById("numerKlienta1").value;
var element2 = document.getElementById("nazwaKlienta1");
var element3 = document.getElementById("nazwaKlienta").options[element-1].value;
element2.value = element3;
	}





function zmianakolor1()
{
	//USTAWIENIA DLA KOLORU NR1
var kolor1 = document.getElementById("k1in").value;
var kolor1koloruj = document.getElementById("k1out");
var kolor1rgb = document.getElementById(kolor1).value;
kolor1koloruj.style.backgroundColor="rgb("+kolor1rgb+")";
	}

//USTAWIENIA DLA KOLORU NR2
function zmianakolor2()
{
var kolor2 = document.getElementById("k2in").value;
var kolor2koloruj = document.getElementById("k2out");
var kolor2rgb = document.getElementById(kolor2).value;
kolor2koloruj.style.backgroundColor="rgb("+kolor2rgb+")";
	}