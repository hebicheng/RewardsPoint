$(document).ready(function() {
	$(".cfRating").hide();
	$("#search").click(function () { 
		var user = $("#cfID").val();
//		alert(user);
		$.ajax({  
    	    url: 'http://codeforces.com/api/user.rating',  
    	    data: {
   	    		"handle": user
    	    },  
    	    dataType: "json",  
    	    type: "GET",  
    	    traditional: true,  
    	    success: handleShowRating
    	});  
	});
});

function handleShowRating(data) {
	var json = data["result"];
	$("tbody").children().remove();
	json.forEach(i => {
		var ratingUpdateTimeSeconds = i["ratingUpdateTimeSeconds"];
		var newDate = new Date();
		newDate.setTime(ratingUpdateTimeSeconds * 1000);
		var ratingUpdateTime = newDate.toLocaleDateString();
		$("tbody").prepend('<tr>'+
		'<td>'+i["contestId"]+'</td>'+
		'<td>'+i["contestName"]+'</td>'+
		'<td>'+i["handle"]+'</td>'+
		'<td>'+i["rank"]+'</td>'+
		'<td>'+ratingUpdateTime+'</td>'+
		'<td>'+i["oldRating"]+'</td>'+
		'<td>'+i["newRating"]+'</td>'+
		'</tr>');
	});
	$(".cfRating").show();
}