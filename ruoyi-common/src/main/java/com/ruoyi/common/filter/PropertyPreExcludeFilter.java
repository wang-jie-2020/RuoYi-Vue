package com.ruoyi.common.filter;

import com.alibaba.fastjson2.annotation.JSONField;
import com.alibaba.fastjson2.filter.SimplePropertyPreFilter;

/**
 * 排除JSON敏感属性
 *   --> FastJson的序列化控制实现,和web-filter没有关系..
 *      --> 这里的作用是在记录log的过程中涉及到json序列化的时候 将对象中的敏感字段,比如密码等 忽略掉
 *         有些类似于 @JSONField(serialize = false)
 *
 * @author ruoyi
 */
public class PropertyPreExcludeFilter extends SimplePropertyPreFilter
{
    public PropertyPreExcludeFilter()
    {
    }

    public PropertyPreExcludeFilter addExcludes(String... filters)
    {
        for (int i = 0; i < filters.length; i++)
        {
            this.getExcludes().add(filters[i]);
        }
        return this;
    }
}
