function submitForm(form) {
		form.submit();
	}

function setStartValue(id, date) {
	var picker = dojo.widget.byId(id);
	date = date.substring(0, 10);
	//string value
	picker.setValue(date);

}

function isCollegeSelected(selectCollege,errSelectCollege)
{
	if(selectCollege.value==""){
		if(errSelectCollege!=null){
			errSelectCollege.innerHTML="Select College.";
			return false;
		}
	}else{
		if(errSelectCollege!=null){
			errSelectCollege.innerHTML="";
			return true;
		}
	}
}

function isDegreeSelected(selectDegree,errSelectDegree)
{
	if(selectDegree.value==""){
		if(errSelectDegree!=null){
			errSelectDegree.innerHTML="Select Degree.";
			return false;
		}
	}else{
		if(errSelectDegree!=null){
			errSelectDegree.innerHTML="";
			return true;
		}
	}
}

function validate(AddDegreeToCollegeForm)
{
	if(!isCollegeSelected(AddDegreeToCollegeForm.collegeId, document.getElementById("errSelectCollege")))
		return false;
	if(!isDegreeSelected(AddDegreeToCollegeForm.degreeId, document.getElementById("errSelectDegree")))
		return false;
	else
		return true;
}