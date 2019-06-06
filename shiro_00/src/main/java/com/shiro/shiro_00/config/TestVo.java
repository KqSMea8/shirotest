package com.shiro.shiro_00.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class TestVo extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        String password = new String(passwordToken.getPassword());
        String credentials = (String) info.getCredentials();
        return this.equals(password, credentials);
    }
}
