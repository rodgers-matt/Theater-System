
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
@Table(name = "LOCATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l"),
    @NamedQuery(name = "Locations.findByTheaterid", query = "SELECT l FROM Locations l WHERE l.theaterid = :theaterid"),
    @NamedQuery(name = "Locations.findByName", query = "SELECT l FROM Locations l WHERE l.name = :name"),
    @NamedQuery(name = "Locations.findByAddress", query = "SELECT l FROM Locations l WHERE l.address = :address"),
    @NamedQuery(name = "Locations.findByCity", query = "SELECT l FROM Locations l WHERE l.city = :city"),
    @NamedQuery(name = "Locations.findByState", query = "SELECT l FROM Locations l WHERE l.state = :state"),
    @NamedQuery(name = "Locations.findByZip", query = "SELECT l FROM Locations l WHERE l.zip = :zip"),
    @NamedQuery(name = "Locations.findByLogo", query = "SELECT l FROM Locations l WHERE l.logo = :logo")})
public class Locations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "THEATERID")
    private String theaterid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 20)
    @Column(name = "STATE")
    private String state;
    @Size(max = 5)
    @Column(name = "ZIP")
    private String zip;
    @Size(max = 100)
    @Column(name = "LOGO")
    private String logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locations")
    private Collection<Times> timesCollection;

    public Locations() {
    }

    public Locations(String theaterid) {
        this.theaterid = theaterid;
    }

    public String getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(String theaterid) {
        this.theaterid = theaterid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
        hash += (theaterid != null ? theaterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.theaterid == null && other.theaterid != null) || (this.theaterid != null && !this.theaterid.equals(other.theaterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Locations[ theaterid=" + theaterid + " ]";
    }
    
}
