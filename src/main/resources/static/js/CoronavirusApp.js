var CoronavirusApp =( function (){
	
	var covid19Stats;
	var lista = [];
	
    document.addEventListener('DOMContentLoaded', function () {
        if (document.querySelectorAll('#map').length > 0) {
          if (document.querySelector('html').lang)
            lang = document.querySelector('html').lang;
          else
            lang = 'en';

          var js_file = document.createElement('script');
          js_file.type = 'text/javascript';
          js_file.src = 'https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&language=' + lang;
          document.getElementsByTagName('head')[0].appendChild(js_file);
        }
    });
        
	var map;
	
    var  getAllCountries= function(){
        CoronavirusClient.getAllCountries(getCountries);
    }
      
    var getCountries = function(countries){
		//elimina puntos
        $("#keywords tbody tr").remove();
		//alert(countries);

		countries=JSON.parse(countries);
		countries = countries.data.covid19Stats;
		
        var lista = countries.map(function(result){
			return {country:result.country, deaths:result.deaths, confirmed:result.confirmed, recovered:result.recovered}
		})
			var contenedor = $("<tr><td class=\"lalign\">"+result.country+"</td><td>"+result.deaths+"</td><td>"+result.confirmed+"</td><td>"+result.recovered+"</td><td><button class='btn btn-primary'>Ver</button></td></tr>");
			contenedor.click(function(){
				pintar(result.country);
			});
			$("#keywords tbody").append(contenedor);
		})
		
		
    }
	
	var pintar = function(pais){
		CoronavirusClient.pintar(maperPonts,pais);
    };
	
	var maperPonts = function(city){
		//elimina puntos
        for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(null);
        }

		//
        city=JSON.parse(city);
        markers = [];
        bounds = new google.maps.LatLngBounds();
 
		//recorrer cada elemento
        city.map(function(city2){
            var latitud = city2.latlng[0];
			var longitud = city2.latlng[1];   
			markers.push(
				new google.maps.Marker({
					position: {lat: latitud, lng: longitud},
					map: map,
					animation: google.maps.Animation.DROP
				})
			);
 
            bounds.extend({lat: latitud, lng: longitud});

		})
        map.fitBounds(bounds);
    }


	
    function initMap(){
		map = new google.maps.Map(document.getElementById('map'), {
			center: {lat: -34.397, lng: -4.0},
			zoom: 8
        });

        fetch('https://raw.githubusercontent.com/jayshields/google-maps-api-template/master/markers.json')
        .then(function(response){return response.json()})
        .then(getAllCountries);
    }

	var bounds;
    var markers = [];
	
	return {
		getAllCountries: getAllCountries,
        initMap: initMap,
		getCountries: getCountries,
		pintar: pintar
	};
})();