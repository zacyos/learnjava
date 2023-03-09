package com.animal;

public class Animal {
    private String name;
    private int id;

    public Animal(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void whoami() {
        System.out.println("我是" + name + ",我的id是" + id);
    }
    public void asd() {
        System.out.println("我是Animal");
    }

    public static void main(String[] args) {
        Animal al = new Animal("ads",13);
        al.setName("shou");
        al.whoami();

    }
}
