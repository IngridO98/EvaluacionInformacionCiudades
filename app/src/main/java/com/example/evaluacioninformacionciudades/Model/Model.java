package com.example.evaluacioninformacionciudades.Model;

public class Model {

    private Modelo[] Model;

    public Modelo[] getModel() {
        return Model;
    }

    public void setModel(Modelo[] model) {
        Model = model;
    }

    public Model(Modelo[] model) {
        Model = model;
    }

    public class Modelo{
        String name, alpha2Code,alpha3Code;

        public Modelo(String name, String alpha2Code, String alpha3Code) {
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

    }



}
