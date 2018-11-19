function orderOnline(){
    /*Could have made two arrays, one for each set of id's and completed a for-loop for these*/
    let myArray=[];
    myArray[0] = parseInt(document.getElementById("bcPrice").innerHTML,10) * document.getElementById("bcNum").value;
    myArray[1] = parseInt(document.getElementById("fcPrice").innerHTML,10) * document.getElementById("fcNum").value;
    myArray[2] = parseInt(document.getElementById("ftmbPrice").innerHTML,10) * document.getElementById("ftmbNum").value;
    myArray[3] = parseInt(document.getElementById("fcsbPrice").innerHTML,10) * document.getElementById("fcsbNum").value;
    myArray[4] = parseInt(document.getElementById("gjlcPrice").innerHTML,10) * document.getElementById("gjlcNum").value;
    myArray[5] = parseInt(document.getElementById("psmsPrice").innerHTML,10) * document.getElementById("psmsNum").value;
    myArray[6] = parseInt(document.getElementById("vsPrice").innerHTML,10) * document.getElementById("vsNum").value;
    myArray[7] = parseInt(document.getElementById("ss10Price").innerHTML,10) * document.getElementById("ss10Num").value;
    myArray[8] = parseInt(document.getElementById("ss16Price").innerHTML,10) * document.getElementById("ss16Num").value;
    myArray[9] = parseInt(document.getElementById("pf6Price").innerHTML,10) * document.getElementById("pf6Num").value;
    myArray[10] = parseInt(document.getElementById("fm8Price").innerHTML,10) * document.getElementById("fm8Num").value;
    myArray[11] = parseInt(document.getElementById("fm12Price").innerHTML,10) * document.getElementById("fm12Num").value;
    myArray[12] = parseInt(document.getElementById("cb24Price").innerHTML,10) * document.getElementById("cb24Num").value;
    myArray[13] = parseInt(document.getElementById("del10Price").innerHTML,10) * document.getElementById("del10Num").value;
    myArray[14] = parseInt(document.getElementById("del18Price").innerHTML,10) * document.getElementById("del18Num").value;
    myArray[15] = parseInt(document.getElementById("ph24Price").innerHTML,10) * document.getElementById("ph24Num").value;
    myArray[16] = parseInt(document.getElementById("ph36Price").innerHTML,10) * document.getElementById("ph36Num").value;
    myArray[17] = parseInt(document.getElementById("tb24Price").innerHTML,10) * document.getElementById("tb24Num").value;
    myArray[18] = parseInt(document.getElementById("tb36Price").innerHTML,10) * document.getElementById("tb36Num").value;
    myArray[19] = parseInt(document.getElementById("rib16Price").innerHTML,10) * document.getElementById("rib16Num").value;
    myArray[20] = parseInt(document.getElementById("th48Price").innerHTML,10) * document.getElementById("th48Num").value;
    myArray[21] = parseInt(document.getElementById("sicbPrice").innerHTML,10) * document.getElementById("sicbNum").value;
    myArray[22] = parseInt(document.getElementById("ddccPrice").innerHTML,10) * document.getElementById("ddccNum").value;
    myArray[23] = parseInt(document.getElementById("klpPrice").innerHTML,10) * document.getElementById("klpNum").value;
    myArray[24] = parseInt(document.getElementById("tropsPrice").innerHTML,10) * document.getElementById("tropsNum").value;
    myArray[25] = parseInt(document.getElementById("aaPrice").innerHTML,10) * document.getElementById("aaNum").value;
    myArray[26] = parseInt(document.getElementById("pmPrice").innerHTML,10) * document.getElementById("pmNum").value;
    myArray[27] = parseInt(document.getElementById("ofPrice").innerHTML,10) * document.getElementById("ofNum").value;
    myArray[28] = parseInt(document.getElementById("cosmoPrice").innerHTML,10) * document.getElementById("cosmoNum").value;
    myArray[29] = parseInt(document.getElementById("tgfPrice").innerHTML,10) * document.getElementById("tgfNum").value;
    myArray[30] = parseInt(document.getElementById("sdmPrice").innerHTML,10) * document.getElementById("sdmNum").value;
    myArray[31] = parseInt(document.getElementById("lccPrice").innerHTML,10) * document.getElementById("lccNum").value;
    return myArray;
}

