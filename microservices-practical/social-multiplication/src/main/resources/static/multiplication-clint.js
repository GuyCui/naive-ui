function updateMultiplication() {
    $.ajax({
        url: "http://localhost:8018/multiplications/random"
    }).then(function (data) {
        // Cleans the form
        $("#attempt-form").find("input[name='result-attempt']").val("");
        $("#attempt-form").find("input[name='user-alias']").val("");
        // Gets a random challenge from API and loads the data in the HTML
        $('.multiplication-a').empty().append(data.factorA);
        $('.multiplication-b').empty().append(data.factorB);
    });
}

function updteStats(alias) {
    $.ajax({
        url: "http://localhost:8018/results?alias=" + alias
    }).then(function (data) {
        $('#stats-body').empty();
        data.forEach(function (row) {
            $('#stats-body').append('<tr><td>' + row.id +
                '</td>' +
                '<td>' + row.multiplication.factorA + 'X' +
                row.multiplication.factorB + '</td>' +
                '<td>' + row.resultAttempt + '</td>' +
                '<td>' + (row.correct === true ? 'YES' : 'NO')
                + '</td></tr>');
        });
    });
}

$(document).ready(function () {
    updateMultiplication();
    $("#attempt-form").submit(function (event) {

        // Don't submit the form normally
        event.preventDefault();

        // Get some values from elements on the page
        const a = $('.multiplication-a').text();
        const b = $('.multiplication-b').text();
        const $form = $(this),
            attempt = $form.find("input[name='result-attempt']").val(),
            userAlias = $form.find("input[name='user-alias']").val();

        // Compose the data in the format that the API is expecting
        const data = {user: {alias: userAlias}, multiplication: {factorA: a, factorB: b}, resultAttempt: attempt};

        // Send the data using post
        $.ajax({
            url: '/results',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function (result) {
                if (result.correct) {
                    $('.result-message').empty().append("The result is correct! Congratulations!");
                } else {
                    $('.result-message').empty().append("Oops that's not correct! But keep trying!");
                }
            }
        });
        updteStats(userAlias);
        updateMultiplication();
    });
});