package br.com.bev.dto;

public class AuthenticationTokenOutputDTO {

    private String tokenType;
    private String token;

    public AuthenticationTokenOutputDTO(String tokenType, String token){
        this.tokenType = tokenType;
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    public String getTokenType(){
        return tokenType;
    }
}
