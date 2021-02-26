package com.zheng.blogserver.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sort {

    private Integer sortId;
    private String sortName;
    private String sortAlias;
    private String sortDescription;
    private Integer parentSortId;
}
