package com.bookstoremvc.app.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.bookstoremvc.app.entities.UserEntity;
import com.bookstoremvc.app.services.UserService;

@Component
public class AdditionalInformationToken implements TokenEnhancer {
	
	@Autowired
	private UserService userService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		UserEntity usuario = userService.findByUserName(authentication.getName());
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("info adicional", "Hola: ".concat(authentication.getName()));
		info.put("Nombre", usuario.getName());
		info.put("Apellido", usuario.getLastname());
		info.put("email", usuario.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
}
