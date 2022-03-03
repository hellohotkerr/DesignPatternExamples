package google.design.pattern.behavior;

import java.util.ArrayList;

public class VisitorPattern2 {
    //被访问者
    public interface Employee{
        public void accept(Department handler);//接受一个抽象访问者访问
    }
    public class FullTimeEmployee implements Employee{
        private String name;
        private double weeklyWage;//周薪
        private int workTime;

        public FullTimeEmployee(String name, double weeklyWage, int workTime) {
            this.name = name;
            this.weeklyWage = weeklyWage;
            this.workTime = workTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getWeeklyWage() {
            return weeklyWage;
        }

        public void setWeeklyWage(double weeklyWage) {
            this.weeklyWage = weeklyWage;
        }

        public int getWorkTime() {
            return workTime;
        }

        public void setWorkTime(int workTime) {
            this.workTime = workTime;
        }

        @Override
        public void accept(Department handler) {
            handler.visit(this);
        }
    }
    public class PartTimeEmployee implements Employee{
        private String name;
        private double hourWage;//时薪
        private int workTime;

        public PartTimeEmployee(String name, double hourWage, int workTime) {
            this.name = name;
            this.hourWage = hourWage;
            this.workTime = workTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getHourWage() {
            return hourWage;
        }

        public void setHourWage(double hourWage) {
            this.hourWage = hourWage;
        }

        public int getWorkTime() {
            return workTime;
        }

        public void setWorkTime(int workTime) {
            this.workTime = workTime;
        }

        @Override
        public void accept(Department handler) {
            handler.visit(this);
        }
    }

    //访问者基类
    public abstract class Department{
        public abstract void visit(FullTimeEmployee employee);
        public abstract void visit(PartTimeEmployee employee);
    }

    public class FADepartment extends Department{

        //实现财务部对全职员工的访问
        @Override
        public void visit(FullTimeEmployee employee) {
            int workTime = employee.getWorkTime();
            double weeklyWage = employee.getWeeklyWage();
            if (workTime >= 40) {
                weeklyWage = weeklyWage + (workTime - 40) * 100;
            } else if (workTime < 40) {
                weeklyWage = weeklyWage - (40 - workTime) * 80;
                if (weeklyWage < 0) {
                    weeklyWage = 0;
                }
            }

        }

        //实现财务部对临时员工的访问
        @Override
        public void visit(PartTimeEmployee employee) {
            int workTime = employee.getWorkTime();
            double hourWage = employee.getHourWage();
            System.out.println("employee name= " + employee.getName()+"workTime= "
                    + workTime
                    +"hourWage " + hourWage);
        }
    }

    public class HRDepartment extends Department{

        //实现人力部对全职员工的访问
        @Override
        public void visit(FullTimeEmployee employee) {
            int workTime = employee.getWorkTime();
        }

        //实现人力部对临时员工的访问
        @Override
        public void visit(PartTimeEmployee employee) {
            int workTime = employee.getWorkTime();
        }
    }

    public class EmployeeList{
        private ArrayList<Employee> list = new ArrayList<>();

        public void addEmployee(Employee employee) {
            list.add(employee);
        }

        public void accept(Department handler) {
            for (Employee employee : list) {
                employee.accept(handler);
            }
        }
    }
}
