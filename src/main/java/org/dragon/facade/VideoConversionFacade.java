package org.dragon.facade;

import java.io.File;

/**
 * 视频转换外观
 *
 * @author mumu
 * @date 2024/06/08
 */
public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        //获取源编解码器
        VideoFile videoFile = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(videoFile);
        //获取目标编解码器
        Codec destinationCodec;
        if ("mp4".equals(format)){
            destinationCodec = new MPEG4CompressionCodec();
        }else {
            destinationCodec = new OggCompressionCodec();
        }
        //转化
        //转化为中间表示
        byte[] bytes = VideoConvert.decode(videoFile, sourceCodec);
        byte[] encode = VideoConvert.encode(bytes, destinationCodec);
        //修复音频
        File result = (new AudioMixer()).fix(encode);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
