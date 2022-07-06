package com.mark.pagestarter.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mark.pagestarter.page.ExtBeansUtils;
import com.mark.pagestarter.page.PageInfoVO;
import com.mark.pagestarter.page.PageRequest;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
* @Description:    分页工具
* @Author:         zero
* @date:           2022/4/21 15:35
*/
@AutoConfigurationPackage
public class PageInfoUtils {

    /**
     * 分页方法
     * @param page     请求参数
     * @param supplier 查询函数式
     * @param <T>      查询对象model
     * @return
     */
    public <T> PageInfoVO<T> execute(PageRequest page, Supplier<List<T>> supplier) {
        PageInfo<T> of = of(page.getCurrent(), page.getSize(), supplier);
        return getInstance(of.getList(), of.getTotal());
    }

    /**
     * 分页方法
     * @param page        请求参数
     * @param targetClass 目标对象
     * @param supplier    查询函数式
     * @param <T>         查询对象model
     * @param <V>         目标对象model
     * @return
     */
    public <T, V> PageInfoVO<V> execute(PageRequest page, Class<V> targetClass, Supplier<List<T>> supplier) {
        PageInfo<T> pageInfo = of(page.getCurrent(), page.getSize(), supplier);
        List<V> targetList = ExtBeansUtils.map(pageInfo.getList(), targetClass);
        return getInstance(targetList, pageInfo.getTotal());
    }

    /**
     * 封装对象
     * @param list
     * @param total
     * @param <T>
     * @return
     */
    public <T> PageInfoVO<T> getInstance(List<T> list, Long total){
        PageInfoVO<T> vo = new PageInfoVO<>();
        vo.setTotal(total);
        vo.setList(list);
        return vo;
    }

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @param supplier
     * @param <T>
     * @return
     */
    private <T> PageInfo<T> of(Integer pageNum, Integer pageSize, Supplier<List<T>> supplier) {
        pageNum = transformation(pageNum, 1);
        pageSize = transformation(pageSize, 20);
        PageHelper.startPage(pageNum, pageSize);
        List<T> ts = supplier.get();
        return PageInfo.of(ts);
    }

    private int transformation(Integer num, int defaultNum){
        return Objects.isNull(num) ? defaultNum : Math.abs(num);
    }
}
