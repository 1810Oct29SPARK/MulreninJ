let state = {
    joke: ''
};

const apiUrl = 'https://icanhazdadjoke.com/';

//long form of function getJokeWithFetch(){...}

let getJokeWithPromise = function(){
    fetch(apiUrl, {method: "GET", headers:{"Accept":"application/json"}})//headers is metadata about request
    //define behavior for when the response returns
    .then((response) => {
        //return unwrapped promise object for the next chaining operation
        return response.json(); //json data that comes back
    })
    //utilize unwrapped promise as a javascript object
    .then((data) => {
        console.log(data);
        state.joke = data.joke;
        updateContent();
    })
    //what if theres a problem
    .catch( (error) => {
        alert('oh no :(');
        console.log(error);
    }

    );
}

let updateContent = function() {
    console.log(state);
    //select joke
    const jokeElement = document.getElementById('joke-field');
    jokeElement.innerText = state.joke;//spits out on page instead of console.
}

document.getElementById('new-joke-button').addEventListener('click', getJokeWithFetch);