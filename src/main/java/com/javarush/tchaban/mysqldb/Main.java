package com.javarush.tchaban.mysqldb;

import com.javarush.tchaban.mysqldb.domain.entity.City;
import com.javarush.tchaban.mysqldb.redis.CityCountry;
import com.javarush.tchaban.mysqldb.services.DBService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        List<City> cities = dbService.fetchData();
        List<CityCountry> preparedData = dbService.transformData(cities);
        dbService.pushToRedis(preparedData);

        dbService.getSessionFactory().getCurrentSession().close();

        List<Integer> ids = List.of(3, 2545, 123, 4, 189, 89, 3458, 1189, 10, 102);

        long startRedis = System.currentTimeMillis();
        dbService.testRedisData(ids);
        long stopRedis = System.currentTimeMillis();

        long startMysql = System.currentTimeMillis();
        dbService.testMysqlData(ids);
        long stopMysql = System.currentTimeMillis();

        System.out.printf("%s:\t%d ms\n", "Redis", (stopRedis - startRedis));
        System.out.printf("%s:\t%d ms\n", "MySQL", (stopMysql - startMysql));

        dbService.shutdown();
    }
}
