package com.jinstec.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 软件链接
 * @author jins
 * @date on 2018/5/2.
 */
@Data
@ApiModel(description = "软件链接")
public class SoftwareLinkDto {

    @ApiModelProperty(name = "id",value = "唯一标识符")
    private String id = "";

    @NotEmpty(message = "标题不能为空")
    @ApiModelProperty(name = "title",value = "标题", required = true)
    private String title;

    @NotEmpty(message = "作者不能为空")
    @ApiModelProperty(name = "author",value = "作者",required = true)
    private String author;

    @ApiModelProperty(name = "keyword",value = "关键字")
    private String keyword;

    @ApiModelProperty(name = "type",value = "类型")
    private String type;

}
