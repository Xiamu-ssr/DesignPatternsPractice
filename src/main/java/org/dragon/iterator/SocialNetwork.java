package org.dragon.iterator;

/**
 * 社交网络接口
 *
 * @author mumu
 * @date 2024/06/08
 */
public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
