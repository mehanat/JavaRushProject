/**
 * Created by Анатолий on 16.11.2015.
 */
$(document).ready(function(){
    $("#delete button").click(function(e){
        $.ajax({
        url:"/"+$(e.target).attr('data-id'),
        type:'POST',

        success: function(data){

            location.reload()
        }
        })
    })
});