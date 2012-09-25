
function validateProgramName(programName,errProgramName)
{
	if(programName.value==""){
		if(errProgramName!=null){
			errProgramName.innerHTML="Program Name cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(programName.value)){
			if(errProgramName!=null){
				errProgramName.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errProgramName!=null){
				errProgramName.innerHTML="";
				return true;
			}
		}
	}
}


function validateApplicantEligibilty(applicantEligibility,errApplicantEligibilty)
{
	if(applicantEligibility.value==""){
		if(errApplicantEligibilty!=null){
			errApplicantEligibilty.innerHTML="Applicant Eligibility cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z]+$/;
		if(!regex.test(applicantEligibility.value)){
			if(errApplicantEligibilty!=null){
				errApplicantEligibilty.innerHTML="Enter Valid Eligibility.";
				return false;
			}
		}else{
			if(errApplicantEligibilty!=null){
				errApplicantEligibilty.innerHTML="";
				return true;
			}
		}
	}
}

function validateDuration(duration,errDuration)
{
	if(duration.value==""){
		if(errDuration!=null){
			errDuration.innerHTML="Duration cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[0-9]{1}$/;
		if(!regex.test(duration.value)){
			if(errDuration!=null){
				errDuration.innerHTML="Enter Valid Duration.";
				return false;
			}
		}else{
			if(errDuration!=null){
				errDuration.innerHTML="";
				return true;
			}
		}
	}
}

/*function validateDuration(duration,errDuration)
{
	if(duration.value==""){
		if(errDuration!=null){
			errDuration.innerHTML="Duration field cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[0-9]{1}$/;
		if(!regex.test(duration.value)){
			if(errDuration!=null){
				errDuration.innerHTML="Only Digits are Accepted.";
				return false;
			}
		}else{
			if(errDuration!=null){
				errDuration.innerHTML="";
				return true;
			}
		}
	}
}*/

function validateDegreeCertificateOffered(degreeCertificateOffered,errDegreeCertificateOffered)
{
	if(degreeCertificateOffered.value==""){
		if(errDegreeCertificateOffered!=null){
			errDegreeCertificateOffered.innerHTML="Degree Certificate Offered cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[a-zA-Z]+$/;
		if(!regex.test(degreeCertificateOffered.value)){
			if(errDegreeCertificateOffered!=null){
				errDegreeCertificateOffered.innerHTML="Only Alphabets Accepted";
				return false;
			}
		}else{
			if(errDegreeCertificateOffered!=null){
				errDegreeCertificateOffered.innerHTML="";
				return true;
			}
		}
	}
}

function validateDescription(description,errDescription)
{
	if(description.value==""){
		if(errDescription!=null){
			errDescription.innerHTML="Description cannot be Empty";
			return false;
		}
	}else{
		var regex=/^[\sa-zA-Z0-9]+$/;
		if(!regex.test(description.value)){
			if(errDescription!=null){
				errDescription.innerHTML="Only AlphaNumeric Data Accepted";
				return false;
			}
		}else{
			if(errDescription!=null){
				errDescription.innerHTML="";
				return true;
			}
		}
	}
}

function validate(EditOfferProgramForm)
{
	if(!validateProgramName(EditOfferProgramForm.programName, document.getElementById("errProgramName")))
		return false;
	if(!validateApplicantEligibilty(EditOfferProgramForm.applicantEligibility, document.getElementById("errApplicantEligibilty")))
		return false;
	if(!validateDuration(EditOfferProgramForm.duration, document.getElementById("errDuration")))
		return false;
	if(!validateDegreeCertificateOffered(EditOfferProgramForm.degreeCertificateOffered, document.getElementById("errDegreeCertificateOffered")))
		return false;
	if(!validateDescription(EditOfferProgramForm.description, document.getElementById("errDescription")))
		return false;
	else
		return true;
}