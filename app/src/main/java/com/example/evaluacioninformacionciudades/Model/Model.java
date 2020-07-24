package com.example.evaluacioninformacionciudades.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Model {
    String name, alpha2Code,alpha3Code;

        public Model(String name, String alpha2Code, String alpha3Code) {
            this.name = name;
            this.alpha2Code = alpha2Code;
            this.alpha3Code = alpha3Code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlpha2Code() {
            return alpha2Code;
        }

        public void setAlpha2Code(String alpha2Code) {
            this.alpha2Code = alpha2Code;
        }

        public String getAlpha3Code() {
            return alpha3Code;
        }

        public void setAlpha3Code(String alpha3Code) {
            this.alpha3Code = alpha3Code;
        }


    public Model(JSONObject jsonObject) throws JSONException {
        name=jsonObject.getString("name").toString();
        alpha2Code=jsonObject.getString("alpha2Code").toString();
    }

    public static ArrayList<Model> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Model> pais = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            pais.add(new Model(datos.getJSONObject(i)));
        }
        return pais;
    }
}
