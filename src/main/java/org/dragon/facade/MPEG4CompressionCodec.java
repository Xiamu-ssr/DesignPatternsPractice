package org.dragon.facade;

/**
 * mpeg4压缩编解码器
 *
 * @author mumu
 * @date 2024/06/08
 */
public class MPEG4CompressionCodec implements Codec{
    public final String type = "mp4";
    @Override
    public byte[] decode(VideoFile file) {
        System.out.println("MPEG4CompressionCodec: decoding mp4 file...");
        // 解码逻辑
        return new byte[0]; // 返回解码后的数据
    }

    @Override
    public byte[] encode(byte[] data) {
        System.out.println("MPEG4CompressionCodec: encoding to mp4 format...");
        // 编码逻辑
        return new byte[0]; // 返回编码后的数据
    }
}
