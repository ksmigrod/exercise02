package pl.gov.mofnet.giif.rekrutacja.hr.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENTS", schema = "HR")
public class Department {

    @SequenceGenerator(name = "DepartmentSeqGen", sequenceName = "DEPARTMENTS_SEQ", schema = "HR")
    @GeneratedValue(generator = "DepartmentSeqGen", strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false, precision = 4)
    @Min(0)
    @Max(9999L)
    private Short id;

    @Basic
    @Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    private Location location;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager" + (manager == null ? " is null" : ".id=" + manager.getId()) +
                ", location" + (location == null ? " is null" : ".id=" + location.getId()) +
                '}';
    }
}
