CoronavirusClient= (function(){
    return {
		getAllCountries: function(callback){
            jQuery.ajax({
                url: "Coronavirus/",
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Error en la solicitud");
                } ,
                async: true
            });
        }
    };
})();