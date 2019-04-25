package pl.gov.mofnet.giif.rekrutacja.hr.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "REGIONS", schema = "HR")
public class Region {
    @Id
    @Column(name = "REGION_ID", nullable = false, precision = 4)
    @NotNull
    @Min(0)
    @Max(9999)
    private Short id;

    @Basic
    @Column(name = "REGION_NAME", nullable = true, length = 25)
    @Size(max = 25)
    private String name;

    public Short getId() {
        return id;
    }

    public void setId(Short regionId) {
        this.id = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String regionName) {
        this.name = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(id, region.id) &&
                Objects.equals(name, region.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
