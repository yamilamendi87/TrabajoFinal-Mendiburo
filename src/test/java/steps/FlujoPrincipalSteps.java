package steps;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class FlujoPrincipalSteps {
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;
    private final PIMPage pimPage;

    public FlujoPrincipalSteps() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.pimPage = new PIMPage(driver);
    }

    @Dado("que el usuario está en la página de login de OrangeHRM")
    public void queElUsuarioEstaEnLaPaginaDeLoginDeOrangeHRM() {
        loginPage.gotoPage();
    }

    @Cuando("ingresa el usuario {string} y la contraseña {string}")
    public void ingresaElUsuarioYLaContrasena(String usuario, String contrasena) {
        loginPage.enterUserName(usuario);
        loginPage.enterPassword(contrasena);
    }

    @Y("hace clic en el botón de login")
    public void haceClicEnElBotonDeLogin() {
        loginPage.clickLogin();
    }

    @Entonces("debería visualizar el Dashboard")
    public void deberiaVisualizarElDashboard() {
        Assert.assertTrue(dashboardPage.isOnDashboard(), "No se visualizó el Dashboard.");
    }

    @Dado("que el usuario ha iniciado sesión como {string} con contraseña {string}")
    public void queElUsuarioHaIniciadoSesionComoConContrasena(String usuario, String contrasena) {
        loginPage.gotoPage();
        loginPage.loginAs(usuario, contrasena);
        Assert.assertTrue(dashboardPage.isOnDashboard(), "No se pudo iniciar sesión en el Dashboard.");
    }

    @Cuando("navega al módulo PIM")
    public void navegaAlModuloPIM() {
        dashboardPage.goToPIM();
        Assert.assertTrue(pimPage.isOnPIMPage(), "No se navegó correctamente al módulo PIM.");
    }

    @Y("busca el empleado {string}")
    public void buscaElEmpleado(String nombreEmpleado) {
        pimPage.searchEmployeeByName(nombreEmpleado);
    }

    @Entonces("debería ver resultados de la búsqueda")
    public void deberiaVerResultadosDeLaBusqueda() {
        Assert.assertTrue(pimPage.hasResults(), "No se encontraron resultados en la búsqueda de empleados.");
    }

    @Cuando("navega al módulo PIM y busca el empleado {string}")
    public void navegaAlModuloPIMYBuscaElEmpleado(String nombreEmpleado) {
        dashboardPage.goToPIM();
        Assert.assertTrue(pimPage.isOnPIMPage(), "No se navegó correctamente al módulo PIM.");
        pimPage.searchEmployeeByName(nombreEmpleado);
    }

    @Y("cierra sesión en la aplicación")
    public void cierraSesionEnLaAplicacion() {
        dashboardPage.logout();
    }

    @Entonces("debería volver a la página de login")
    public void deberiaVolverALaPaginaDeLogin() {
        Assert.assertTrue(loginPage.isOnLoginPage(), "No se volvió a la página de login luego de cerrar sesión.");
    }
}