function calculatePrice(myArray){
    let sum = 0;
    for(i=0;i<myArray.length;i++){
        sum += myArray[i];
    }
    sum *= 1.06;
    sum = sum.toFixed(2);
    console.log(sum);
    let totalPrice = "$" + sum;
    return totalPrice;
}

var couponArray = [
    "20Off.png", "30Off.png", "40Off.png", "50Off.png", "BOGO.png", "FreeApp.png", "FreeDess.png"
];
var count = 0;
function generateACoupon(){
    var ranNum = document.getElementById("couponNum").value;
    var image;
    if(count == 0){
        if(ranNum>=1 && ranNum<=100){
            var num = Math.floor(Math.random()*couponArray.length);
            document.generateImage.src = couponArray[num];
            var image = couponArray[num];
            document.getElementById("errorMessage").innerText = "";
            count = 1;
        }else{
            document.getElementById("errorMessage").innerText = "Invalid Input";
        }
    }else{
        document.generateImage.src = "NiceTry.jpg";
    }
}

var tampaWeather = {};
var iconNumber;

//send a GET request to this endpoint to get Tampa weather
let weatherApiUrl = 'http://api.openweathermap.org/data/2.5/weather?q=Tampa,us&units=imperial&APPID=859d47520ac736ebe8bbce1fef74269c';
function getTampaWeather() {
    fetch(weatherApiUrl).then((response) => {return response.json();
    }).then((data) => {
        tampaWeather = data;
        var patioStatus;
        console.log(data);
        console.log('the temperature is: '+tampaWeather.weather[0].icon+' degrees');
        iconNumber=tampaWeather.weather[0].icon;
        if(iconNumber == "01d" || iconNumber == "01n"){
            document.weatherImage.src = "sunny.png";
            patioStatus = "OPEN";
        }else if(iconNumber == "02d" || iconNumber == "02n"){
            document.weatherImage.src = "partlycloudy.png";
            patioStatus = "OPEN";
        }else if(iconNumber == "03d" || iconNumber == "03n" || iconNumber == "04d" || iconNumber == "04n"){
            document.weatherImage.src = "clouds.png";
            patioStatus = "OPEN";
        }else if(iconNumber == "09d" || iconNumber == "09n"|| iconNumber == "10d" || iconNumber == "10n"){
            document.weatherImage.src = "rain.png";
            patioStatus = "CLOSED";
        }else if(iconNumber == "11d" || iconNumber == "11n"){
            document.weatherImage.src = "thunder.png";
            patioStatus = "CLOSED";
        }
        document.getElementById("temp").innerHTML = tampaWeather.main.temp;
        if(tampaWeather.main.temp <= 65){
            patioStatus = "CLOSED";
        }
        document.getElementById("patio").innerHTML = patioStatus;
    });
}

function removeElement(elementId){
    var element = document.getElementById(elementId);
    element.parentNode.removeChild(element);
}
function reservationConfirmation(){
    document.getElementById("confirmationMessage").innerHTML = document.getElementById("resFirstName").value + " " + document.getElementById("resLastName").value
        + " Your Reservation Has Been Confirmed For " + document.getElementById("guestNumber").value + " Guests On " + document.getElementById("reservationDate").value
        + " At " + document.getElementById("resTime").value;
    removeElement("reservationFormInfo");
    removeElement("reservationFormDetails");
    removeElement("reservationButton");
    removeElement("largerParties");
    removeElement("resBottomSection");

}
window.onload(getTampaWeather());