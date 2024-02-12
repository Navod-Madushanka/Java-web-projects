package com.navod.web.nmshop.dto;

public class AuthResponseDTO {
    private String userType;
    private String accessToken;
    private String refreshToken;
    private String expireIn;

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(String userType ,String accessToken, String refreshToken, String expireIn) {
        this.userType = userType;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expireIn = expireIn;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(String expireIn) {
        this.expireIn = expireIn;
    }
}
