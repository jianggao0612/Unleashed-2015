/**
 * Created by Gao on 4/07/15.
 */
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/test"
    }).then(function(data) {
        $('.test-longitude').append(data.x);
        $('.test-latitude').append(data.y);
    });
});