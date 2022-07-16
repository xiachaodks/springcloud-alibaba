package com.xiachao.springcloud.myHandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiachao.springcloud.entities.CommonResult;

/**
 * @author: xiachao
 * @Date: 2022-07-16 20:41
 * @Description: 用户自定义handler
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2022, "自定义的限流处理信息......CustomerBlockHandler");
    }
    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2022, "自定义的限流处理信息......CustomerBlockHandler2");
    }

}
