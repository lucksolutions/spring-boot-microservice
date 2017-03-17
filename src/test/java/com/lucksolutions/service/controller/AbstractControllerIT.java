package com.lucksolutions.service.controller;

import javax.net.ssl.SSLContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.lucksolutions.service.AbstractIT;
import com.lucksolutions.service.controller.AbstractControllerIT.RestClientConfig;

@Import(RestClientConfig.class)
public abstract class AbstractControllerIT extends AbstractIT {

	@TestConfiguration
	static class RestClientConfig {

		protected final Log logger = LogFactory.getLog(getClass());

		@Value("${client.ssl.key-store}")
		private Resource clientKeystore;

		@Value("${client.ssl.key-store-password}")
		private String clientKeystorePassword;

		@Value("${client.ssl.key-password}")
		private String clientKeyPassword;

		@Value("${server.ssl.trust-store}")
		private Resource trustKeystore;

		@Value("${server.ssl.trust-store-password}")
		private String trustKeystorePassword;

		@Bean
		public RestTemplateBuilder mutualSSLRestTemplateBuilder() throws Exception {
			SSLContext sslcontext = SSLContexts
					.custom()
					.loadKeyMaterial(clientKeystore.getFile(),
							clientKeystorePassword.toCharArray(),
							clientKeyPassword.toCharArray())
					.loadTrustMaterial(trustKeystore.getFile(),
							trustKeystorePassword.toCharArray(),
							new TrustSelfSignedStrategy())
					.build();

			CloseableHttpClient httpClient = HttpClientBuilder.create()
					.setSSLContext(sslcontext)
					.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
					.build();

			return new RestTemplateBuilder()
					.requestFactory(new HttpComponentsClientHttpRequestFactory(
							httpClient));
		}
		
		@Bean
		RestTemplate restTemplate() throws Exception {
			return mutualSSLRestTemplateBuilder().build();
		}
	}

}
