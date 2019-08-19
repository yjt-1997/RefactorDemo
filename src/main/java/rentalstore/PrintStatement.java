package rentalstore;

public class PrintStatement extends CreateStatement {

    public PrintStatement(Customer customer) {
        super(customer);
    }

    @Override
    public String createHeader() {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    public String createFooter() {
        StringBuffer result = new StringBuffer();
        result.append("Amount owed is " + totalAmount + "\n");
        result.append("You earned " + frequentRenterPoints + " frequent renter points");
        return result.toString();
    }

    @Override
    protected String createRentalItem(Rental rental, Double thisAmount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

}
