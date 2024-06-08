package org.dragon.facade;

/**
 * 编解码器接口
 *
 * @author mumu
 * @date 2024/06/08
 */
public interface Codec {
    /**
     * 解码
     *
     * @param file 文件
     * @return {@link byte[]}
     */
    byte[] decode(VideoFile file);

    /**
     * 编码
     *
     * @param data 数据
     * @return {@link byte[]}
     */
    byte[] encode(byte[] data);
}
