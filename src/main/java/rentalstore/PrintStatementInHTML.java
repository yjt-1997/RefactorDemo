package rentalstore;

public class PrintStatementInHTML extends CreateStatement {

    public PrintStatementInHTML(Customer customer) {
        super(customer);
    }

    @Override
    protected String createHeader() {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }


    @Override
    protected String createFooter() {
        StringBuffer result = new StringBuffer();
        result.append("<P>You owe<EM>" + totalAmount + "</EM><P>\n");
        result.append("On this rental you earned <EM>" + frequentRenterPoints + "</EM> frequent renter points<P>");
        return result.toString();
    }

    @Override
    protected String createRentalItem(Rental rental, Double thisAmount) {
        return rental.getMovie().getTitle() + ": " + thisAmount + "<BR>\n";
    }
}
