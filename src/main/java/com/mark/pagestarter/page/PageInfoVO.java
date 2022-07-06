package com.mark.pagestarter.page;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页信息
 * @author mark
 * @date 2022-07-06 16:08
 */
public class PageInfoVO<T> implements Serializable {

    private static final long serialVersionUID = -1L;
    /**
     * 数据集
     */
    public List<T> list;

    /**
     * 总条数
     */
    public Long total;

    public PageInfoVO(){}

    private PageInfoVO(List<T> list, Long total){
        this.list = list;
        this.total = total;
    }

    public static <T> PageInfoVO<T> getInstance(List<T> list, Long total){
        return new PageInfoVO<>(list, total);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageInfoVO{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}
