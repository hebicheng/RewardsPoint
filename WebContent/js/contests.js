$(document).ready(function () {
    $(".personContest").hide();
    $("#cType").change(function (e) { 
        e.preventDefault();
        if($(this).val() == 0) {
            $(".trainContest").show();
            $(".personContest").hide();
        } else {
            $(".trainContest").hide();
            $(".personContest").show();
        }
    });
});