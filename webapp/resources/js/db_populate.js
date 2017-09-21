var COUNTS = {
    human : 20,
    gameSystem : 20,
    universe : 20,
    personas : 10
};

var BASE_URI = 'api/';

var Human = function(id){
    return {
        nick : "User " + (id +1),
        email : "user." + (id +1) +".test@mail.com",
        password : "password"
    };
};

$(document).ready(function(){
    // Creating requested amount of Humans,
    for(var h = 0; h < COUNTS.human; h++){
        var human = new Human(h);

        $.ajax({
            type : 'POST',
            url : BASE_URI + '/human',
            data : { entity : JSON.stringify(human)},
            succes : console.log(response),
            dataType : "application/json;charset=UTF-8"
        });
    }
});