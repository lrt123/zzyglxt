package com.zyyglxt.dataobject;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class FileDO extends FileDOKey {

    @NotBlank(message = "数据源code不能为空")
    private String dataCode;
    @NotBlank(message = "上传人不能为空")
    private String uploader;
    @NotBlank(message = "上传人id不能为空")
    private String uploaderCode;
    private String fileName;
    private String fileType;
    private Double fileSize;
    private String filePath;

    private Date itemcreateat;

}