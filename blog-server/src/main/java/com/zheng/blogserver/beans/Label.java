package com.zheng.blogserver.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Label {

    private Integer labelId;
    private String labelName;
    private String labelAlias;
    private String labelDescription;
}
