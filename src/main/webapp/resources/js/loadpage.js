function callPage(pageRefInput){
    $.ajax({
        url: pageRefInput,
    
        type: "GET",
    
        dataType: "text",
    
        success: function(response){
            console.log('The page was loaded');
            $('.pusher').html(response);
        },
    
        error: function(error){
            console.log('The page was not loaded', error);
        },
    
        complete: function(xhr, status){
            console.log("The request is complete");
        }
    
    });

}
