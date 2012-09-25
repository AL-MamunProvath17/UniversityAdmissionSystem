function isValidDegreeName(degreeName,errDegreeName)
{
	if(degreeName.value==""){
		if(errDegreeName!=null){
			errDegreeName.innerHTML="Degree Name cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(degreeName.value)){
			if(errDegreeName!=null){
				errDegreeName.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errDegreeName!=null){
				errDegreeName.innerHTML="";
				return true;
			}
		}
	}
}

function validate(AddDegreeForm)
{
	if(!isValidDegreeName(AddDegreeForm.degreeName, document.getElementById("errDegreeName")))
		return false;
	else
		return true;
}