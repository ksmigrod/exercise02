package pl.gov.mofnet.giif.rekrutacja.boundary;

import org.hamcrest.Matchers;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.gov.mofnet.giif.rekrutacja.hr.model.Department;
import pl.gov.mofnet.giif.rekrutacja.hr.to.DepartmentTO;
import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;

//import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;

@RunWith(Arquillian.class)
@Ignore
public class DepartmentResourceIT {

    private static final Logger logger = Logger.getLogger(DepartmentResourceIT.class.getName());

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "DepartmentsResourceIT.war")
                .addClasses(
                        ApplicationConfig.class,
                        EmployeesResource.class
                )
                .addClasses(
                        pl.gov.mofnet.giif.rekrutacja.controller.EmployeeService.class,
                        pl.gov.mofnet.giif.rekrutacja.controller.EmployeeServiceImpl.class,
                        pl.gov.mofnet.giif.rekrutacja.controller.EmployeeTOBuilder.class
                )
                .addClasses(
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Country.class,
                        Department.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Employee.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Job.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Location.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Region.class
                )
                .addClasses(
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Country_.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Department_.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Employee_.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Job_.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Location_.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Region_.class
                )
                .addClasses(
                        pl.gov.mofnet.giif.rekrutacja.hr.services.AbstractRepositoryImpl.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.services.DepartmentDao.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.services.DepartmentDaoImpl.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.services.EmployeeDao.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.services.EmployeeDaoImpl.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.services.EntityRepository.class
                )
                .addClasses(
                        DepartmentTO.class,
                        EmployeeTO.class
                )
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
//                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/openejb-jar.xml"), "openejb-jar.xml")
//                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/resources.xml"), "resources.xml")
                .addAsManifestResource("test-persistence.xml", "persistence.xml" )
                .addAsResource("create.sql")
                ;
    }

    @Test
    @RunAsClient
    public void listOfEmployees(@ArquillianResteasyResource("departments") WebTarget target) throws MalformedURLException {
        target.register(org.apache.johnzon.jaxrs.JohnzonProvider.class);
        Response response = target.request().buildGet().invoke();

        int status = response.getStatus();
        List<DepartmentTO> actual = response.readEntity(new GenericType<List<DepartmentTO>>() {

        });

        List<DepartmentTO> expected = expectedResult();

        Assert.assertThat(status, is(Response.Status.OK.getStatusCode()));
        logger.log(Level.INFO, "Departments: {0}", actual);
        Assert.assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new DepartmentTO[]{})));
    }

    private List<DepartmentTO> expectedResultWithoutCounts() {
        List<DepartmentTO> result = new ArrayList<>();
        result.add(new DepartmentTO(10, "Administration"));
        result.add(new DepartmentTO(20, "Marketing"));
        result.add(new DepartmentTO(30, "Purchasing"));
        result.add(new DepartmentTO(40, "Human Resources"));
        result.add(new DepartmentTO(50, "Shipping"));
        result.add(new DepartmentTO(60, "IT"));
        result.add(new DepartmentTO(70, "Public Relations"));
        result.add(new DepartmentTO(80, "Sales"));
        result.add(new DepartmentTO(90, "Executive"));
        result.add(new DepartmentTO(100, "Finance"));
        result.add(new DepartmentTO(110, "Accounting"));
        result.add(new DepartmentTO(120, "Treasury"));
        result.add(new DepartmentTO(130, "Corporate Tax"));
        result.add(new DepartmentTO(140, "Control And Credit"));
        result.add(new DepartmentTO(150, "Shareholder Services"));
        result.add(new DepartmentTO(160, "Benefits"));
        result.add(new DepartmentTO(170, "Manufacturing"));
        result.add(new DepartmentTO(180, "Construction"));
        result.add(new DepartmentTO(190, "Contracting"));
        result.add(new DepartmentTO(200, "Operations"));
        result.add(new DepartmentTO(210, "IT Support"));
        result.add(new DepartmentTO(220, "NOC"));
        result.add(new DepartmentTO(230, "IT Helpdesk"));
        result.add(new DepartmentTO(240, "Government Sales"));
        result.add(new DepartmentTO(250, "Retail Sales"));
        result.add(new DepartmentTO(260, "Recruiting"));
        result.add(new DepartmentTO(270, "Payroll"));
        return result;
    }

    private List<DepartmentTO> expectedResult() {
        List<DepartmentTO> result = new ArrayList<>();
        result.add(new DepartmentTO(100, "Finance", 6));
        result.add(new DepartmentTO(140, "Control And Credit", 0));
        result.add(new DepartmentTO(50, "Shipping", 45));
        result.add(new DepartmentTO(70, "Public Relations", 1));
        result.add(new DepartmentTO(250, "Retail Sales", 0));
        result.add(new DepartmentTO(120, "Treasury", 0));
        result.add(new DepartmentTO(220, "NOC", 0));
        result.add(new DepartmentTO(230, "IT Helpdesk", 0));
        result.add(new DepartmentTO(240, "Government Sales", 0));
        result.add(new DepartmentTO(30, "Purchasing", 6));
        result.add(new DepartmentTO(90, "Executive", 3));
        result.add(new DepartmentTO(200, "Operations", 0));
        result.add(new DepartmentTO(10, "Administration", 1));
        result.add(new DepartmentTO(110, "Accounting", 2));
        result.add(new DepartmentTO(130, "Corporate Tax", 0));
        result.add(new DepartmentTO(170, "Manufacturing", 0));
        result.add(new DepartmentTO(180, "Construction", 0));
        result.add(new DepartmentTO(190, "Contracting", 0));
        result.add(new DepartmentTO(40, "Human Resources", 1));
        result.add(new DepartmentTO(20, "Marketing", 2));
        result.add(new DepartmentTO(60, "IT", 5));
        result.add(new DepartmentTO(80, "Sales", 34));
        result.add(new DepartmentTO(160, "Benefits", 0));
        result.add(new DepartmentTO(210, "IT Support", 0));
        result.add(new DepartmentTO(150, "Shareholder Services", 0));
        result.add(new DepartmentTO(260, "Recruiting", 0));
        result.add(new DepartmentTO(270, "Payroll", 0));
        return result;
    }
}
