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
	document.getElementById("mainId").innerHTML="<iframe class='main-gen' scrolling='no' frameborder='0' name='iframeId' src='"+src+"'></iframe>";    
}

function loadmain()
{
	document.getElementById("mainId").innerHTML="<iframe class='main' scrolling='no' frameborder='0' name='iframeId' src='Resources/General/Mission.html'></iframe>";
}

function loadform()
{
	document.getElementById("mainId").innerHTML="<iframe class='maincontentform' scrolling='no' frameborder='0' name='iframeId' src='Resources/General/ApplicationForm.html'></iframe>";
}

function loadNotifications()
{

	document.getElementById("mainId").innerHTML="<iframe class='main-gen' scrolling='no' frameborder='0' name='iframeId' src='Resources/Notifications.html'></iframe>";
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
    var nav = document.getElementById("maincontent");
    nav.innerHTML = showContent(a[0].getElementsByTagName("Programs")[0],courseId);
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

                html += "<h3 align='center'>" + programName + "</h3>";
                html += "<p align='justify'>" + Description + "</p>";

               
            }
        }
    }
    return html;
}