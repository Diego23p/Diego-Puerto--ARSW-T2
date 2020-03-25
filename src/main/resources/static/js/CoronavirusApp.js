var CoronavirusApp =( function (){
	
	var covid19Stats;
	
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
        for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(null);
        }

		countries=JSON.parse(countries);
		countries = countries.data.covid19Stats;
		markers = [];
        bounds = new google.maps.LatLngBounds();
		
        countries.map(function(result){
			var contenedor = "<tr><td class=\"lalign\">"+result.country+"</td><td>"+result.deaths+"</td><td>"+result.confirmed+"</td><td>"+result.recovered+"</td></tr>";
			$("#keywords tbody").append(contenedor);
		})
		
		
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
		getCountries: getCountries
	};
})();