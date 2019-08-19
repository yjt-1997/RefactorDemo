package rentalstore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new PrintStatement(this).getResult();
    }

    public String statementInHtml(){
        return new PrintStatementInHTML(this).getResult();
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
