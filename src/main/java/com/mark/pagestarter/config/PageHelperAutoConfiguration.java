package com.mark.pagestarter.config;

import com.mark.pagestarter.utils.PageInfoUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author mark
 * @Description:
 * @date 2022-07-6 15:41
 */
@Configuration
@Import(PageInfoUtils.class)
public class PageHelperAutoConfiguration {

}
