package com.ruoyi.framework.interceptor;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ServletUtils;

/**
 * 防止重复提交拦截器
 *  疑问:
 *    (1)这是个抽象类,它标记了@Component是否会注册?
 *      demo验证下来不会
 *    (2)SameUrlDataInterceptor extends RepeatSubmitInterceptor 就注册了 类型是<RepeatSubmitInterceptor> 实例类型是SameUrlDataInterceptor的Bean?
 *      是的,并且只会默认在RepeatSubmitInterceptor.class下拿到实例,在HandlerInterceptor.class下拿不到,除非再implements HandlerInterceptor

 *    (3) handler 参数是什么意思 --> 拦截的controller
 *    (4) 有3个方法而不是2个,,pre不提,post会是200才到的吗? --> 是
 *    (5) 如果未回拨inputStream,会怎么样? --> 会报错...
 * @author ruoyi
 */
@Component
public abstract class RepeatSubmitInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        if (handler instanceof HandlerMethod)
        {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if (annotation != null)
            {
                if (this.isRepeatSubmit(request, annotation))
                {
                    AjaxResult ajaxResult = AjaxResult.error(annotation.message());
                    ServletUtils.renderString(response, JSON.toJSONString(ajaxResult));
                    return false;
                }
            }
            return true;
        }
        else
        {
            return true;
        }
    }

    /**
     * 验证是否重复提交由子类实现具体的防重复提交的规则
     *
     * @param request 请求信息
     * @param annotation 防重复注解参数
     * @return 结果
     * @throws Exception
     */
    public abstract boolean isRepeatSubmit(HttpServletRequest request, RepeatSubmit annotation);
}
