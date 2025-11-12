package com.sena.springecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.springecommerce.model.Usuario;
import com.sena.springecommerce.service.IUsuarioService;

@RestController
@RequestMapping("/apiusuarios")

public class APIUsuarioController {
	@RestController
	@RequestMapping("/apiusuarios")
	public class APIUsuariotoController {

		@Autowired
		private IUsuarioService usuarioService;

		// Endpoint GET para obtener todos los usuarios
		@GetMapping("/list")
		public List<Usuario> getAllProducts() {
			return usuarioService.findAll();
		}

		// Endpoint GET para obtener un usuario por ID
		@GetMapping("/usuario/{id}")
		public ResponseEntity<Usuario> getUsuariotById(@PathVariable Integer id) {
			Optional<Usuario> usuario = usuarioService.get(id);
			return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

		}

		// Endpoint POST para crear un nuevo usuario

		@PostMapping("/create")
		public ResponseEntity<Usuario> createUsuarioEntity(@RequestBody Usuario usuario) {
			Usuario u = usuarioService.findById(1).get();
			usuario.setUsuario(u);
			if (usuario.getImagen() == null) {
				usuario.setImagen("default.jpg");
			}
			Usuario saveUsuario = usuarioService.save(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(saveUsuario);

		}

		// Endpoint PUT para actualizar un usuario

		@SuppressWarnings("null")
		@PutMapping("/update/{id}")
		public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioDetails) {
			Optional<Usuario> usuario = usuarioService.get(id);
			if (!usuario.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			Usuario existingUsuario = usuario.get();
			existingUsuario.setNombre(usuarioDetails.getNombre());
			existingUsuario.setDireccion(usuarioDetails.getDireccion());
			existingUsuario.setPrecio(usuarioDetails.getPrecio());
			existingUsuario.setCantidad(usuarioDetails.getCantidad());
			// Mantener la imagen existente a menos que se envie una nueva
			if (usuarioDetails.getImagen() != null) {
				existingUsuario.setImagen(usuarioDetails.getImagen());

			}

			usuarioService.update(existingUsuario);
			return ResponseEntity.ok(existingUsuario);

		}

		// Endpoint DELETE para eliminar un usuario
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> deleteUsuario(@PathVariable Integer id) {
			Optional<Usuario> usuario = Optional.empty();
			if (!usuario.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			Usuario u = usuario.get();
			if (!u.getImagen().equals("default.jpg")) {
				//

			}

			usuarioService.delete(id);
			return ResponseEntity.ok().build();

		}

	}

}
