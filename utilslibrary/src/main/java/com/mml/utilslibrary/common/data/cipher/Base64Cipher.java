package com.mml.utilslibrary.common.data.cipher;


import com.mml.utilslibrary.common.assist.Base64;

/**
 * 项目名称：Library
 * Created by Long on 2018/10/15.
 * 修改时间：2018/10/15 13:14
 * @author Long
 */
public class Base64Cipher extends Cipher {
    private Cipher cipher;

    public Base64Cipher() {
    }

    public Base64Cipher(Cipher cipher) {
        this.cipher = cipher;
    }

    @Override
    public byte[] decrypt(byte[] res) {
        res = Base64.decode(res, Base64.DEFAULT);
        if (cipher != null) {
            res = cipher.decrypt(res);
        }
        return res;
    }

    @Override
    public byte[] encrypt(byte[] res) {
        if (cipher != null) {
            res = cipher.encrypt(res);
        }
        return Base64.encode(res, Base64.DEFAULT);
    }
}
