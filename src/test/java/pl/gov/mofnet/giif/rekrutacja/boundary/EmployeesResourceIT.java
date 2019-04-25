package pl.gov.mofnet.giif.rekrutacja.boundary;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
//import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.gov.mofnet.giif.rekrutacja.hr.model.Department;
import pl.gov.mofnet.giif.rekrutacja.hr.to.DepartmentTO;
import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Arquillian.class)
public class EmployeesResourceIT {

    private static final Logger logger = Logger.getLogger(EmployeesResourceIT.class.getName());

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "EmployeesResourceIT.war")
                .addClasses(
                        pl.gov.mofnet.giif.rekrutacja.boundary.ApplicationConfig.class,
                        pl.gov.mofnet.giif.rekrutacja.boundary.EmployeesResource.class
                )
                .addClasses(
                        pl.gov.mofnet.giif.rekrutacja.controller.EmployeeService.class,
                        pl.gov.mofnet.giif.rekrutacja.controller.EmployeeServiceImpl.class,
                        pl.gov.mofnet.giif.rekrutacja.controller.EmployeeTOBuilder.class
                )
                .addClasses(
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Country.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.model.Department.class,
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
                        pl.gov.mofnet.giif.rekrutacja.hr.to.DepartmentTO.class,
                        pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO.class
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
    public void listOfEmployees(@ArquillianResteasyResource("employees") WebTarget target) throws MalformedURLException {
        target.register(org.apache.johnzon.jaxrs.JohnzonProvider.class);
        Response response = target.request().buildGet().invoke();

        int status = response.getStatus();
        List<EmployeeTO> employeeTOS = response.readEntity(new GenericType<List<EmployeeTO>>() {

        });

        List<EmployeeTO> expected = expectedResult();

        Assert.assertThat(status, is(Response.Status.OK.getStatusCode()));
        logger.log(Level.INFO, "Employees: {0}", employeeTOS);
        Assert.assertThat(employeeTOS, Matchers.containsInAnyOrder(expected.toArray(new EmployeeTO[]{})));
    }

    private List expectedResult() {
        DepartmentTO dep10 = new DepartmentTO(10, "Administration");
        DepartmentTO dep20 = new DepartmentTO(20, "Marketing");
        DepartmentTO dep30 = new DepartmentTO(30, "Purchasing");
        DepartmentTO dep40 = new DepartmentTO(40, "Human Resources");
        DepartmentTO dep50 = new DepartmentTO(50, "Shipping");
        DepartmentTO dep60 = new DepartmentTO(60, "IT");
        DepartmentTO dep70 = new DepartmentTO(70, "Public Relations");
        DepartmentTO dep80 = new DepartmentTO(80, "Sales");
        DepartmentTO dep90 = new DepartmentTO(90, "Executive");
        DepartmentTO dep100 = new DepartmentTO(100, "Finance");
        DepartmentTO dep110 = new DepartmentTO(110, "Accounting");
        DepartmentTO dep120 = new DepartmentTO(120, "Treasury");
        DepartmentTO dep130 = new DepartmentTO(130, "Corporate Tax");
        DepartmentTO dep140 = new DepartmentTO(140, "Control And Credit");
        DepartmentTO dep150 = new DepartmentTO(150, "Shareholder Services");
        DepartmentTO dep160 = new DepartmentTO(160, "Benefits");
        DepartmentTO dep170 = new DepartmentTO(170, "Manufacturing");
        DepartmentTO dep180 = new DepartmentTO(180, "Construction");
        DepartmentTO dep190 = new DepartmentTO(190, "Contracting");
        DepartmentTO dep200 = new DepartmentTO(200, "Operations");
        DepartmentTO dep210 = new DepartmentTO(210, "IT Support");
        DepartmentTO dep220 = new DepartmentTO(220, "NOC");
        DepartmentTO dep230 = new DepartmentTO(230, "IT Helpdesk");
        DepartmentTO dep240 = new DepartmentTO(240, "Government Sales");
        DepartmentTO dep250 = new DepartmentTO(250, "Retail Sales");
        DepartmentTO dep260 = new DepartmentTO(260, "Recruiting");
        DepartmentTO dep270 = new DepartmentTO(270, "Payroll");
        List<EmployeeTO> result = new ArrayList<>();
        result.add(new EmployeeTO(100, "Steven", "King", dep90));
        result.add(new EmployeeTO(101, "Neena", "Kochhar", dep90));
        result.add(new EmployeeTO(102, "Lex", "De Haan", dep90));
        result.add(new EmployeeTO(103, "Alexander", "Hunold", dep60));
        result.add(new EmployeeTO(104, "Bruce", "Ernst", dep60));
        result.add(new EmployeeTO(105, "David", "Austin", dep60));
        result.add(new EmployeeTO(106, "Valli", "Pataballa", dep60));
        result.add(new EmployeeTO(107, "Diana", "Lorentz", dep60));
        result.add(new EmployeeTO(108, "Nancy", "Greenberg", dep100));
        result.add(new EmployeeTO(109, "Daniel", "Faviet", dep100));
        result.add(new EmployeeTO(110, "John", "Chen", dep100));
        result.add(new EmployeeTO(111, "Ismael", "Sciarra", dep100));
        result.add(new EmployeeTO(112, "Jose Manuel", "Urman", dep100));
        result.add(new EmployeeTO(113, "Luis", "Popp", dep100));
        result.add(new EmployeeTO(114, "Den", "Raphaely", dep30));
        result.add(new EmployeeTO(115, "Alexander", "Khoo", dep30));
        result.add(new EmployeeTO(116, "Shelli", "Baida", dep30));
        result.add(new EmployeeTO(117, "Sigal", "Tobias", dep30));
        result.add(new EmployeeTO(118, "Guy", "Himuro", dep30));
        result.add(new EmployeeTO(119, "Karen", "Colmenares", dep30));
        result.add(new EmployeeTO(120, "Matthew", "Weiss", dep50));
        result.add(new EmployeeTO(121, "Adam", "Fripp", dep50));
        result.add(new EmployeeTO(122, "Payam", "Kaufling", dep50));
        result.add(new EmployeeTO(123, "Shanta", "Vollman", dep50));
        result.add(new EmployeeTO(124, "Kevin", "Mourgos", dep50));
        result.add(new EmployeeTO(125, "Julia", "Nayer", dep50));
        result.add(new EmployeeTO(126, "Irene", "Mikkilineni", dep50));
        result.add(new EmployeeTO(127, "James", "Landry", dep50));
        result.add(new EmployeeTO(128, "Steven", "Markle", dep50));
        result.add(new EmployeeTO(129, "Laura", "Bissot", dep50));
        result.add(new EmployeeTO(130, "Mozhe", "Atkinson", dep50));
        result.add(new EmployeeTO(131, "James", "Marlow", dep50));
        result.add(new EmployeeTO(132, "TJ", "Olson", dep50));
        result.add(new EmployeeTO(133, "Jason", "Mallin", dep50));
        result.add(new EmployeeTO(134, "Michael", "Rogers", dep50));
        result.add(new EmployeeTO(135, "Ki", "Gee", dep50));
        result.add(new EmployeeTO(136, "Hazel", "Philtanker", dep50));
        result.add(new EmployeeTO(137, "Renske", "Ladwig", dep50));
        result.add(new EmployeeTO(138, "Stephen", "Stiles", dep50));
        result.add(new EmployeeTO(139, "John", "Seo", dep50));
        result.add(new EmployeeTO(140, "Joshua", "Patel", dep50));
        result.add(new EmployeeTO(141, "Trenna", "Rajs", dep50));
        result.add(new EmployeeTO(142, "Curtis", "Davies", dep50));
        result.add(new EmployeeTO(143, "Randall", "Matos", dep50));
        result.add(new EmployeeTO(144, "Peter", "Vargas", dep50));
        result.add(new EmployeeTO(145, "John", "Russell", dep80));
        result.add(new EmployeeTO(146, "Karen", "Partners", dep80));
        result.add(new EmployeeTO(147, "Alberto", "Errazuriz", dep80));
        result.add(new EmployeeTO(148, "Gerald", "Cambrault", dep80));
        result.add(new EmployeeTO(149, "Eleni", "Zlotkey", dep80));
        result.add(new EmployeeTO(150, "Peter", "Tucker", dep80));
        result.add(new EmployeeTO(151, "David", "Bernstein", dep80));
        result.add(new EmployeeTO(152, "Peter", "Hall", dep80));
        result.add(new EmployeeTO(153, "Christopher", "Olsen", dep80));
        result.add(new EmployeeTO(154, "Nanette", "Cambrault", dep80));
        result.add(new EmployeeTO(155, "Oliver", "Tuvault", dep80));
        result.add(new EmployeeTO(156, "Janette", "King", dep80));
        result.add(new EmployeeTO(157, "Patrick", "Sully", dep80));
        result.add(new EmployeeTO(158, "Allan", "McEwen", dep80));
        result.add(new EmployeeTO(159, "Lindsey", "Smith", dep80));
        result.add(new EmployeeTO(160, "Louise", "Doran", dep80));
        result.add(new EmployeeTO(161, "Sarath", "Sewall", dep80));
        result.add(new EmployeeTO(162, "Clara", "Vishney", dep80));
        result.add(new EmployeeTO(163, "Danielle", "Greene", dep80));
        result.add(new EmployeeTO(164, "Mattea", "Marvins", dep80));
        result.add(new EmployeeTO(165, "David", "Lee", dep80));
        result.add(new EmployeeTO(166, "Sundar", "Ande", dep80));
        result.add(new EmployeeTO(167, "Amit", "Banda", dep80));
        result.add(new EmployeeTO(168, "Lisa", "Ozer", dep80));
        result.add(new EmployeeTO(169, "Harrison", "Bloom", dep80));
        result.add(new EmployeeTO(170, "Tayler", "Fox", dep80));
        result.add(new EmployeeTO(171, "William", "Smith", dep80));
        result.add(new EmployeeTO(172, "Elizabeth", "Bates", dep80));
        result.add(new EmployeeTO(173, "Sundita", "Kumar", dep80));
        result.add(new EmployeeTO(174, "Ellen", "Abel", dep80));
        result.add(new EmployeeTO(175, "Alyssa", "Hutton", dep80));
        result.add(new EmployeeTO(176, "Jonathon", "Taylor", dep80));
        result.add(new EmployeeTO(177, "Jack", "Livingston", dep80));
        result.add(new EmployeeTO(178, "Kimberely", "Grant", null));
        result.add(new EmployeeTO(179, "Charles", "Johnson", dep80));
        result.add(new EmployeeTO(180, "Winston", "Taylor", dep50));
        result.add(new EmployeeTO(181, "Jean", "Fleaur", dep50));
        result.add(new EmployeeTO(182, "Martha", "Sullivan", dep50));
        result.add(new EmployeeTO(183, "Girard", "Geoni", dep50));
        result.add(new EmployeeTO(184, "Nandita", "Sarchand", dep50));
        result.add(new EmployeeTO(185, "Alexis", "Bull", dep50));
        result.add(new EmployeeTO(186, "Julia", "Dellinger", dep50));
        result.add(new EmployeeTO(187, "Anthony", "Cabrio", dep50));
        result.add(new EmployeeTO(188, "Kelly", "Chung", dep50));
        result.add(new EmployeeTO(189, "Jennifer", "Dilly", dep50));
        result.add(new EmployeeTO(190, "Timothy", "Gates", dep50));
        result.add(new EmployeeTO(191, "Randall", "Perkins", dep50));
        result.add(new EmployeeTO(192, "Sarah", "Bell", dep50));
        result.add(new EmployeeTO(193, "Britney", "Everett", dep50));
        result.add(new EmployeeTO(194, "Samuel", "McCain", dep50));
        result.add(new EmployeeTO(195, "Vance", "Jones", dep50));
        result.add(new EmployeeTO(196, "Alana", "Walsh", dep50));
        result.add(new EmployeeTO(197, "Kevin", "Feeney", dep50));
        result.add(new EmployeeTO(198, "Donald", "OConnell", dep50));
        result.add(new EmployeeTO(199, "Douglas", "Grant", dep50));
        result.add(new EmployeeTO(200, "Jennifer", "Whalen", dep10));
        result.add(new EmployeeTO(201, "Michael", "Hartstein", dep20));
        result.add(new EmployeeTO(202, "Pat", "Fay", dep20));
        result.add(new EmployeeTO(203, "Susan", "Mavris", dep40));
        result.add(new EmployeeTO(204, "Hermann", "Baer", dep70));
        result.add(new EmployeeTO(205, "Shelley", "Higgins", dep110));
        result.add(new EmployeeTO(206, "William", "Gietz", dep110));
        return result;
    }
}
