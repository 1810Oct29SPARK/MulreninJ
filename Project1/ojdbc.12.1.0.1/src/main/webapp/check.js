/**
 * 
 */
let user = {};
window.onload = function(){
	populateUser();
}

function populateUser(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/ojdbc.12.1.0.1/session").then(function(response){
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned
		if(data.session === null){
			window.location = "http://localhost:7001/SessionMgmtDemo/login";
		}else{
			//define behavior for user is returned
			user = data;
			document.getElementById("username").innerText = "Username: " + user.username;
			document.getElementById("firstname").innerText = "First Name: " + user.firstname;
			document.getElementById("lastname").innerText = "Last Name: " + user.lastname;
			document.getElementById("email").innerText = "Email: " + user.email;
		}
	});
	
}