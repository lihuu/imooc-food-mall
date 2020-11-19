package com.imooc.config.security.jwt;

import com.google.common.collect.Lists;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.shaded.json.JSONValue;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/19.
 *
 * @author lihu
 * @date 2020/11/19
 */
public class UserAuthProvider extends TokenProvider {
    private static final String AUTH_ROLE_KEY = "AUTH_ROLE";
    private static final String DEFAULT_ROLE = "USER";

    private long expireTimeInSeconds;

    public UserAuthProvider(String secretKey, long expireTimeInSeconds) {
        super(secretKey);
        this.expireTimeInSeconds = expireTimeInSeconds;
    }

    public String createUserAuthToken(String userId, List<String> roleList) throws JOSEException {
        if (roleList == null) {
            roleList = Lists.newArrayList();
        }
        roleList.add(DEFAULT_ROLE);
        String roleString = String.join(",", roleList);
        PayloadModel payloadModel = PayloadModel.builder().userId(userId).roleString(roleString)
            .expireTime(System.currentTimeMillis() + 1000 * expireTimeInSeconds).build();
        return this.createToken(JSONValue.toJSONString(payloadModel));
    }

    public Authentication getAuthentication(PayloadModel payloadModel) {
        if (payloadModel != null) {
            List<String> roleList = Arrays.asList(payloadModel.getRoleString().split(","));
            List<GrantedAuthority> grantedAuthorityList =
                roleList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(payloadModel.getUserId(), "", grantedAuthorityList);
        }
        return null;
    }

}
