// $(document).ready(function () {
//     const stars = $('.star');
//     const ratingContainer = $('#rating');
//
//     stars.on('mouseover', hoverStar);
//     stars.on('mouseout', resetStars);
//     stars.on('click', setRating);
//
//     function hoverStar(e) {
//         const hoverValue = $(e.target).data('value');
//         highlightStars(hoverValue);
//     }
//
//     function resetStars() {
//         const currentRating = ratingContainer.data('rating');
//         highlightStars(currentRating);
//     }
//
//     function setRating(e) {
//         const clickedValue = $(e.target).data('value');
//         ratingContainer.data('rating', clickedValue);
//         resetStars();
//     }
//
//     $('#submitRating').on('click', function () {
//         const selectedRating = ratingContainer.data('rating');
//
//         $.ajax({
//             type: 'POST',  // Use POST method
//             url: '/rating/submit',  // Replace with the actual URL for your server endpoint
//             data: { wineryId: wineryId, rating: selectedRating },  // Include the necessary data
//             success: function (response) {
//                 alert('Rating submitted successfully');
//                 // You may want to update the UI or take other actions based on the server response
//             },
//             error: function (error) {
//                 alert('Error submitting rating: ' + error.responseText);
//             }
//         });
//     });
//
//     function highlightStars(value) {
//         stars.each(function () {
//             const starValue = $(this).data('value');
//             $(this).toggleClass('active', starValue <= value);
//         });
//     }
// });

$(document).ready(function () {
    const ratingContainer = $("#rating");

    ratingContainer.rateYo({
        starWidth: "20px",
        readOnly: false, // Set to false if you want users to be able to rate
        rating: ratingContainer.data("rating"),
        onChange: function (rating, rateYoInstance) {
            // Display the selected rating dynamically (optional)
            // You can customize this part based on your UI requirements
            console.log("Selected Rating: " + rating);
        },
    });

    $("#submitRating").on("click", function () {
        const selectedRating = ratingContainer.rateYo("rating");

        $.ajax({
            type: "POST",
            url: "/rating/submit", // Replace with your actual server endpoint
            data: { wineryId: wineryId, rating: selectedRating },
            success: function (response) {
                alert(response); // Display success message
                // You may want to refresh the page or update the UI based on the response
            },
            error: function (error) {
                alert("Error submitting rating: " + error.responseText);
            },
        });
    });
});
