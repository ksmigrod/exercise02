package pl.gov.mofnet.giif.rekrutacja.hr.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "JOBS", schema = "HR")
public class Job {
    @Id
    @Column(name = "JOB_ID", nullable = false, length = 10)
    @NotNull
    @Size(max = 10)
    private String id;

    @Basic
    @Column(name = "JOB_TITLE", nullable = false, length = 35)
    @NotNull
    @Size(max = 35)
    private String title;

    @Basic
    @Column(name = "MIN_SALARY", nullable = true, precision = 6)
    @Min(0)
    @Max(999_999)
    private Integer minSalary;

    @Basic
    @Column(name = "MAX_SALARY", nullable = true, precision = 6)
    @Min(0)
    @Max(999_999)
    private Integer maxSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id) &&
                Objects.equals(title, job.title) &&
                Objects.equals(minSalary, job.minSalary) &&
                Objects.equals(maxSalary, job.maxSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, minSalary, maxSalary);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
