package pl.gov.mofnet.giif.rekrutacja.hr.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ksm
 */
@Entity
@Table(name = "JOBS", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "JOB_ID", nullable = false, length = 10)
    private String job;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "JOB_TITLE", nullable = false, length = 35)
    private String jobTitle;
    @Column(name = "MIN_SALARY")
    private Integer minSalary;
    @Column(name = "MAX_SALARY")
    private Integer maxSalary;

    public Job() {
    }

    public Job(String jobId) {
        this.job = jobId;
    }

    public Job(String jobId, String jobTitle) {
        this.job = jobId;
        this.jobTitle = jobTitle;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
    public int hashCode() {
        int hash = 0;
        hash += (job != null ? job.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.job == null && other.job != null) || (this.job != null && !this.job.equals(other.job))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.gov.mofnet.giif.rekrutacja.hr.model.Job[ jobId=" + job + " ]";
    }
    
}
