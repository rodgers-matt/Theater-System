
package bean;

import ejb.TheaterEJB;
import entity.Locations;
import entity.Movies;
import entity.Times;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author MattR
 */
@Named(value = "theaterBean")
@SessionScoped
public class TheaterBean implements Serializable {

    @EJB
    private TheaterEJB theaterEJB;
    private String zip = new String();
    private String movieName = new String();
    private String time = new String();
    private Locations theTheater;
    private String creditCard = new String();
    private String name = new String();
    private int tickets = 1;
    private String cvv = new String();
    private String date = new String();
    
    /* Getters and Setters*/
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public Locations getTheTheater() {
        return theTheater;
    }

    public void setTheTheater(Locations theTheater) {
        this.theTheater = theTheater;
    }

    public TheaterEJB getTheaterEJB() {
        return theaterEJB;
    }

    public void setTheaterEJB(TheaterEJB theaterEJB) {
        this.theaterEJB = theaterEJB;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterBean() {
    }
    
    public boolean enabled(){
        return zip.length() == 5;
    }
    /* Theater selection functions*/
    
    public String theaterSelect(){
        return "TheaterSelect";
    }
    //This function will store the name of the theater
    public String findMovies(Locations theater){
        theTheater = theater;
        return "MovieSelect";
    }
    //If returning home, we have to reset the values of all the input information.
    public String returnHome(){
        name = new String();
        creditCard = new String();
        date = new String();
        cvv = new String();
        tickets = 1;
        zip = new String();
        return "index";
    }
    
    public List<Locations> getLocations(){
        return theaterEJB.findByZip(zip);
    }
    /*Movie select functions*/
    
    public List<Movies> getMovies(){
        return theaterEJB.findMoviesByTheaterID(theTheater);
    }
    
    public List<Times> getTimes(Movies movie){
        return theaterEJB.findMovieTimes(movie, theTheater);
    }
    //This function sets the values for the movie and time. This will be used later in the thank you message.
    public String goToPayment(Times time, Movies movie){
        movieName = movie.getTitle();
        this.time = time.getTimesPK().getTime();
        return "Payment";
    }
    
    /*Payment functions*/
    //This function will calculate the total based on the amount of tickets the user wishes to buy
    public String totalCost(){
        return "$" + String.valueOf(tickets * 10) +".00";
    }
    //This function is used to verify the user has input valid credit card information. If the information is valid, the user can click submit.
    public boolean validCard(){
        return creditCard.length() >= 16 && cvv.length() >= 3 && date.length() >= 4 && name.length() > 1;
    }
    
    public String goToConfirmation(){
        return "Confirmation";
    }
    
}
