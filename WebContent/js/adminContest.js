$(document).ready(function () {
    $(".update").click(function () {
        var username = $(this).parent().parent().children('td').eq(1).text();
        $("#username").val(username);
        var name = $(this).parent().parent().children('td').eq(2).text();
        $("#name").val(name);
    });
});