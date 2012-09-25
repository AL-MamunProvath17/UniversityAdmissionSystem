function validateCollegeName(collegeName,errCollegeName)
{
	if(collegeName.value==""){
		if(errCollegeName!=null){
			errCollegeName.innerHTML="College Name cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(collegeName.value)){
			if(errCollegeName!=null){
				errCollegeName.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errCollegeName!=null){
				errCollegeName.innerHTML="";
				return true;
			}
		}
	}
}

function validateStreet(street,errStreet)
{
	if(street.value==""){
		if(errStreet!=null){
			errStreet.innerHTML="Street Name cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(street.value)){
			if(errStreet!=null){
				errStreet.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errStreet!=null){
				errStreet.innerHTML="";
				return true;
			}
		}
	}
}

function validateLandmark(landmark,errLandmark)
{
	if(landmark.value==""){
		if(errLandmark!=null){
			errLandmark.innerHTML="Landmark cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(landmark.value)){
			if(errLandmark!=null){
				errLandmark.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errLandmark!=null){
				errLandmark.innerHTML="";
				return true;
			}
		}
	}
}

function validateCity(city,errCity)
{
	if(city.value==""){
		if(errCity!=null){
			errCity.innerHTML="City Name cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(city.value)){
			if(errCity!=null){
				errCity.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errCity!=null){
				errCity.innerHTML="";
				return true;
			}
		}
	}
}

function validateState(state,errState)
{
	if(state.value==""){
		if(errState!=null){
			errState.innerHTML="State Name cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(state.value)){
			if(errState!=null){
				errState.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errState!=null){
				errState.innerHTML="";
				return true;
			}
		}
	}
}


function validatePincode(pincode,errPincode)
{
	if(pincode.value==""){
		if(errPincode!=null){
			errPincode.innerHTML="Pincode cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[0-9]{6}$/;
		if(!regex.test(pincode.value)){
			if(errPincode!=null){
				errPincode.innerHTML="Pincode must be 6 digits.";
				return false;
			}
		}else{
			if(errPincode!=null){
				errPincode.innerHTML="";
				return true;
			}
		}
	}
}

function validate(EditCollegeForm)
{
	if(!validateCollegeName(EditCollegeForm.collegeName, document.getElementById("errCollegeName")))
		return false;
	if(!validateStreet(EditCollegeForm.street, document.getElementById("errStreet")))
		return false;
	if(!validateLandmark(EditCollegeForm.landmark, document.getElementById("errLandmark")))
		return false;
	if(!validateCity(EditCollegeForm.city,document.getElementById("errCity")))
		return false;
	if(!validateState(EditCollegeForm.state, document.getElementById("errState")))
		return false;
	if(!validatePincode(EditCollegeForm.pincode, document.getElementById("errPincode")))
		return false;
	else
		return true;
}
