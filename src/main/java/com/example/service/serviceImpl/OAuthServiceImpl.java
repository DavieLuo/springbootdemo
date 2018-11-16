package com.example.service.serviceImpl;

import com.example.service.ClientService;
import com.example.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OAuthServiceImpl implements OAuthService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    ClientService clientService;

    @Override
    public void addAuthCode(String authCode, String username) {
        redisTemplate.opsForValue().set(authCode,username,60*15, TimeUnit.SECONDS);
    }

    @Override
    public void addAccessToken(String accessToken, String username) {
        redisTemplate.opsForValue().set(accessToken,username,getExpireIn(), TimeUnit.SECONDS);
    }

    @Override
    public boolean checkAuthCode(String authCode) {
        return redisTemplate.opsForValue().get(authCode)!=null;
    }

    @Override
    public boolean checkAccessToken(String accessToken) {
        return redisTemplate.opsForValue().get(accessToken)!=null;
    }

    @Override
    public String getUsernameByAuthCode(String authCode) {
        return redisTemplate.opsForValue().get(authCode).toString();
    }

    @Override
    public String getUsernameByAccessToken(String accessToken) {
        return redisTemplate.opsForValue().get(accessToken).toString();
    }

    @Override
    public long getExpireIn() {
        return 3600;
    }

    @Override
    public boolean checkClientId(String clientId) {
        return clientService.findByClientId(clientId)!=null;
    }

    @Override
    public boolean checkClientSecret(String clientSecret) {
        return clientService.findByClientSecret(clientSecret)!=null;
    }
}
