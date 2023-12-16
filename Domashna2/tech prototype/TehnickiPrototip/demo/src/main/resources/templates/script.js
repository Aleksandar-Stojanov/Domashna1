$(document).ready(function () {
    const stars = $('.star');
    const ratingContainer = $('#rating');
    const ratingInput = $('#ratingInput');

    stars.on('mouseover', hoverStar);
    stars.on('mouseout', resetStars);
    stars.on('click', setRating);

    function hoverStar(e) {
        const hoverValue = $(e.target).data('value');
        highlightStars(hoverValue);
    }

    function resetStars() {
        const currentRating = ratingContainer.data('rating');
        highlightStars(currentRating);
    }

    function setRating(e) {
        const clickedValue = $(e.target).data('value');
        ratingContainer.data('rating', clickedValue);
        resetStars();
    }

    $('#submitRating').on('click', function () {
        const selectedRating = ratingContainer.data('rating');
        const wineryId = $('h2').data('winery-id');

        $.ajax({
            type: 'POST',
            url: '/rating/submit',
            data: { wineryId: wineryId, rating: selectedRating },
            success: function (response) {
                alert(response.message);
                const updatedRating = response.rating;
                updateWineryRating(updatedRating); // Pass the updated rating to the function
            },
            error: function (error) {
                alert('Error submitting rating: ' + error.responseText);
            }
        });
    });
    function updateWineryRating(updatedRating) {
        wineryRatingDiv.text('Rating: ' + updatedRating);
    }
    function highlightStars(value) {
        stars.each(function () {
            const starValue = $(this).data('value');
            $(this).toggleClass('active', starValue <= value);
        });
    }
});
