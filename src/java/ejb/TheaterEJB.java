
package ejb;

import entity.Locations;
import entity.Movies;
import entity.Times;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MattR
 */
@Stateless
public class TheaterEJB {

    @PersistenceContext(unitName = "TheaterSystemPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    //This function will return a list of location based on the provided zip code
    public List<Locations> findByZip(String zip){
        return em.createNamedQuery("Locations.findByZip", Locations.class).setParameter("zip", zip).getResultList();
    }
    //This function will return a list of movies based on the theater the user has selected
    public List<Movies> findMoviesByTheaterID(Locations theater){
        return em.createNamedQuery("Movies.findMovieListByTheaterid", Movies.class).setParameter("theaterid", theater.getTheaterid()).getResultList();
    }
    //This function will return a list of times a movie is playing in a theater.
    public List<Times> findMovieTimes(Movies movie, Locations theater){
        return em.createNamedQuery("Times.findByMovieidAndTheaterid", Times.class).setParameter("theaterid", theater.getTheaterid()).setParameter("movieid", movie.getMovieid()).getResultList();
    }
}
