var nombreApp =( function (){
	
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
	
    var  getAirpotsbyName= function(){
		var city = $('#ciudad').val();
        airpotsFinderClient.getAirpotsByName(maperPonts,city);
    }
      
    var maperPonts = function(airpots){
		//elimina puntos
        $("#keywords tbody tr").remove();
        for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(null);
        }

		//
        airpots=JSON.parse(airpots);
        markers = [];
        bounds = new google.maps.LatLngBounds();
 
		//recorrer cada elemento
        airpots.map(function(airport){
			var contenedor = "<tr><td class=\"lalign\">"+airport.code+"</td><td>"+airport.name+"</td><td>"+airport.city+"</td><td>"+airport.countryCode+"</td></tr>";
            var location = airport.location;
                  
            markers.push(
                new google.maps.Marker({
                    position: {lat: location.latitude, lng: location.longitude},
                    map: map,
                    animation: google.maps.Animation.DROP
                })
            );
 
            bounds.extend({lat: location.latitude, lng: location.longitude});
 
			//agregar a tabla
            $("#keywords tbody").append(contenedor);

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
        .then(plotMarkers);
    }

	var bounds;
    var markers = [];
	
	return {
		maperPonts: maperPonts,
		getAirpotsbyName: getAirpotsbyName,
        initMap: initMap
	};
})();