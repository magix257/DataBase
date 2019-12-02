//NAZWA KLIENTA DYNAMICZNIE GENEROWANA PO NUMERZE
function zmiana()
{
var element = document.getElementById("numerKlienta1").value;
var element2 = document.getElementById("nazwaKlienta1");
var element3 = document.getElementById("nazwaKlienta").options[element-1].value;
element2.value = element3;
	}


//PODGLĄD KOLORU W OKIENKU
function pokazKolor(input_obj){
	
	const datalist_kolory = document.getElementById("datalist_kolory");
	
	let rgb='';
	
	let out_color = document.getElementById(input_obj.id+"out");
	
	console.log(datalist_kolory.id);
	
	for (let index=0;index<datalist_kolory.options.length;index++) {
		if (datalist_kolory.options[index].value === input_obj.value) {
			
			rgb = datalist_kolory.options[index].getAttribute('data-rgb');
			
			break;
		}
	}
	
	//console.log(input_obj_id);
	
	out_color.style.backgroundColor = "rgb("+rgb+")";
	
	return;
}

function szerokosc_papieru(input_obj){
	
	const datalist_wykrojniki = document.getElementById("datalist_wykrojniki");
	
	let szerokosc_papieru='';
	
	let szerokoscSurowca = document.getElementById("szerokoscSurowca");
	
	console.log(datalist_kolory.id);
	
	for (let index=0;index<datalist_wykrojniki.options.length;index++) {
		if (datalist_wykrojniki.options[index].value === input_obj.value) {
			
			szerokosc_papieru = datalist_wykrojniki.options[index].getAttribute('data-szerokosc_papieru');
			
			break;
		}
	}
	
	//console.log(input_obj_id);
	
	szerokoscSurowca.value = szerokosc_papieru;
	
	return;
}

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

