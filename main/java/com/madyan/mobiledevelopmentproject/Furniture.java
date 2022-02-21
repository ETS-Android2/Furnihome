package com.madyan.mobiledevelopmentproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Furniture implements Parcelable
{
    private String furniture;
    private String furniturePrice;
    private String furnitureDescription;
    private int furnitureImageId;
    private int furnitureObjId;

    protected Furniture(Parcel in) {
        furniture = in.readString();
        furniturePrice = in.readString();
        furnitureImageId = in.readInt();
        furnitureDescription = in.readString();
    }

    public static final Creator<Furniture> CREATOR = new Creator<Furniture>() {
        @Override
        public Furniture createFromParcel(Parcel in) {
            return new Furniture(in);
        }

        @Override
        public Furniture[] newArray(int size) {
            return new Furniture[size];
        }
    };

    public String getFurniture() {
        return furniture;
    }

    public String getFurniturePrice() {
        return furniturePrice;
    }

    public String getFurnitureDescription() {
        return furnitureDescription;
    }

    public int getFurnitureImageId() {
        return furnitureImageId;
    }

    public Furniture(String furniture, String furniturePrice, int furnitureImageId, String furnitureDescription) { //, int furnitureObjId, int furnitureMtlId
        this.furniture = furniture;
        this.furniturePrice = furniturePrice;
        this.furnitureImageId = furnitureImageId;
        this.furnitureDescription = furnitureDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(furniture);
        parcel.writeString(furniturePrice);
        parcel.writeInt(furnitureImageId);
        parcel.writeString(furnitureDescription);
    }

    public int getFurnitureObjId() {
        return furnitureObjId;
    }

    public void setFurnitureObjId(int furnitureObjId) {
        this.furnitureObjId = furnitureObjId;
    }
}
