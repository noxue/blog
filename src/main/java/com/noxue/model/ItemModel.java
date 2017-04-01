package com.noxue.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by noxue on 2017/4/1.
 */
public class ItemModel {

    private Long id;

    @NotNull
    @Range(min = 1, message = "必须选择一个分类")
    private Long typeId;

    private Integer orderId;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String urlName;

    @NotEmpty
    @NotNull
    @Size(min=3, max=255)
    private String title;

    @NotEmpty
    @NotNull
    @Size(min=3, max=255)
    private String seoTitle="";

    @NotEmpty
    @NotNull
    @Size(min=3, max=255)
    private String seoKeywords="";

    @NotEmpty
    @NotNull
    @Size(min=3, max=255)
    private String seoDescription="";

    @NotEmpty
    @NotNull
    @Lob
    private String contentText;

    private String contentHtml;

    private Date createdAt;

    @Range(min = 1)
    private Long prevId;

    @Range(min = 1)
    private Long nextId;
}
