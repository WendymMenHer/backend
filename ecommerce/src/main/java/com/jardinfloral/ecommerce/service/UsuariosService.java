package com.jardinfloral.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardinfloral.ecommerce.dto.ChangePassword;
import com.jardinfloral.ecommerce.model.Usuario;
import com.jardinfloral.ecommerce.repository.UsuariosRepository;

@Service
public class UsuariosService {
	private final UsuariosRepository usuariosRepository;

	@Autowired
	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}

	public List<Usuario> getAllUsuarios() {
		return usuariosRepository.findAll();
	}

	public Usuario getUsuario(Integer id) {
		return usuariosRepository.findById(id).orElseThrow(
			() -> new IllegalArgumentException("El usuario con el ID: [" + id + "] no existe."));
	}	

	public Usuario deleteUsuario(Integer id) {
		Usuario user = null;
		if(usuariosRepository.existsById(id)) {
			user = usuariosRepository.findById(id).get();
			usuariosRepository.deleteById(id);
		}
		return user;
	}

	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> user = usuariosRepository.findByCorreo(usuario.getCorreo());
		if(user.isEmpty()) {
			return usuariosRepository.save(usuario);
		}else {
			return null;
		}//else
		
	}//addUsuario

	//5. Update
		public Usuario updateUsuario(Integer id, ChangePassword changePassword) {
			Usuario user = null;
			if(usuariosRepository.existsById(id)) {
				Usuario usuario = usuariosRepository.findById(id).get();
				if(usuario.getPassword().equals(changePassword.getPassword())) {
				   usuario.setPassword(changePassword.getNpassword());
				   user=usuario;
				   usuariosRepository.save(usuario);
				}//Equals
			}//exist
			return user;
		}//update
}//class UsuariosService

