let state = {
    joke: ''
};


//long form of function getJokeWithFetch(){...}

let getUniversityWithPromise = function(){
    fetch('https://opentdb.com/api.php?amount=10')
    .then(r => r.json())
    .then(response => {
        let myArray=[];
        for(i=0;i<response.length;i++){
            myArray[i]=response.results[i].question;
        }
        console.log(myArray);
      console.log(response.results["0"].question);
    });
}

window.onload(getUniversityWithPromise());