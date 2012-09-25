var className = null;
var upDown = "up";
var slider = null;
var sliderHeight = null;
var originalHeight = 0;
var sliderIntervalId = 0;
var slideSpeed = 10;
var hold = false;


function loadpage(src) 
{
	var mainID = document.getElementById("mainId");
	mainID.innerHTML="<iframe class='main-gen' scrolling='no' frameborder='0' name='iframeId' id='iframeId' src='"+src+"'></iframe>";
	//autoResize("iframeId","mainId");
	
	var rightsidebar = document.getElementById("rightSideBar");
	rightsidebar.style.display = 'none';
	
}

function loadApplication(src) {
	var rightsidebar = window.parent.document.getElementById("rightSideBar");
	rightsidebar.style.display = 'none';
	
	var mainID = window.parent.document.getElementById("mainId");
	//mainID = document.parentNode;
	mainID.innerHTML="<iframe class='main-form' scrolling='no' frameborder='0' name='iframeId' id='iframeId' src='"+src+"'></iframe>";
	//autoResize("iframeId","mainId");
	
	
}

function loadmain()
{
	document.getElementById("mainId").innerHTML="<iframe class='main' scrolling='no' frameborder='0' name='iframeId' id='iframeId' src='Resources/General/Mission.jsp'></iframe>";
	loadXML();
	
	/*var headID = document.getElementsByTagName("head")[0];         

	var newScript = document.createElement('script');
	newScript.type = 'text/javascript';
	newScript.src = 'yourpath';
	headID.appendChild(newScript);*/
}

function loadform()
{
	document.getElementById("mainId").innerHTML="<iframe class='maincontentform' scrolling='no' frameborder='0' name='iframeId' src='Resources/General/ApplicationForm.html'></iframe>";
}

function loadNotifications()
{

	document.getElementById("mainId").innerHTML="<iframe class='main-gen' scrolling='no' frameborder='0' name='iframeId' src='Resources/Notifications.html'></iframe>";
}

function autoResize(id,parentID){
    var newheight;
    var newwidth;

    if(document.getElementById){
        newheight=document.getElementById(id).contentWindow.document.body.scrollHeight;
        newwidth=document.getElementById(id).contentWindow.document.body.scrollWidth;
    }

    document.getElementById(parentID).height= (newheight) + "px";
    document.getElementById(parentID).width= (newwidth) + "px";
}

function slideCollege(element) {
    element = element.parentNode.getElementsByTagName("DIV")[0];
    className = "college";
    sliderHeight = element.offsetHeight;
    if (sliderHeight == 0)
        Slide(element, "down");
    else
        Slide(element, upDown);
}

function slideDegree(element) {
    element = element.parentNode.getElementsByTagName("DIV")[0];
    className = "degree";
    sliderHeight = element.offsetHeight;
    if (sliderHeight == 0)
        Slide(element, "down");
    else
        Slide(element, "up");
}

function Slide(element, upDown) {

    slider = element;
    var nodeList = slider.childNodes;
    originalHeight = 0;
    for (var i = 0; i < nodeList.length; i++) {
        if (nodeList.item(i).nodeName != "DIV" && nodeList.item(i).nodeName != "SPAN")
            continue;
        originalHeight += nodeList.item(i).offsetHeight;
    }

    if (upDown == "down") {
        sliderIntervalId = setInterval('slideDown()', 30);
    }
    else if (upDown == "up") {
        if (!hold)
            originalHeight = 0;
        sliderIntervalId = setInterval('slideUp()', 30);
    }
}

function slideUp() {

    if (sliderHeight <= originalHeight) {
        //sliding = false;
        sliderHeight = originalHeight;
        slider.style.height = originalHeight + 'px';
        clearInterval(sliderIntervalId);
        if (className == "degree") {
            var parent = slider.parentNode.parentNode;
            upDown = "up";
            hold = true;
            slideCollege(parent, upDown);
        }
        else {
            upDown = "up";
            hold = false;
        }
    }
    else {
        sliderHeight -= slideSpeed;
        if (sliderHeight < 0) {
            sliderHeight = 0;
        }
        slider.style.height = sliderHeight + 'px';
    }
}


