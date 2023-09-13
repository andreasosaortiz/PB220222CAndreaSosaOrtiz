package ar.edu.unlam.tallerweb1.delivery;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;


public class ControladorRegistroTest {

    ControladorRegistro controladorRegistro = new ControladorRegistro();
    ModelAndView mav;

    @Test
    public void siElMailNoTieneFormatoCorrectoElRegistroFalla(){
        String email = "flor@";
        givenNoExisteUsuario();
        mav = whenCreoUsuarioConEmail(email);
        thenElRegistroFalla(mav);
    }
    @Test
    public void siElMailTieneFormatoCorrectoElRegistroEsExitoso(){
        String email = "flor@gmail.com";
        givenNoExisteUsuario();
        mav = whenCreoUsuarioConEmail(email);
        thenElRegistroEsExitoso(mav);
    }

    private void thenElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Usuario creado correctamente");
        assertThat(mav.getViewName()).isEqualTo("login");
    }

    private void givenNoExisteUsuario() {
    }
    private ModelAndView whenCreoUsuarioConEmail(String email) {
        return controladorRegistro.crearUsuario(email);
    }
    private void thenElRegistroFalla(ModelAndView mav) {
        assertThat(mav.getModel().get("mensaje")).isEqualTo("El email o contraseña es incorrecto");
        assertThat(mav.getViewName()).isEqualTo("registro-usuario");
    }




}
