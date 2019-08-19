package rentalstore;

public class RegularRental extends Rental {
    public RegularRental(Movie movie, int dayRented) {
        super(movie, dayRented);
    }

    @Override
    Double getAmount() {
        double thisAmount = 2;
        if (getDayRented() > 2) {
            thisAmount += (getDayRented() - 2) * 1.5;
        }
        return thisAmount;
    }

}
