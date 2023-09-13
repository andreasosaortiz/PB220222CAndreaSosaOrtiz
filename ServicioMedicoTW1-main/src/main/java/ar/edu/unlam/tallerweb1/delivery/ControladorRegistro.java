package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorRegistro {

    @RequestMapping("/registro-usuario")
    public ModelAndView irAlRegistro(){
        ModelMap modelo = new ModelMap();

        modelo.put("datosRegistro", new DatosRegistroDTO());

        return new ModelAndView("registro-usuario", modelo);
    }


    public ModelAndView crearUsuario(String email) {
        ModelMap model = new ModelMap();
        String mensaje;
        String view;
        if (esEmailValido(email)){
            mensaje = "Usuario creado correctamente";
            view = "login";
        }else{
            mensaje = "El email o contraseña es incorrecto";
            view = "registro-usuario";
        }
        model.put("mensaje", mensaje);
        return new ModelAndView(view, model);
    }

    private boolean esEmailValido(String email){

        if (email.endsWith(".com") && email.contains("@")){
            return true;
        }else{
            return false;
        }
    }
}

