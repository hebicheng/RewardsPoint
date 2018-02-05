$(document).ready(function () {
    $(".update_l2_modify").click(function () {
        var username = $(this).parent().parent().parent().parent().parent().children('td').eq(1).text();
        var name = $(this).parent().parent().parent().parent().parent().children('td').eq(2).text();
        var grade = $(this).parent().parent().parent().parent().parent().children('td').eq(3).text();
        var sicnuoj = $(this).parent().parent().parent().parent().parent().children('td').eq(4).text();
        var codeforces = $(this).parent().parent().parent().parent().parent().children('td').eq(5).text();
        var atcoder = $(this).parent().parent().parent().parent().parent().children('td').eq(6).text();
        $("#username").val(username);
        $("#name").val(name); 
        $("#grade").val(grade); 
        $("#sicnuoj").val(sicnuoj);
        $("#codeforces").val(codeforces);
        $("#atcoder").val(atcoder);
       
    });
    $(".update_l2_delete").click(function () {
        var username = $(this).parent().parent().parent().parent().parent().children('td').eq(1).text();
        $("#username").val(username);
    });
    $(".update_l1").click(function () {
        var username = $(this).parent().parent().parent().children('td').eq(1).text();
        $("#username").val(username);
    });
});