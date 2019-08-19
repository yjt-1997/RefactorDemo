package rentalstore;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void should_return_the_order_statement_when_statement_given_children_movie_and_rented_a_day() {
        Customer customer = new Customer("Jerry");
        Movie movie = new Movie("Titanic", 2);
        Rental rental = new ChildrensRental(movie, 1);
        customer.addRental(rental);
        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_when_statement_given_children_movie_and_rented_four_day() {
        Customer customer = new Customer("Jerry");
        Movie movie = new Movie("Titanic", 2);
        Rental rental = new ChildrensRental(movie, 4);
        customer.addRental(rental);
        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_when_statement_given_regular_movie_and_rented_a_day() {
        Customer customer = new Customer("Jerry");
        Movie movie = new Movie("Titanic", 0);
        Rental rental = new RegularRental(movie, 1);
        customer.addRental(rental);
        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_when_statement_given_regular_movie_and_rented_three_day() {
        Customer customer = new Customer("Jerry");
        Movie movie = new Movie("Titanic", 0);
        Rental rental = new RegularRental(movie, 3);
        customer.addRental(rental);
        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_when_statement_given_new_movie_and_rented_one_day() {
        Customer customer = new Customer("Jerry");
        Movie movie = new Movie("Titanic", 1);
        Rental rental = new NewReleaseRental(movie, 1);
        customer.addRental(rental);
        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_when_statement_given_two_new_movie_and_rented_one_day() {
        Customer customer = new Customer("Jerry");
        Movie oneMovie = new Movie("Titanic", 1);
        Movie twoMovie = new Movie("Titanic", 1);

        customer.addRental(new NewReleaseRental(oneMovie, 1));
        customer.addRental(new NewReleaseRental(twoMovie, 1));

        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t3.0\n" +
                "\tTitanic\t3.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_when_statement_given_two_new_movie_and_rented_two_day() {
        Customer customer = new Customer("Jerry");
        Movie oneMovie = new Movie("Titanic", 1);
        Movie twoMovie = new Movie("Titanic", 1);

        customer.addRental(new NewReleaseRental(oneMovie, 2));
        customer.addRental(new NewReleaseRental(twoMovie, 3));

        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t6.0\n" +
                "\tTitanic\t9.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 4 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_when_statement_given_two_regular_movie_and_rented_one_day() {
        Customer customer = new Customer("Jerry");
        Movie oneMovie = new Movie("Titanic", 0);
        Movie twoMovie = new Movie("Titanic", 0);

        customer.addRental(new RegularRental(oneMovie, 1));
        customer.addRental(new RegularRental(twoMovie, 1));

        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t2.0\n" +
                "\tTitanic\t2.0\n" +
                "Amount owed is 4.0\n" +
                "You earned 2 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_when_statement_given_none() {
        Customer customer = new Customer("Jerry");
        String result = customer.statement();
        Assert.assertEquals("Rental Record for Jerry\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", result);
    }

    @Test
    public void should_return_the_order_statement_in_html_when_statement_given_none() {
        Customer customer = new Customer("Jerry");
        String result = customer.statementInHtml();
        Assert.assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "<P>You owe<EM>0.0</EM><P>\n" +
                "On this rental you earned <EM>0</EM> frequent renter points<P>", result);
    }

    @Test
    public void should_return_the_order_statement_in_html_when_statement_given_Roman_Holiday_And_Titanic() {
        Customer customer = new Customer("Jerry");
        Movie oneMovie = new Movie("Roman Holiday", 1);
        Movie twoMovie = new Movie("Titanic", 1);

        customer.addRental(new NewReleaseRental(oneMovie, 1));
        customer.addRental(new NewReleaseRental(twoMovie, 1));
        String result = customer.statementInHtml();
        Assert.assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "Roman Holiday: 3.0<BR>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>6.0</EM><P>\n" +
                "On this rental you earned <EM>2</EM> frequent renter points<P>", result);
    }

}
