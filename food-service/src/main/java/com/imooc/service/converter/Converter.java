package com.imooc.service.converter;

/**
 * Created by lihu on 2020/10/26.
 * 模型和Entity相互转换接口
 *
 * @author lihu
 * @date 2020/10/26
 */
public interface Converter<M, E> {
    /**
     * 模型正向转换为Entity
     *
     * @param m
     * @return
     */
    E doForward(M m);

    /**
     * Entity逆向转换为模型
     *
     * @param e
     * @return
     */
    M doBackward(E e);
}
