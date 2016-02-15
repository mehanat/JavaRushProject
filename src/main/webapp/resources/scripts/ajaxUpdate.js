$(document).ready(function(){
    $(".t-user").click(function(e){



        $("#upd-user").slideDown();

        var id=$(e.target).parent().find("td:first-child").html();
        var name=$(e.target).parent().find("td:nth-child(2)").html();
        var age=$(e.target).parent().find("td:nth-child(3)").html();
        if($(e.target).parent().find("td:nth-child(4)").html()=="true") {var isAdmin="true"}
            else{isAdmin="false"}
        var crDate=$(e.target).parent().find("td:nth-child(5)").html();

        $("table #upd-user td:nth-child(1)").html(id);
        $("table #upd-user td:nth-child(2) input").attr("value", name);
        $("table #upd-user td:nth-child(3) input").attr("value", age);
        if($(e.target).parent().find("td:nth-child(4)").html()=="true") {$("table #upd-user td:nth-child(4) input").prop("checked", true);}
            else{$("table #upd-user td:nth-child(4) input").prop("checked", false); }
        $("table #upd-user td:nth-child(5)").html(crDate);





        $("#goUpdate").click(function() {

            name = $("table #upd-user td:nth-child(2) input").val();
            age = $("table #upd-user td:nth-child(3) input").val();
            if ($("table #upd-user td:nth-child(4) input").prop("checked") == true) {
                var isAdmin = "true"
            }
            else {
                isAdmin = "false"
            }
            crDate = $("table #upd-user td:nth-child(5)").html();

            var isOk = true;

            if (name.length > 25 || name.trim().length==0) {
                isOk = false;
                $("table #upd-user td:nth-child(2)").css("border","1px dotted red");
            }
            if (age.length=0 || age.length > 11 || isNaN(age)){
                isOk = false;
                $("table #upd-user td:nth-child(3)").css("border","1px dotted red");
            }


            if (isOk) {

                $.ajax({
                    url: "/updateUser",
                    type: 'GET',

                    contentType: 'application/json',

                    data: ({
                        id: id,
                        name: name,
                        age: age,
                        isAdmin: isAdmin,
                        crDate: crDate
                    }),
                    success: function () {

                        location.reload();

                    }
                })
            }

        })

    });


});