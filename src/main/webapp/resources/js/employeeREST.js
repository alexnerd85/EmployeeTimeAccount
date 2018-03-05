function getEmployeeByID(url, id) {
    var resp;
    $.ajax({
        url: url,

        data: {id},

        type: "GET",

        dataType: "text",

        async: false,

        success: function (response) {
            console.log('The page was loaded');
            resp = response;
            //$('.pusher').html(response);
        },

        error: function (error) {
            console.log('Employee by id was not loaded', error);
        },

        complete: function (xhr, status) {
            console.log("The request is complete");
        }

    });

    return resp;
}

function deleteEmployeeByID(url, id) {
    var resp;
    $.ajax({
        url: url,

        data: {id},

        method: "POST",

        dataType: "text",

        async: false,

        success: function (response) {
            console.log('Employee deleted' + response);
            resp = response;
            //$('.pusher').html(response);
        },

        error: function (error) {
            console.log('Employee by id was not deleted', error);
        },

        complete: function (xhr, status) {
            console.log("The request is complete");
        }

    });

    return resp;
}
