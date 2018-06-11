package com.jinstec.security;

import com.jinstec.entity.BackendAccount;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jins
 * @date on 2018/4/24.
 */
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    protected Log log = LogFactory.getLog(getClass());

    @Override
    public void setDefaultTargetUrl(String defaultTargetUrl){
        super.setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String refererUrl = request.getHeader("Referer");
        System.out.println("logout>>"+refererUrl);
        BackendAccount userDetails = (BackendAccount)authentication.getPrincipal();
        log.info("登出用户user:" + userDetails.getName() + "login"+request.getContextPath());
        System.out.println("登出用户user:" + userDetails.getName() + "login"+request.getContextPath());
        super.onLogoutSuccess(request, response, authentication);
    }
}
