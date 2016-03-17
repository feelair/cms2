package com.turingoal.cms.core.commons;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

/**
 * 这个类主要处理登录失败后的处理，在登录失败后记录日志
 */
public class TgSecurityLoginFailureHandler4admin extends SimpleUrlAuthenticationFailureHandler implements InitializingBean {
    private final Logger log = LogManager.getLogger(TgSecurityLoginFailureHandler4admin.class);
    public static final Integer AUTHENTICATION_FAILURE_CODE = 401;

    private String failureUrl;
    private String usernameParameter = "username";

    public TgSecurityLoginFailureHandler4admin() {

    }

    public TgSecurityLoginFailureHandler4admin(final String defaultFailureUrlParm) {
        setDefaultFailureUrl(defaultFailureUrlParm);
    }

    /**
     * 认证失败
     */
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception) throws IOException, ServletException {
        SystemLogHelper.loginLog(request.getParameter(usernameParameter), "用户[登录]系统【失败】：" + exception.getLocalizedMessage()); // 登录失败日志
        if (this.failureUrl == null) {
            log.debug("没有配置defaultFailureUrl, sending 401 Unauthorized error");
            response.sendError(AUTHENTICATION_FAILURE_CODE, "认证失败: " + exception.getMessage());
        } else {
            saveException(request, exception);
            if (isUseForward()) {
                log.debug("登录失败，Forwarding 到页面 " + this.failureUrl);
                request.getRequestDispatcher(this.failureUrl).forward(request, response);
            } else {
                log.debug("登录失败，Redirecting 到页面 " + this.failureUrl);
                getRedirectStrategy().sendRedirect(request, response, this.failureUrl);
            }
        }
    }

    /**
     * setUsernameParameter
     */
    public void setUsernameParameter(final String usernameParameterParm) {
        Assert.hasText(usernameParameterParm, "Username 参数不能为空");
        this.usernameParameter = usernameParameterParm;
    }

    /**
     * setFailureUrl
     */
    public void setFailureUrl(final String failureUrlParm) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(failureUrlParm), "'" + failureUrlParm + "' 不是有效的 redirect URL");
        this.failureUrl = failureUrlParm;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet");
    }
}
