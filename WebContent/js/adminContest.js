$(document).ready(function () {
    $(".update").click(function () {
        var teamer = $(this).parent().parent().children('td').eq(1).text();
        $("#teamer").val(teamer);
    });
});