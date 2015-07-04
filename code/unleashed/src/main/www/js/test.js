/**
 * Created by Gao on 4/07/15.
 */
$(document).ready(function() {
    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
        $('.greeting-longitude').append(data.longitude);
        $('.greeting-latitude').append(data.latitude);
    });
});