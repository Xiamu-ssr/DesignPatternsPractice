package org.dragon.facade;

/**
 * 视频转换
 *
 * @author mumu
 * @date 2024/06/08
 */
public class VideoConvert {
    public static byte[] decode(VideoFile file, Codec codec) {
        System.out.println("VideoConvert: decoding file...");
        return codec.decode(file);
    }

    public static byte[] encode(byte[] data, Codec codec) {
        System.out.println("VideoConvert: encoding file...");
        return codec.encode(data);
    }
}
