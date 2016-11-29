package me.kushalc.stitch;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kushal on 11/27/16.
 */

//Data stored for every single item

public class Item implements Parcelable {

    //Manufacturer
    private String brand = "";
    //What it is called
    private String itemName = "";
    //What it is (i.e shirt or pants or dress)
    private String type = "";
    //What physical location it is stored in
    private String location = "";
    //Is it favorited
    private boolean favorite = false;
    //Is it discounted
    private boolean discount = false;
    //Price and discounted price
    private double price = 0;
    private double discountedPrice = 0;
    //To store all product images
    ArrayList<byte[]> mImageBitmaps = new ArrayList<>();
    //To store colors & sizes possibilities
    HashMap<String,Integer> clothingOptions = new HashMap<String,Integer>();

    public Item(String brand, String itemName, String type, String location, boolean favorite,
                boolean discount, double price, double discountedPrice, ArrayList<byte[]> imageViews,
                HashMap<String, Integer> clothingOptions) {

        this.brand = brand;
        this.itemName = itemName;
        this.type = type;
        this.location = location;
        this.favorite = favorite;
        this.discount = discount;
        this.price = price;
        this.discountedPrice = discountedPrice;
        mImageBitmaps = imageViews;
        this.clothingOptions = clothingOptions;
    }

    public Item()
    {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public ArrayList<byte[]> getImageViews() {
        return mImageBitmaps;
    }

    public void setImageViews(ArrayList<byte[]> imageViews) {
        mImageBitmaps = imageViews;
    }

    public HashMap<String, Integer> getClothingOptions() {
        return clothingOptions;
    }

    public void setClothingOptions(HashMap<String, Integer> clothingOptions) {
        this.clothingOptions = clothingOptions;
    }

    protected Item(Parcel in) {
        brand = in.readString();
        itemName = in.readString();
        type = in.readString();
        location = in.readString();
        favorite = in.readByte() != 0x00;
        discount = in.readByte() != 0x00;
        price = in.readDouble();
        discountedPrice = in.readDouble();
        if (in.readByte() == 0x01) {
            mImageBitmaps = new ArrayList<byte[]>();
            in.readList(mImageBitmaps, byte[].class.getClassLoader());
        } else {
            mImageBitmaps = null;
        }
        clothingOptions = (HashMap) in.readValue(HashMap.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brand);
        dest.writeString(itemName);
        dest.writeString(type);
        dest.writeString(location);
        dest.writeByte((byte) (favorite ? 0x01 : 0x00));
        dest.writeByte((byte) (discount ? 0x01 : 0x00));
        dest.writeDouble(price);
        dest.writeDouble(discountedPrice);
        if (mImageBitmaps == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mImageBitmaps);
        }
        dest.writeValue(clothingOptions);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}