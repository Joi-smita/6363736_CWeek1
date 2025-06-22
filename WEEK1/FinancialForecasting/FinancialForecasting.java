package FinancialForecasting;

public class FinancialForecasting {
    static double forecastRecursive(double initialValue, double growthRate, int years) {
        if (years == 0) return initialValue;
        return forecastRecursive(initialValue, growthRate, years - 1) * (1 + growthRate);
    }
    static double forecastMemo(double initialValue, double growthRate, int years, Double[] memo) {
        if (years == 0) return initialValue;
        if (memo[years] != null) return memo[years];
        memo[years] = forecastMemo(initialValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.10;  // 10%
        int years = 5;

        System.out.println("Recursive Forecast (no optimization):");
        double result1 = forecastRecursive(initialValue, growthRate, years);
        System.out.printf("Future Value after %d years: Rs.%.2f\n", years, result1);

        System.out.println("\nOptimized Forecast with Memoization:");
        Double[] memo = new Double[years + 1];
        double result2 = forecastMemo(initialValue, growthRate, years, memo);
        System.out.printf("Future Value after %d years: Rs.%.2f\n", years, result2);
    }
}
