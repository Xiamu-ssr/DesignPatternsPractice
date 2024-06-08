package org.dragon.facade;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 视频文件
 *
 * @author mumu
 * @date 2024/06/08
 */
@Getter
public class VideoFile {
    private String name;
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }
}
