function validateLoginId(loginId,errLoginId)
{
	if(loginId.value==""){
		if(errLoginId!=null){
			errLoginId.innerHTML="Username cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(loginId.value)){
			if(errLoginId!=null){
				errLoginId.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errLoginId!=null){
				errLoginId.innerHTML="";
				return true;
			}
		}
	}
}


function validatePassword(password,errPassword)
{
	if(password.value==""){
		if(errPassword!=null){
			errPassword.innerHTML="Password cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(password.value)){
			if(errPassword!=null){
				errPassword.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errPassword!=null){
				errPassword.innerHTML="";
				return true;
			}
		}
	}
}