function slideDown() {

    if (sliderHeight >= originalHeight) {
        //        sliding = false;
        sliderHeight = originalHeight;
        slider.style.height = originalHeight + 'px';
        clearInterval(sliderIntervalId);
        if (className == "degree") {
            var parent = slider.parentNode.parentNode;
            upDown = "down";
            slideCollege(parent, upDown);
            hold = false;
        } else {
            upDown = "up";
            hold = false;
        }
    }
    else {
        sliderHeight += slideSpeed;
        if (sliderHeight > originalHeight) {
            sliderHeight = originalHeight;
        }
        slider.style.height = sliderHeight + 'px';
    }
}

function loadXML() {
    var xmlDoc;
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("GET", "UASNavigation.xml", false);
    xmlhttp.send();
    xmlDoc = xmlhttp.responseXML;
    a = xmlDoc.childNodes;
    var nav = document.getElementById("nav");
    nav.innerHTML = buildNavigation(a[0].getElementsByTagName("Colleges")[0]);
    
}

function loadContent(courseId) {
    var xmlDoc;
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("GET", "UASContent.xml", false);
    xmlhttp.send();
    xmlDoc = xmlhttp.responseXML;
    a = xmlDoc.childNodes;
    //var nav = document.getElementById("maincontent");
    
    var rightsidebar = document.getElementById("rightSideBar");
	rightsidebar.style.display = 'block';
    
    var iframe = document.getElementById("iframeId");
    var frameDoc = iframe.contentDocument || iframe.contentWindow.document;
    var nav = frameDoc.getElementById("maincontent");
    if(nav==null){
    	document.getElementById("mainId").innerHTML="<iframe class='main' scrolling='no' frameborder='0' name='iframeId' id='iframeId' src='Resources/General/Mission.jsp'></iframe>";
    	var iframe = document.getElementById("iframeId");
        var frameDoc = iframe.contentDocument || iframe.contentWindow.document;
        var nav = frameDoc.getElementById("maincontent");
    }
    nav.innerHTML = showContent(a[0].getElementsByTagName("Programs")[0],courseId);
   
}


function buildNavigation(root) {

    var html = "";
    
    for (var i = 0; i < root.childNodes.length; i++) {
        var clg = root.childNodes[i];
        if (clg.nodeName == "College") {
            var clgName = clg.getElementsByTagName("Name")[0].childNodes[0].nodeValue;
            html += "<div class='college-nav'>";
            html += "<span onclick='slideCollege(this)'>" + clgName + "</span>"
            var degrees = clg.getElementsByTagName("Degrees")[0];
			html += "<div class='degree-nav'>"
            for (var j = 0; j < degrees.childNodes.length; j++) {
                var degree = degrees.childNodes[j];
                if (degree.nodeName == "Degree") {
                    var degreeName = degree.getElementsByTagName("Name")[0].childNodes[0].nodeValue;
					html += "<div>"
                    html += "<span onclick='slideDegree(this)'>" + degreeName + "</span>"
                    html += "<div class='course-nav'>"
                    var courses = degree.getElementsByTagName("Courses")[0];
                    for (var k = 0; k < courses.childNodes.length; k++) {
                        var course = courses.childNodes[k];
                        if (course.nodeName == "Course") {
                            var courseName = course.getElementsByTagName("Name")[0].childNodes[0].nodeValue;
                            var courseId = course.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                            html += "<span onclick='loadContent("+courseId+")'>" + courseName + "</span> <br/>";
                        }
                    }
                    html += "</div>";
					html += "</div>";
                    
                }
            }
			html += "</div>";
            html += "</div>";
        }
    }
    return html;
}


