package pl.gov.mofnet.giif.rekrutacja.hr.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COUNTRIES", schema = "HR")
public class Country {

    @Id
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    private String id;

    @Basic
    @Column(name = "COUNTRY_NAME", nullable = true, length = 40)
    private String name;

    @ManyToOne
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
    private Region region;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", region" + (region == null ? " is null" : ".id=" + region.getId()) +
                '}';
    }
}
