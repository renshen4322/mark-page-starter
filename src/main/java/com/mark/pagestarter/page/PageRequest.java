package com.mark.pagestarter.page;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 请求分页信息
 */
@Setter
@Getter
public class PageRequest {
    /**
     * 当前页码
     */
    @NotNull(message = "当前页不能为空")
    @Min(value = 0, message = "请求页必须大于等于0")
    private Integer current;

    /**
     * 每页条数
     */
    @NotNull(message = "每页显示条数不能为空")
    @Max(value = 200, message = "每页最大条数不能超过200")
    private Integer size;
}
