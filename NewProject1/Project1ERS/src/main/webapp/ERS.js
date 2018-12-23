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
			for(let k = 0; k < user.Reimbursements.length; k++){
				if(user.Reimbursements[k].status == "pending"){
				var tr = document.createElement("tr");
				var tddesc = document.createElement("td");
				var tdamnt = document.createElement("td");
				var tdstat = document.createElement("td");
				var tdres = document.createElement("td");
				tddesc.appendChild(document.createTextNode(user.Reimbursements[k].reimburseName));
				tdamnt.appendChild(document.createTextNode(user.Reimbursements[k].amount));
				tdstat.appendChild(document.createTextNode(user.Reimbursements[k].reimburseStatus));
				tdres.appendChild(document.createTextNode(user.Reimbursements[k].resolvedBy));
				tr.appendChild(tddesc);
				tr.appendChild(tdamnt);
				tr.appendChild(tdstat);
				tr.appendChild(tdres);
				document.getElementById("reimbursePendingTable").appendChild(tr);
				}
			}
			for(let l= 0; l < user.AllReimbursements.length; l++){
				var tr = document.createElement("tr");
				var tddesc = document.createElement("td");
				var tdamnt = document.createElement("td");
				var tdstat = document.createElement("td");
				var tdfirst = document.createElement("td");
				var tdlast = document.createElement("td");
				tddesc.appendChild(document.createTextNode(user.AllReimbursements[l].reimburseName));
				tdamnt.appendChild(document.createTextNode(user.AllReimbursements[l].amount));
				tdstat.appendChild(document.createTextNode(user.AllReimbursements[l].reimburseStatus));
				tdfirst.appendChild(document.createTextNode(user.AllReimbursementManagers[l].firstName));
				tdlast.appendChild(document.createTextNode(user.AllReimbursementManagers[l].lastName));
				tr.appendChild(tddesc);
				tr.appendChild(tdamnt);
				tr.appendChild(tdstat);
				tr.appendChild(tdfirst);
				tr.appendChild(tdlast);
				document.getElementById("allReimbursementsTable").appendChild(tr);
			}
			for(let m= 0; m < user.AllEmployees.length; m++){
				var tr = document.createElement("tr");
				var tddesc = document.createElement("td");
				var tdamnt = document.createElement("td");
				var tdfirst = document.createElement("td");
				var tdlast = document.createElement("td");
				tddesc.appendChild(document.createTextNode(user.AllEmployees[m].firstName));
				tdamnt.appendChild(document.createTextNode(user.AllEmployees[m].lastName));
				tdfirst.appendChild(document.createTextNode(user.AllManagers[m].firstName));
				tdlast.appendChild(document.createTextNode(user.AllManagers[m].lastName));
				tr.appendChild(tddesc);
				tr.appendChild(tdamnt);
				tr.appendChild(tdfirst);
				tr.appendChild(tdlast);
				document.getElementById("allEmployeesTable").appendChild(tr);
			}
			for(let n= 0; n < user.PendingEmployees.length; n++){
				var tr = document.createElement("tr");
				var tdfirst = document.createElement("td");
				var tdlast = document.createElement("td");
				var tddesc = document.createElement("td");
				var tdamnt = document.createElement("td");
				var tdstat = document.createElement("td");
				tdfirst.appendChild(document.createTextNode(user.PendingEmployees[n].firstName));
				tdlast.appendChild(document.createTextNode(user.PendingEmployees[n].lastName));
				tddesc.appendChild(document.createTextNode(user.PendingReimbursements[n].reimburseName));
				tdamnt.appendChild(document.createTextNode(user.PendingReimbursements[n].amount));
				tdstat.appendChild(document.createTextNode(user.PendingReimbursements[n].reimburseStatus));
				tr.appendChild(tdfirst);
				tr.appendChild(tdlast);
				tr.appendChild(tddesc);
				tr.appendChild(tdamnt);
				tr.appendChild(tdstat);
				document.getElementById("reimbursePendingTable").appendChild(tr);
			}
		}
	});
	
}