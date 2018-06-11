package com.jinstec.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author jins
 * @date on 2018/5/2.
 */
@Data
@ApiModel(description = "学习链接数据")
public class LearningLinkDto {

    @ApiModelProperty(name = "id",value = "唯一标识符")
    private String id;

    @NotEmpty(message = "文章标题不能为空")
    @ApiModelProperty(name = "title",value = "文章标题",required = true)
    private String title;

    @NotEmpty
    @ApiModelProperty(name = "author",value = "作者",required = true)
    private String author;

    @NotEmpty(message = "路径不能为空")
    @JsonProperty(value = "articleURL")
    @ApiModelProperty(name = "url",value = "文章路径",required = true)
    private String url;

    @NotEmpty(message = "文章类型不能为空")
    @JsonProperty(value = "articleType")
    @ApiModelProperty(name = "type",value = "文章类型",required = true)
    private String type;

    @ApiModelProperty(name = "keyword",value = "关键字",required = true)
    private String keyword;
}
