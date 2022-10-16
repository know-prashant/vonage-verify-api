package com.example.vonage.auth.filters;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;

import java.util.Collection;

@Transient
public class AuthenticationFilter extends AbstractAuthenticationToken {
    private String apiKey;
    private String keySecret;

    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */

    public AuthenticationFilter(String apiKey, String keySecret, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.apiKey = apiKey;
        this.keySecret = keySecret;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return keySecret;
    }

    @Override
    public Object getPrincipal() {
        return apiKey;
    }
}
