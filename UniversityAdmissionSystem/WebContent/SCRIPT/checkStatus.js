function validateApplicationId(applicationId,errApplicationId)
{
	if(applicationId.value==""){
		if(errApplicationId!=null){
			errApplicationId.innerHTML="ApplicationId cannot be Empty";
			return false;
		}
	}else{
		var regex=/^au[0-9]{7}$/;
		if(!regex.test(applicationId.value)){
			if(errApplicationId!=null){
				errApplicationId.innerHTML="Enter Valid Applicant ID.";
				return false;
			}
		}else{
			if(errApplicationId!=null){
				errApplicationId.innerHTML="";
				return true;
			}
		}
	}
}

function validate(addApplicationForm)
{
	if(!validateApplicationId(addApplicationForm.applicationId, document.getElementById("errApplicationId")))
		return false;
	else
		return true;
}