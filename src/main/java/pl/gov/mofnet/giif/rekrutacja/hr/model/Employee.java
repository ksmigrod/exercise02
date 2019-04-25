package pl.gov.mofnet.giif.rekrutacja.hr.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEES", schema = "HR")
public class Employee {

    @SequenceGenerator(name = "EmployeeSeqGen", sequenceName = "EMPLOYEES_SEQ", schema = "HR")
    @GeneratedValue(generator = "EmployeeSeqGen", strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 6)
    private Integer id;

    @Basic
    @Column(name = "FIRST_NAME", length = 20)
    @Size(max = 20)
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 25)
    @NotNull
    @Size(max = 25)
    private String lastName;

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 25)
    @NotNull
    @Size(max = 25)
    private String email;

    @Basic
    @Column(name = "PHONE_NUMBER", length = 20)
    @Size(max = 20)
    private String phoneNumber;

    @Basic
    @Column(name = "HIRE_DATE", nullable = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Basic
    @Column(name = "SALARY", precision = 8, scale = 2)
    @DecimalMin("0")
    @DecimalMax(value = "1_000_000", inclusive = false)
    private BigDecimal salary;

    @Basic
    @Column(name = "COMMISSION_PCT", precision = 2, scale = 2)
    @Min(0)
    @Max(99)
    private Short commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID", nullable = false, referencedColumnName = "JOB_ID")
    @NotNull
    private Job job;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Short getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Short commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(commissionPct, employee.commissionPct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", manager=" + (manager == null ? " is null" : ".id=" + manager.getId()) +
                ", department" + (department == null ? " is null" : ".id=" + department.getId())+
                ", job" + (job == null ? " is null" : ".id=" + job.getId())+
                '}';
    }
}
