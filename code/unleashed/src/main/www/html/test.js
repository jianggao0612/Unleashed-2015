/**
 * Created by Gao on 4/07/15.
 */
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/test",
        method: "GET",
        data: {
            "latitude": 3.3,
            "longitude": 8.4
        },
        dataType: 'json'
    }).then(function(data) {
        console.log(data);
        $('.test-longitude').append(data.x);
        $('.test-latitude').append(data.y);
    });
});