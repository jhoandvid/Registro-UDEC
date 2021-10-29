/*
PerfilRest
se genera la parte de rest, donde se agrega el mapeo de la rutas
y los metodos ya creados en la clase UsuarioService

28/10/2021
@jhoandrojas
 */
package co.edu.ucundinamarca.negocio.registro.rest;
import co.edu.ucundinamarca.negocio.registro.model.Usuario;
import co.edu.ucundinamarca.negocio.registro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/hotel/usuario")
public class UsuarioRest {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping ("/agregar")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        if(usuarioService.existsByLogin(usuario.getLogin()))
            return new ResponseEntity(new Mensaje("el usuario ya existe"), HttpStatus.BAD_REQUEST);
            usuarioService.guardar(usuario);
            return new ResponseEntity(new Mensaje("usuario creado"), HttpStatus.OK);


    }


}
