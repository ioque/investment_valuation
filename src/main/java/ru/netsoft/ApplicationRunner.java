package ru.netsoft;

import ru.netsoft.datagateway.MemoryDataGateway;

public class ApplicationRunner {
    public static void main(String[] args) {
        Application application = new Application(new MemoryDataGateway());
        Long firstPortfolioResult = application.run(1L);
        Long secondPortfolioResult = application.run(2L);
        System.out.println("firstPortfolioResult: " + firstPortfolioResult);
        System.out.println("secondPortfolioResult: " + secondPortfolioResult);
    }
}
