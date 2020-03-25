CoronavirusClient= (function(){
    return {
		getAllCountries: function(callback){
            jQuery.ajax({
                url: "Coronavirus/",
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Error en la consulta");
                } ,
                async: true
            });
        },
		pintar: function(callback,pais){
            jQuery.ajax({
                url: "Coronavirus/"+pais,
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Error en la consulta");
                } ,
                async: true
            });
        },
		ciu: function(callback,pais){
            jQuery.ajax({
                url: "Coronavirus/byPais/"+pais,
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Error en la consulta");
                } ,
                async: true
            });
        }
    };
})();