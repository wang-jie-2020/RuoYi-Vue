package com.ruoyi.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import com.ruoyi.common.utils.StringUtils;

/**
 * Repeatable 过滤器
 *     --> 1.通过FilterRegistrationBean 注册 (也可通过xml注册)
 *       {@link com.ruoyi.framework.config.FilterConfig#someFilterRegistration()}
 *
 *     --> 2.如果对 inputStream 进行读取需要回拨
 *      {@link RepeatedlyRequestWrapper}
 *
 *     --> 3.它的优先级为什么是 FilterRegistrationBean.LOWEST_PRECEDENCE?
 *
 *     --> 4. interceptor如果读了body,也会有wrapper需求?
 *          是的
 *
 * @author ruoyi
 */
public class RepeatableFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        ServletRequest requestWrapper = null;
        if (request instanceof HttpServletRequest
                && StringUtils.startsWithIgnoreCase(request.getContentType(), MediaType.APPLICATION_JSON_VALUE))
        {
            requestWrapper = new RepeatedlyRequestWrapper((HttpServletRequest) request, response);
        }
        if (null == requestWrapper)
        {
            chain.doFilter(request, response);
        }
        else
        {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void destroy()
    {

    }
}
