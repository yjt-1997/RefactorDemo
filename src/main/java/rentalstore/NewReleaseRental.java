package rentalstore;

public class NewReleaseRental extends Rental {
    public NewReleaseRental(Movie movie, int dayRented) {
        super(movie, dayRented);
    }

    @Override
    Double getAmount() {
        return Double.valueOf(getDayRented() * 3);

    }
}
