
function readJson(url, variable) {
 
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open('GET',url + variable, true)
    console.log(url + variable)
    xmlhttp.onload = function() {
        if(this.status == 200){
            
            var json = JSON.parse(this.responseText)
            console.log(json)
        }
    }


xmlhttp.send();
    }

var  ur = "http://localhost:8080/device/"
    readJson(ur,1)