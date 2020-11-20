package com.imooc.config;

import com.imooc.config.security.jwt.PayloadModel;
import com.imooc.config.security.jwt.UserAuthProvider;
import com.nimbusds.jose.JOSEException;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author lihu
 * @date 11/20/20 4:14 PM
 */
@Log4j2
public class UserAuthProviderTest {

    @Test
    public void createTokenTest() throws JOSEException {
        String secretKey = "gdsgldjoikjfhdkjghajkdfjlakdsfja;gakh";
        long expireTime = 1000L;
        UserAuthProvider userAuthProvider = new UserAuthProvider(secretKey, expireTime);
        String userId = "1234";
        List<String> roleList = Lists.list("ADMIN");
        String token = userAuthProvider.createUserAuthToken(userId, roleList);
        log.info(token);

        PayloadModel payloadModel = userAuthProvider.verifyToken(token);
        assert payloadModel != null;
        assert userId.equals(payloadModel.getUserId());
    }

}
