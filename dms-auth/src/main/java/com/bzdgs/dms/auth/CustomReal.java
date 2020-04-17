package com.bzdgs.dms.auth;

import com.bzdgs.dms.domain.Employee;
import com.bzdgs.dms.domain.User;
import com.bzdgs.dms.service.IPermissionService;
import com.bzdgs.dms.service.IUserService;
import com.bzdgs.dms.tool.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public class CustomReal extends AuthorizingRealm {


    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    /**
     * 授权  权限判断
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份认证成功之后的主体对象
        Employee employee = (Employee) principalCollection.getPrimaryPrincipal();

        //Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();

        //获取用户id
        Long id = employee.getId();

        //通过用户id去查询该用户拥有哪些权限
        Set<String> permissions = permissionService.findPermissionsByEmployeeId(id);
        //创建一个SimpleAuthorizationInfo对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //将通过用户id查询到的他拥有的那些权限授权给当前用户
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从 token中获取用户名
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //根据用户名查询数据库中的信息
        String username=token.getUsername();
        User user = userService.getByUsername(username);
        //判断是否为空
        if (user==null){
            throw new UnknownAccountException(username);
        }
        //用户信息封装到 info对象返回
        Object principal=user;
        //密码加密
        Object hashedCredentilas=user.getPassword();
        ByteSource byteSource = ByteSource.Util.bytes("cn.itsource");
        String realName=getName();
        SimpleAuthenticationInfo info=
                new SimpleAuthenticationInfo(user,hashedCredentilas,byteSource,realName);
        return info;
    }

    public static void main(String[] args) {
        ByteSource credentialsSalt=ByteSource.Util.bytes("admin");
        String admin = MD5Util.getMD5Password("admin");
        System.out.println(credentialsSalt  +"-------"+admin);
    }

}
