var map = {};
var latLng = new google.maps.LatLng(-34.92866, 138.59863);

var myStyles = [{
    featureType: "poi",
    elementType: "labels",
    stylers: [{
        visibility: "off"
            }]
    }];

function initialize() {
    var mapOptions = {
        center: {
            lat: -34.92866,
            lng: 138.59863
        },
        zoom: 18,
        scaleControl: false,
        zoomControl: false,
        scrollwheel: false,
        styles: myStyles,
        disableDefaultUI: true
    };

    map = new google.maps.Map(document.getElementById('map-canvas'),
        mapOptions);

    var marker = new google.maps.Marker({
        position: latLng,
        map: map,
        icon: "/res/person_green.png",
    });

    google.maps.event.addListener(map, 'click', function (event) {
        moveMarker(event.latLng);
        map.panTo(event.latLng);
    });

    function moveMarker(pos) {
        marker.setPosition(pos)
    }

}

google.maps.event.addDomListener(window, 'load', initialize);