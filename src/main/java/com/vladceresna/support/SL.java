package com.vladceresna.support;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.vladceresna.netufos.pojos.school.School;

import java.util.ArrayList;

public class SL {//SupportLib
    public static Object JtO(Object json, Class c){//JSON to Object
        return new Gson().fromJson((String) json,c);
    }
    public static ArrayList<?> JtAO(Object json, TypeToken typeToken){//JSON to Array Object
        return (ArrayList<?>) new Gson().fromJson((String) json, typeToken);
    }
    public static ArrayList<School> JtASO(Object json){//JSON to Array School Object
        return (ArrayList<School>) JtAO(json,new TypeToken<ArrayList<School>>(){});
    }
    public static Object OtJ(Object obj) {//Object to JSON
        return new Gson().toJson(obj);
    }
    public static Object OtPJ(Object obj) {//Object to Pretty JSON
        return new GsonBuilder().setPrettyPrinting().create().toJson(obj);
    }
    public static Object JtPJ(Object obj) {//JSON to Pretty JSON
        return new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse((String) obj));
    }
}
