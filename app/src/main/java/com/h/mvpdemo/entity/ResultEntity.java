package com.h.mvpdemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * com.h.mvpdemo.entity/MvpDemo
 * 作者：Harvey on 2017/3/1 16:51
 * 邮箱：497823256@qq.com
 * 说明：
 * 修改：
 * 修改说明：
 */
public class ResultEntity implements Parcelable {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.message);
    }

    public ResultEntity() {
    }

    protected ResultEntity(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
    }

    public static final Creator<ResultEntity> CREATOR = new Creator<ResultEntity>() {
        @Override
        public ResultEntity createFromParcel(Parcel source) {
            return new ResultEntity(source);
        }

        @Override
        public ResultEntity[] newArray(int size) {
            return new ResultEntity[size];
        }
    };
}
