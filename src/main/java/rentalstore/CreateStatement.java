package rentalstore;

public abstract class CreateStatement {
     protected double totalAmount;
     protected Customer customer;
     protected int frequentRenterPoints;
     protected abstract String createHeader();
     protected abstract String createFooter();
     protected abstract String createRentalItem(Rental rental,Double thisAmount);

     protected String createBody(){
          StringBuffer result = new StringBuffer();
          for (Rental each : customer.getRentals()) {
               double thisAmount = 0;
               thisAmount = calculateRentalAmount(each, thisAmount);
               frequentRenterPoints = calculateFrequentRentalPoints(frequentRenterPoints, each);
               //show figures for this rental
               result.append(createRentalItem(each, thisAmount));
               totalAmount += thisAmount;
          }
          return result.toString();
     }
     public CreateStatement(Customer customer) {
          this.customer = customer;
     }

     protected double calculateRentalAmount(Rental each, double thisAmount) {
          return each.getAmount();
     }

     protected int calculateFrequentRentalPoints(int frequentRenterPoints, Rental each) {
          //add frequent renter points
          frequentRenterPoints++;
          //add bonus for a two day new release rental
          if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
               frequentRenterPoints++;
          }
          return frequentRenterPoints;
     }


     protected String getResult(){
          return createHeader() + createBody() + createFooter();
     }
}
