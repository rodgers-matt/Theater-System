
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MattR
 */
@Entity
@Table(name = "MOVIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByMovieid", query = "SELECT m FROM Movies m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Movies.findByTitle", query = "SELECT m FROM Movies m WHERE m.title = :title"),
    @NamedQuery(name = "Movies.findByDescription", query = "SELECT m FROM Movies m WHERE m.description = :description"),
    @NamedQuery(name = "Movies.findByImage", query = "SELECT m FROM Movies m WHERE m.image = :image"),
    @NamedQuery(name = "Movies.findMovieListByTheaterid", query = "SELECT DISTINCT m FROM Movies m, Times t WHERE m.movieid = t.timesPK.movieid AND t.timesPK.theaterid = :theaterid")
})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MOVIEID")
    private String movieid;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "IMAGE")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movies")
    private Collection<Times> timesCollection;

    public Movies() {
    }

    public Movies(String movieid) {
        this.movieid = movieid;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Times> getTimesCollection() {
        return timesCollection;
    }

    public void setTimesCollection(Collection<Times> timesCollection) {
        this.timesCollection = timesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movies[ movieid=" + movieid + " ]";
    }
    
}
