package com.mj.myvedio.realm;

import com.mj.myvedio.utils.Response;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Component
public class LoginRealm extends AuthorizingRealm {

    private static String USERNAME = "666";
    private static String PASSWORD = "111";
    private static String ADMIN = "admin";
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1. 从 PrincipalCollection 中来获取登录用户的信息
        Object principal = principalCollection.getPrimaryPrincipal();
        // 2. 利用登录的用户的信息来..当前用户的角色或权限(可能需要查询数据库)
        Set<String> roles = new HashSet<>();
        roles.add("user");
        if (ADMIN.equals(principal)) {
            roles.add(ADMIN);
        }
        // 3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        // 4. 返回 SimpleAuthorizationInfo 对象.
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        // 取出表单用户名
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        // 查询是否有该用户

        if(StringUtils.isEmpty(username) || !username.equals(USERNAME)){
            throw new UnknownAccountException("用户不存在!");
        }
        // 密码错误
        if (!password.equals(PASSWORD)) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        // 传入:用户名,加密后的密码,盐值,该realm的名字，加密算法和加密次数在已经在配置文件中指定
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, PASSWORD,
                ByteSource.Util.bytes(username), getName());
        return info;
    }
}
