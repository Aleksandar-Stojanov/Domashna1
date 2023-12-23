$(document).ready(function() {
    // Initialize RateYo
    $("#rating").rateYo({
        starWidth: "20px",
        fullStar: true,
        onSet: function(rating, rateYoInstance) {
            // Store the rating value in a data attribute for later use
            $("#rating").data("rating-value", rating);
        }
    });

    // Handle Submit Rating Button Click
    $("#submitRating").click(function() {
        var wineryId = $("h2").data("winery-id");
        var ratingValue = $("#rating").data("rating-value");

        // Send an AJAX request to submit the rating
        $.ajax({
            url: "/rating/submit",
            type: "POST",
            data: {
                wineryId: wineryId,
                rating: ratingValue
            },
            success: function(response) {
                // Handle success, maybe show a confirmation message
                alert("Rating submitted successfully!");
            },
            error: function(error) {
                // Handle error, maybe show an error message
                alert("Error submitting rating!");
            }
        });
    });
});
