package student;

import java.util.ArrayList;


class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        if (grades.isEmpty()) {
            return 0;
        }

        double sum = 0;

        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    public double getHighest() {
        if (grades.isEmpty()) {
            return 0;
        }

        double highest = grades.get(0);

        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        return highest;
    }

    public double getLowest() {
        if (grades.isEmpty()) {
            return 0;
        }

        double lowest = grades.get(0);

        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }

        return lowest;
    }

    public void displayReport() {
        System.out.println("\nStudent Name : " + name);
        System.out.println("Grades       : " + grades);
        System.out.printf("Average      : %.2f%n", getAverage());
        System.out.println("Highest      : " + getHighest());
        System.out.println("Lowest       : " + getLowest());
    }
}

