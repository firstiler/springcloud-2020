package com.firstile.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // init getter setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String massage;
    private T data;

    public CommonResult(Integer code, String massage){
        this(code, massage, null);
    }

}
