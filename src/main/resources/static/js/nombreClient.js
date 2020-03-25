nombreClient= (function(){
    return {
		getAirpotsByName: function(callback,city){
            jQuery.ajax({
                url: "airpotsfinder/" + city ,
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("No se encontr� el nombre solicitado");
                } ,
                async: true
            });
        }
    };
})();