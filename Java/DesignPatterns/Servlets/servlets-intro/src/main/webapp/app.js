window.onload = function(){

	loadLandingView();
}
/*
 * This function will use AJAX to send a request to out LoadViewServlet, 
 * which will return out landing page partial HTML
 * 
 * We will then use our response (the HTML) as the
 * inner HTML of our View div
 */

function loadLandingView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//Here is where we manipulate our response when we get it.
		if(xhr.readyState == 4){
			console.log("REQUEST RECIEVED");
			if(xhr.status == 200){
				//success				
				$('#view').html(xhr.responseText); // in the html([html here])
				console.log(xhr.responseText);
				$('#login').on('click', loginUser); // no ()
			}
			if(xhr.status > 399){
				//error
				// know that our response will be HTML
			}
		}
	}
	xhr.open("GET", "landing.view");
	xhr.send();
}
function loginUser(){
	var name = $('#username').val();
	var pw = $('#password').val();
	var user = {
			username: name, 
			password: pw
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//get response body and console.log it 
		
		if(xhr.readyState==4 && xhr.status==200){
			console.log("Got the response from login");
			var user = JSON.parse(xhr.responseText);
			console.log(xhr.getAllResponseHeaders());
			if(user == null){
				//not logged in
				console.log("FAILED TO LOGIN");
			}
			else{
				//logged in . do things 
				console.log("ELSE BEFORE LOAD HOME VIEW");
				loadHomeView(user);
				console.log(user);
			}
		}
		
	}
	xhr.open("POST", "login");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(user));
	
}
function loadHomeView(user){
	console.log("LOADING HOME VIEW");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.responseText){
			console.log("Response: "+xhr.responseText);
			$('#view').html(xhr.responseText);
			console.log("changed view");
			$('#name').html(user.username);
			//$('#bio').html(user.bio);
		}
	}
	xhr.open("GET", "homepage.view");
	xhr.send();
}