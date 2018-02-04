$(document).ready(function() {
	$(".personContest").hide();
	$("#cType").change(function(e) {
		e.preventDefault();
		if ($(this).val() == 0) {
			$(".trainContest").show();
			$(".personContest").hide();
		} else {
			$(".trainContest").hide();
			$(".personContest").show();
		}
	});
	$("#cTime").datetimepicker({
		format : 'yyyy-mm-dd',//显示格式
		todayHighlight : 1,//今天高亮
		minView : "month",//设置只显示到月份
		startView : 2,
		forceParse : 0,
		showMeridian : 1,
		autoclose : 1//选择后自动关闭
	});
});