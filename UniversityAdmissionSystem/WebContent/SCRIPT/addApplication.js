/*function loadPage()
{
	dojo.event.connect(dojo.widget.byId("dateOfBirth"), "onBlur",
    "validateDateOfBirth");

}*/

function validateFullName(fullName,errFullName)
{
	if(fullName.value==""){
		if(errFullName!=null){
			errFullName.innerHTML="Name cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(fullName.value)){
			if(errFullName!=null){
				errFullName.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errFullName!=null){
				errFullName.innerHTML="";
				return true;
			}
		}
	}
}

function validateDateOfBirth(dateOfBirth,errDateOfBirth)
{
		
	if(dateOfBirth.value==""){
		if(errDateOfBirth!=null){
			errDateOfBirth.innerHTML="Enter date of Birth";
			return false;
		}
	}else{
		dateOfBirth = document.getElementsByName("dojo.dateOfBirth")[0];
		var regex=/^(([0-9])|([0-2][0-9])|([3][0-1]))\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\-19[7-9][0-9]$/;
		if(!regex.test(dateOfBirth.value)){
			if(errDateOfBirth!=null){
				errDateOfBirth.innerHTML="Enter date in 'dd-mmm-yyyy' format and Between 1970 to 1999";
				return false;
			}
		}else{
			if(errDateOfBirth!=null){
				errDateOfBirth.innerHTML="";
				return true;
			}
		}
	}
}

function validateHighestQualification(highestQualification,errHighestQualification)
{
	if(highestQualification.value==""){
		if(errHighestQualification!=null){
			errHighestQualification.innerHTML="Select your highest Qualification" ;
			return false;
		}
	}else{
		if(errHighestQualification!=null){
			errHighestQualification.innerHTML="";
			return true;
		}
	}
}

function validateMarks(marks,errMarks)
{
	if(marks.value==""){
		if(errMarks!=null){
			errMarks.innerHTML="Marks field cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[0-9]{0,2}(\.[0-9]{0,2})?$/;
		if(!regex.test(marks.value)){
			if(errMarks!=null){
				errMarks.innerHTML="Only digits are Accepted";
				return false;
			}
		}else{
			if(errMarks!=null){
				errMarks.innerHTML="";
				return true;
			}
		}
	}
}

function validateGoals(goals,errGoals)
{
	if(goals.value==""){
		if(errGoals!=null){
			errGoals.innerHTML="Please enter your goals.";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z0-9]+$/;
		if(!regex.test(goals.value)){
			if(errGoals!=null){
				errGoals.innerHTML="Only AlphaNumerics Accepted";
				return false;
			}
		}else{
			if(errGoals!=null){
				errGoals.innerHTML="";
				return true;
			}
		}
	}
}

function validateEmail(email,errEmail)
{
	if(email.value=="")
	{
		if(errEmail!=null){
			errEmail.innerHTML="Email field cannot be Empty.";
			return false;
		}
	}
	else
	{
		var regex = /^[a-z|A-Z]+@[a-z\.A-Z]+$/;
	    if (!regex.test(email.value))
	    {
	        if (errEmail!= null)
	        	errEmail.innerHTML = "Enter valid Email.";
	        return false;
	    }
	    else {
	        if (errEmail!= null)
	        	errEmail.innerHTML = "";
	        return true;
	    }
	}
}

function validate(addApplicationForm)
{
	if(!validateFullName(addApplicationForm.fullName, document.getElementById("errFullName")))
		return false;
	if(!validateDateOfBirth(addApplicationForm.dateOfBirth, document.getElementById("errDateOfBirth")))
		return false;
	if(!validateHighestQualification(addApplicationForm.highestQualification, document.getElementById("errHighestQualification")))
		return false;
	if(!validateGoals(addApplicationForm.goals, document.getElementById("errGoals")))
		return false;
	if(!validateMarks(addApplicationForm.marks_obtained, document.getElementById("errMarks")))
		return false;
	if(!validateEmail(addApplicationForm.email_id, document.getElementById("errEmail")))
		return false;
	else
		return true;
	
}