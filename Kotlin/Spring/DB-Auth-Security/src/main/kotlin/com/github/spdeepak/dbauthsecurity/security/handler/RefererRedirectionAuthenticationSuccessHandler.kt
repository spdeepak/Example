package com.github.spdeepak.dbauthsecurity.security.handler

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component

@Component
class RefererRedirectionAuthenticationSuccessHandler : SimpleUrlAuthenticationSuccessHandler {
    constructor() : super() {
        setUseReferer(true)
    }
}
