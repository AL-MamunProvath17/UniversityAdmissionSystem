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

function isProgramSelected(selectProgram,errSelectProgram)
{
	if(selectProgram.value==""){
		if(errSelectProgram!=null){
			errSelectProgram.innerHTML="Select Program.";
			return false;
		}
	}else{
		if(errSelectProgram!=null){
			errSelectProgram.innerHTML="";
			return true;
		}
	}
}

function validateStartDate(startDate,errstartDate)
{
	if(startDate.value==""){
		if(errstartDate!=null){
			errstartDate.innerHTML="Enter date of Birth";
			return false;
		}
	}else{
		startDate = document.getElementsByName("dojo.startDate")[0];
		var regex=/^(([0-9])|([0-2][0-9])|([3][0-1]))\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\-\d{4}$/;
		if(!regex.test(startDate.value)){
			if(errstartDate!=null){
				errstartDate.innerHTML="Enter date in 'dd-mmm-yyyy' format";
				return false;
			}
		}else{
			if(errstartDate!=null){
				errstartDate.innerHTML="";
				return true;
			}
		}
	}
}

function validateEndDate(endDate,errEndDate)
{
	if(endDate.value==""){
		if(errEndDate!=null){
			errEndDate.innerHTML="Enter date of Birth";
			return false;
		}
	}else{
		endDate = document.getElementsByName("dojo.endDate")[0];
		var regex=/^(([0-9])|([0-2][0-9])|([3][0-1]))\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\-\d{4}$/;
		if(!regex.test(endDate.value)){
			if(errEndDate!=null){
				errEndDate.innerHTML="Enter date in 'dd-mmm-yyyy' format";
				return false;
			}
		}else{
			if(errEndDate!=null){
				errEndDate.innerHTML="";
				return true;
			}
		}
	}
}

function validateSessionPerWeek(sessionPerWeek,errsessionPerWeek)
{
	if(sessionPerWeek.value=="")
	{
		if(errsessionPerWeek!=null){
			errsessionPerWeek.innerHTML="Please enter total number of sessions per week.";
			return false;
		}
	}
	else
	{
		var regex = /^[0-9]{1}$/;
	    if (!regex.test(sessionPerWeek.value))
	    {
	        if (errsessionPerWeek!= null)
	        	errsessionPerWeek.innerHTML = "Enter valid sessions per week(1-10).";
	        return false;
	    }
	    else {
	        if (errsessionPerWeek!= null)
	        	errsessionPerWeek.innerHTML = "";
	        return true;
	    }
	}
}

function validate(ScheduleProgramForm)
{
	if(!isCollegeSelected(ScheduleProgramForm.collegeId, document.getElementById("errSelectCollege")))
		return false;
	if(!isDegreeSelected(ScheduleProgramForm.degreeId, document.getElementById("errSelectDegree")))
		return false;
	if(!isDegreeSelected(ScheduleProgramForm.programId, document.getElementById("errSelectProgram")))
		return false;
	if(!validateStartDate(ScheduleProgramForm.startDate,document.getElementById("errStartDate")))
		return false;
	if(!validateEndDate(ScheduleProgramForm.endDate,document.getElementById("errEndDate")))
		return false;
	if(!validateSessionPerWeek(ScheduleProgramForm.sessionPerWeek,document.getElementById("errSessionPerWeek")))
		return false;
	else
		return true;
}