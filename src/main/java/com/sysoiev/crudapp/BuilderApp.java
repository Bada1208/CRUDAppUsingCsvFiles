package com.sysoiev.crudapp;

public class BuilderApp {
    public static void main(String[] args) {
        Director director = new Director();
        ShipBuilder carrierShipBuilder = new CarrierBuilder();

        director.setShipBuilder(carrierShipBuilder);
        director.constructComputer();

        Ship ship = director.getShip();
        System.out.println(ship.toString());
    }
}

enum typeShips {
    CARRIER, BOAT, VARNEK
}

class Ship {

    private String name = null;
    private int speed = 30;
    private typeShips type = typeShips.BOAT;

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setType(typeShips type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", type=" + type +
                '}';
    }
}

abstract class ShipBuilder {
    protected Ship ship;

    public Ship getShip() {
        return ship;
    }

    public void createNewShip() {
        ship = new Ship();
    }

    public abstract void buildName();

    public abstract void buildSpeed();

    public abstract void buildType();
}

class CarrierBuilder extends ShipBuilder {
    public void buildName() {
        ship.setName("Everest");
    }

    public void buildSpeed() {
        ship.setSpeed(10000);
    }

    public void buildType() {
        ship.setType(typeShips.CARRIER);
    }
}

class Director {
    private ShipBuilder shipBuilder;

    public void setShipBuilder(ShipBuilder shipBuilder) {
        this.shipBuilder = shipBuilder;
    }

    public Ship getShip() {
        return shipBuilder.getShip();
    }

    public void constructComputer() {
        shipBuilder.createNewShip();
        shipBuilder.buildName();
        shipBuilder.buildSpeed();
        shipBuilder.buildType();
    }
}