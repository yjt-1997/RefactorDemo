package rentalstore;

public class ChildrensRental extends Rental {
    public ChildrensRental(Movie movie, int dayRented) {
        super(movie, dayRented);
    }

    @Override
    Double getAmount() {
        double thisAmount = 1.5;
        if (getDayRented() > 3) {
            thisAmount += (getDayRented() - 3) * 1.5;
        }
        return thisAmount;
    }
}
