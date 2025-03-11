package com.user.UserServiceCapstone2025;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.util.UUID;


@SpringBootTest
class UserServiceCapstone2025ApplicationTests {

	RegisteredClientRepository registeredClientRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder;


	public UserServiceCapstone2025ApplicationTests(RegisteredClientRepository registeredClientRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.registeredClientRepository = registeredClientRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Test
	void contextLoads() {
	}

	// This is abusing, we should avoid this.
//	@Test
//	void addSampleClientToDB() {
//		RegisteredClient scalerClient = RegisteredClient.withId(UUID.randomUUID().toString())
//				.clientId("scaler-client")
//				.clientSecret(bCryptPasswordEncoder.encode("secret"))
//				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//				.redirectUri("http://127.0.0.1:8081/login/oauth2/code/scaler-client")
//				.postLogoutRedirectUri("http://127.0.0.1:8081/")
//				.scope(OidcScopes.OPENID)
//				.scope(OidcScopes.PROFILE)
////				We can create our own scopes here for the requests
//				.scope("USER_EMAIL")
//				.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//				.build();
//
//		registeredClientRepository.save(scalerClient);
//	}
}