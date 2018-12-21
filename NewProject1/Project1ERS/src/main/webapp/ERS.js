/**
 * 
 */
let user = {};
window.onload = function(){
	populateUser();
}

function populateUser(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/Project1ERS/session").then(function(response){
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned
		if(data.session === null){
			window.location = "http://localhost:7001/Project1ERS/login";
		}else{
			//define behavior for user is returned
			user = data;
			console.log(user);
			document.getElementById("firstlast").innerText = user.User.firstName + " " + user.User.lastName;
			document.getElementById("firstlasttop").innerText = user.User.firstName + " " + user.User.lastName;
			document.getElementById("title").innerText = user.User.title;
			document.getElementById("age").innerText = user.User.age;
			document.getElementById("phonenumber").innerText = user.User.phoneNumber;
			document.getElementById("address").innerText = user.User.address;
			for(let i = 0; i < user.Employees.length;i++){
				var ul = document.getElementById("managedemployees");
				var li = document.createElement("li");
				li.appendChild(document.createTextNode(user.Employees[i].firstName + " " + user.Employees[i].lastName + " - " + user.Employees[i].title));
				document.getElementById("managedemployees").appendChild(li);
			}
			for(let j = 0; j < user.Reimbursements.length; j++){
				var tr = document.createElement("tr");
				var tddesc = document.createElement("td");
				var tdamnt = document.createElement("td");
				var tdstat = document.createElement("td");
				var tdres = document.createElement("td");
				tddesc.appendChild(document.createTextNode(user.Reimbursements[j].reimburseName));
				tdamnt.appendChild(document.createTextNode(user.Reimbursements[j].amount));
				tdstat.appendChild(document.createTextNode(user.Reimbursements[j].reimburseStatus));
				tdres.appendChild(document.createTextNode(user.Reimbursements[j].resolvedBy));
				tr.appendChild(tddesc);
				tr.appendChild(tdamnt);
				tr.appendChild(tdstat);
				tr.appendChild(tdres);
				document.getElementById("reimburseTable").appendChild(tr);
			}
		}
	});
	
}