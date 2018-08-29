var modal = document.getElementById('myModal');
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];

//window.onclick = function(event) {
//    if (event.target == modal) {
//        modal.style.display = "none";
//    }
//};
function openActivity(evt, activity) {
	
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(activity).style.display = "block";
    evt.currentTarget.className += " active";
    
    if(activity == 'projection'){
    	var yearSelected = document.getElementById('inputYear');
    	var year = yearSelected.options[yearSelected.selectedIndex].value;

    	var levelSelected = document.getElementById('inputLevel');
    	var level = levelSelected.options[levelSelected.selectedIndex].value;
    	if(year != 'Select')
    		alert(year+"  "+level);
    	else
    		alert("Please select a year!");
    		
    
    }
}
var d = new Date().getFullYear();
var year=["1901"];
for(var i=1902; i<=d; i++){
	year.push(i);
}
for(var i = 0; i<year.length; i++){
	$("#inputYear").append('<option>' + year[i] + '</option>');
}
var levels = ['State', 'District'];
for(var i=0; i<levels.length;i++){
	$("#inputLevel").append('<option>' + levels[i] + '</option>');
}