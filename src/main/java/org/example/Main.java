package org.example;

import org.example.wrapper.JWTGenerator;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodes;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        RsaJsonWebKey rsaJsonWebKey = JWTGenerator.getInstance().getRsaJsonWebKey();

        JwtClaims claims = JWTGenerator.getInstance().getJwtClaims();

        String jwt = JWTGenerator.getInstance().getJwtSignature(rsaJsonWebKey, claims);

        JwtConsumer jwtConsumer = JWTGenerator.getInstance().getJwtConsumer(rsaJsonWebKey);

        JWTGenerator.getInstance().validate(jwt, jwtConsumer);
    }


}