function showContent(root,courseId) {
    var html = "";

    for (var i = 0; i < root.childNodes.length; i++) {
        var program = root.childNodes[i];
        if (program.nodeName == "Program") {
            programId = program.getAttribute('id');
            if (courseId == programId) {
                var programName = program.getElementsByTagName("Name")[0].childNodes[0].nodeValue;
                var DegreeName = program.getElementsByTagName("Degree")[0].childNodes[0].nodeValue;
                var CollegeName = program.getElementsByTagName("College")[0].childNodes[0].nodeValue;
                var Description = program.getElementsByTagName("Description")[0].childNodes[0].nodeValue;

                //html+="<script src='../../SCRIPT/UAS.js' type='text/javascript'></script>";
                
                html += "<h3 align='center'>" + programName + "</h3>";
                html += "<p align='justify'>" + Description + "</p>";
                
                //html += "<span onclick=loadApplication('Resources/Applicant/addApplication.jsp?college=hello')> Check Application Status </span>";
                
                html+= "<h2 align='center'  onclick='loadApplication(&quot;Resources/Applicant/addApplication.jsp?college=";
                html+= CollegeName+"&degree="+DegreeName+"&program="+programName+"&programId="+programId+"&quot;)'> Apply </h2>";
               
                //html += "<input type='button' onclick=hi('hello');></input>";
            }
        }
    }
    return html;
}

//mac


var count;
var counter = 0;
function enableDOI(appId, cmb) {
	//cmb.parentNode.parentNode.nextSibling.nextSibling.firstChild.style.display = 'block';
	var val = cmb.value;

	if (val == 'accepted') {
		counter++;
		var thd = document.getElementById('doi');
		thd.style.visibility = "visible";
		var dt = document.getElementById(appId);
		dt.style.visibility = "visible";

		//	count = cnt;
		dojo.event.connect(dojo.widget.byId("date"), "onValueChanged",
				"modify");

	} else {

		counter--;
		if (counter <= 0) {
			var thd = document.getElementById('doi');
			thd.style.visibility = "hidden";
			counter = 0;
		}
		var dt = document.getElementById(appId);
		dt.style.visibility = "hidden";
	}
}

function modify() {
	var vDate = dojo.widget.byId("date");

	var date = vDate.getValue().toString();
	date = date.substring(0, 10);

	var ips = getElementsByClassName("dateTime");
	for ( var i = 0; i < ips.length; i++) {
		var aDate = dojo.widget.byId(ips[i].parentNode.id);
		aDate.setValue(vDate.getValue());
	}
}

function getElementsByClassName(className) {

	var hasClassName = new RegExp("(?:^|\\s)" + className + "(?:$|\\s)");
	var allElements = document.getElementsByTagName("*");
	var results = [];

	var element;
	for ( var i = 0; (element = allElements[i]) != null; i++) {
		var elementClass = element.className;
		if (elementClass && elementClass.indexOf(className) != -1
				&& hasClassName.test(elementClass))
			results.push(element);
	}

	return results;
}

function changeStatus(allStatus) {
	var val = allStatus.value;
	var selects = document.getElementsByTagName("select");
	for ( var i = 0; i < selects.length; i++) {
		if (allStatus == selects[i])
			continue;
		selects[i].value = val;
		//select[i].fireEvent("onchange");
		if ("fireEvent" in selects[i])
			selects[i].fireEvent("onchange");
		else {
			var evt = document.createEvent("HTMLEvents");
			evt.initEvent("change", false, true);
			selects[i].dispatchEvent(evt);
		}
	}
}

function filter(txtFilter,filterForm){

	if (event.keyCode == 13 && event.shiftKey == 0) {
		document.getElementById("filter").click();
  } else {
        if (event.key != undefined)
        	txtFilter.innerText += event.key;
  }
	
	
}


//slide Show

function slideSwitch() {
    var $active = $('#slideshow IMG.active');

    if ($active.length == 0) $active = $('#slideshow IMG:last');

    var $next = $active.next().length ? $active.next()
        : $('#slideshow IMG:first');

    $active.addClass('last-active');

    $next.css({ opacity: 0.0 })
        .addClass('active')
        .animate({ opacity: 1.0 }, 1000, function () {
            $active.removeClass('active last-active');
        });
}

$(function () {
    setInterval("slideSwitch()", 3000);
});

