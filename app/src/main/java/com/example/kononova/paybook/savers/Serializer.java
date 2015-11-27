package com.example.kononova.paybook.savers;

import android.content.Context;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by devol on 27.11.15.
 */
public class Serializer {
    private final String FILE_NAME = "Payments";
    private File file = null;

    public void savePayment(Context context, JsonObject object){
        try{
            FileOutputStream fileOutputStream = context.openFileOutput(FILE_NAME, context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e){
            file = new File(context.getFilesDir(), FILE_NAME);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<JsonObject> getPaymentsArray(Context context){
//        JsonArray objects = null;
        List<JsonObject> objects = new ArrayList<>();
        JsonObject object;

        try {
            FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            do {
            object = (JsonObject)objectInputStream.readObject();
                objects.add(object);
            }
            while (object != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
