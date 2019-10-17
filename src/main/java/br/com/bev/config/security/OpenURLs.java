package br.com.bev.config.security;

public class OpenURLs {

    public final static String[] URLS = {
            "/",
            "/auth",
            "/swagger",

            "/organizador/cadastrar",
            "/organizador/{*}",
            "/organizador/{*}/viagens",

            "/turista/cadastrar",
            "/turista/{*}",

            "/viagem/cadastrar",
            "/viagem/retrieve",
            "/viagem/{*}",

            "/token/getUser",

            "/h2-console/*"
    };
}
