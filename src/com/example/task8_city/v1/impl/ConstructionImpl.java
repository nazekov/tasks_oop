package com.example.task8_city.v1.impl;

import com.example.task8_city.v1.*;
import com.example.task8_city.v1.exception.SettlerException;
import java.util.Scanner;

public class ConstructionImpl implements Construction {

    private ICity city;

    private boolean isWork;

    private Scanner sc;

    public ConstructionImpl() {
        isWork = true;
        sc = new Scanner(System.in);
    }

    @Override
    public ICity getICity() {
        return city;
    }

    public void setICity(ICity iCity) {
        this.city = iCity;
    }

    @Override
    public void run() {
        System.out.print("Введите название города: ");
        String cityName = sc.nextLine();
        city = new City(cityName);
        System.out.println("Город создан.");

        while (isWork) {
            int cmd = getCmd();
            if (cmd < 1 || cmd > 4) {
                System.out.println("Такой команды нет");
                continue;
            }

            if (cmd == 1) {
                createHouse();
            } else if (cmd == 2) {
                city.showSettledList();
            } else if (cmd == 3) {
                addSettlerToFlat();
            } else {
                finish();
            }
        }
    }

    private void addSettlerToFlat() {
        System.out.println("По какому адресу Вы желаете заселить жителя: ");
        String address = sc.nextLine();
        IHouse iHouse = getiHouse(address);

        if (iHouse == null) {
            System.out.println("Дом с таким адресом не существует.");
            return;
        }

        System.out.print("Введите номер квартиры для заселения: ");
        int numberFlat = Integer.parseInt(sc.nextLine());
        IFlat iFlatFound = getiFlat(iHouse, numberFlat);

        if (iFlatFound == null) {
            System.out.println("Квартиры с таким номером нет.");
        } else if (iFlatFound.getSettlerList().size() < IFlat.DEFAULT_CAPACITY) {
            System.out.println("Введите имя нового жителя:");
            Settler settler = new Settler(sc.nextLine());
            iFlatFound.addSettler(settler);
            System.out.println("Житель заселен");
        } else {
            System.out.println("Квартира уже занята.");
        }
    }

    private IFlat getiFlat(IHouse iHouse, int numberFlat) {
        return iHouse.getFlatList().stream()
            .filter(iFlat -> iFlat.getNumber() == numberFlat)
            .findFirst()
            .orElse(null);
    }

    private IHouse getiHouse(String address) {
        return city.getHouseList().stream()
            .filter(house -> house.getAddress().equals(address))
            .findFirst()
            .orElse(null);
    }

    private void finish() {
        System.out.println("\nКонец работы програмы");
        isWork = false;
    }

    private void createHouse() {
        System.out.println("По какому адресу будет располагаться дом: ");
        House house = new House(sc.nextLine());

        System.out.println("Введите количество квартир, которые будут в этом доме: ");
        int countFlats = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < countFlats; i++) {
            int numberFlat = i + 1;
            System.out.println("Строится квартира номер: " + numberFlat);
            Flat flat = new Flat(numberFlat);

            boolean isNotCorrectCountSettlers = true;
            while (isNotCorrectCountSettlers) {
                try {
                    int countSettlers = getCountSettlers();

                    for (int j = 0; j < countSettlers; j++) {
                        System.out.print("Введите имя жителя: ");
                        String nameSettler = sc.nextLine();
                        Settler settler = new Settler(nameSettler);
                        flat.addSettler(settler);
                    }

                    isNotCorrectCountSettlers = false;
                } catch (SettlerException e) {
                    e.printStackTrace();
                }
            }

            house.addFlat(flat);
        }

        city.addHouse(house);
        System.out.println("Дом построен");
    }

    private int getCountSettlers() throws SettlerException {
        System.out.println("Введите количество жителей квартиры: ");
        int countSettlers = Integer.parseInt(sc.nextLine());
        if (countSettlers > IFlat.DEFAULT_CAPACITY) {
            throw new SettlerException(
                "Количество жителей в одной квартире должно быть не больше " + IFlat.DEFAULT_CAPACITY
            );
        }
        return countSettlers;
    }

    private int getCmd() {
        System.out.println("\nMenu:\n" +
                "1 - создать дом и поселить жителей \n" +
                "2 - посмотреть полную информацию по городу \n" +
                "3 - добавить жителя \n" +
                "4 - выйти\n" +
                "Введите команду: ");
        return Integer.parseInt(sc.nextLine());
    }
}
