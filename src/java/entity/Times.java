
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MattR
 */
@Entity
@Table(name = "TIMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Times.findAll", query = "SELECT t FROM Times t"),
    @NamedQuery(name = "Times.findByTheaterid", query = "SELECT t FROM Times t WHERE t.timesPK.theaterid = :theaterid"),
    @NamedQuery(name = "Times.findByMovieid", query = "SELECT t FROM Times t WHERE t.timesPK.movieid = :movieid"),
    @NamedQuery(name = "Times.findByTime", query = "SELECT t FROM Times t WHERE t.timesPK.time = :time"),
    @NamedQuery(name = "Times.findByMovieidAndTheaterid", query = "SELECT t FROM Times t WHERE t.timesPK.movieid = :movieid AND t.timesPK.theaterid = :theaterid ORDER BY t.timesPK.time")
})
public class Times implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimesPK timesPK;
    @JoinColumn(name = "THEATERID", referencedColumnName = "THEATERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Locations locations;
    @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movies movies;

    public Times() {
    }

    public Times(TimesPK timesPK) {
        this.timesPK = timesPK;
    }

    public Times(String theaterid, String movieid, String time) {
        this.timesPK = new TimesPK(theaterid, movieid, time);
    }

    public TimesPK getTimesPK() {
        return timesPK;
    }

    public void setTimesPK(TimesPK timesPK) {
        this.timesPK = timesPK;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timesPK != null ? timesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Times)) {
            return false;
        }
        Times other = (Times) object;
        if ((this.timesPK == null && other.timesPK != null) || (this.timesPK != null && !this.timesPK.equals(other.timesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Times[ timesPK=" + timesPK + " ]";
    }
    
}
