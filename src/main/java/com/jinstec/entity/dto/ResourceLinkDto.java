package com.jinstec.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 资源链接
 * @author jins
 * @date on 2018/5/2.
 */
@Data
@ApiModel(description = "资源链接")
public class ResourceLinkDto {

    @ApiModelProperty(name = "id",value = "唯一标识符")
    private String id = "";

    @NotEmpty(message = "标题不能为空")
    @ApiModelProperty(name = "title",value = "标题", required = true)
    private String title;

    @NotEmpty(message = "作者不能为空")
    @ApiModelProperty(name = "author",value = "作者",required = true)
    private String author;

    @ApiModelProperty(name = "keyWord",value = "关键字")
    private String keyWord;

    @ApiModelProperty(name = "type",value = "类型")
    private String type;

    @ApiModelProperty(name = "url",value = "资源链接")
    private String url;

    @ApiModelProperty(name = "remarks",value = "评论")
    private String remarks;
}
