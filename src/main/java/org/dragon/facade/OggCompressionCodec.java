package org.dragon.facade;

/**
 * Ogg压缩编解码器
 *
 * @author mumu
 * @date 2024/06/08
 */
public class OggCompressionCodec implements Codec{
    public final String type = "ogg";

    @Override
    public byte[] decode(VideoFile file) {
        System.out.println("OggCompressionCodec: decoding ogg file...");
        // 解码逻辑
        return new byte[0]; // 返回解码后的数据
    }

    @Override
    public byte[] encode(byte[] data) {
        System.out.println("OggCompressionCodec: encoding to ogg format...");
        // 编码逻辑
        return new byte[0]; // 返回编码后的数据
    }
}
