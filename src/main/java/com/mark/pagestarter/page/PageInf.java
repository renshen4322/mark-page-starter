package com.mark.pagestarter.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName:
 * @Description: 分页信息
 * @Author: mark
 * @CreateDate: 2022/7/6 16:05
 * @Version: 1.0
 */
@Data
public class PageInf<T> implements Serializable {
    private static final long serialVersionUID = 4771765635432303633L;
    /**
     * 数据集
     */

    public List<T> list;

    /**
     * 总条数
     */

    public Long total;

    /**
     * 每页大小
     */

    public Integer size;

    /**
     * 当前页码
     */
    public Integer current;


    /**
     * 总页数
     */
    public Integer pages;
}
