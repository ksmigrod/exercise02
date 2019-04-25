package pl.gov.mofnet.giif.rekrutacja.hr.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "LOCATIONS", schema = "HR", catalog = "")
public class Location {

    @SequenceGenerator(name = "LocationSeqGen", sequenceName = "LOCATIONS_SEQ", schema = "HR")
    @GeneratedValue(generator = "LocationSeqGen", strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "LOCATION_ID", nullable = false, precision = 4)
    private Short id;

    @Basic
    @Column(name = "STREET_ADDRESS", length = 40)
    private String streetAddress;

    @Basic
    @Column(name = "POSTAL_CODE", length = 12)
    @Size(max = 12)
    private String postalCode;

    @Basic
    @Column(name = "CITY", nullable = false, length = 30)
    @NotNull
    @Size(max = 30)
    private String city;

    @Basic
    @Column(name = "STATE_PROVINCE", length = 25)
    @Size(max = 25)
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    private Country country;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(streetAddress, location.streetAddress) &&
                Objects.equals(postalCode, location.postalCode) &&
                Objects.equals(city, location.city) &&
                Objects.equals(stateProvince, location.stateProvince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streetAddress, postalCode, city, stateProvince);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", country" + (country == null ? " is null" : ".id=" + country.getId()) +
                '}';
    }
}
