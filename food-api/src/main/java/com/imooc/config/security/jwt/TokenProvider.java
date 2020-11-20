package com.imooc.config.security.jwt;

import com.alibaba.fastjson.JSON;
import com.imooc.common.exception.JwtExpiredException;
import com.imooc.common.exception.JwtInvalidException;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import lombok.extern.log4j.Log4j2;

import java.text.ParseException;

/**
 * Created by 1449488533qq@gmail.com on 2020/11/19.
 *
 * @author lihu
 * @date 2020/11/19
 */
@Log4j2
public class TokenProvider {
    private final String secretKey;

    public TokenProvider(String secretKey) {
        this.secretKey = secretKey;
    }

    public String createToken(String subject) throws JOSEException {
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256).type(JOSEObjectType.JWT).build();
        Payload payload = new Payload(subject);
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        JWSSigner jwsSigner = new MACSigner(secretKey);
        jwsObject.sign(jwsSigner);
        return jwsObject.serialize();
    }

    public PayloadModel verifyToken(String token) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            JWSVerifier jwsVerifier = new MACVerifier(secretKey);
            if (!jwsObject.verify(jwsVerifier)) {
                throw new JwtInvalidException("token不合法");
            }
            String payload = jwsObject.getPayload().toString();
            PayloadModel payloadModel = JSON.parseObject(payload, PayloadModel.class);
            if (payloadModel.getExpireTime() <= System.currentTimeMillis()) {
                throw new JwtExpiredException("token已经过期");
            }
            return payloadModel;

        } catch (ParseException | JOSEException parseException) {
            return null;
        }
    }

}
