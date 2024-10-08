package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

class Employee{
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
public class StreamMap {

    public static void main(String[] args) {

        // change to upper case
        List<String> listStr = Arrays.asList("anna", "rajivgandhi", "siva", "kathir", "ravi", "dinesh");
        List<String> result =listStr.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        //System.out.println(result);

        // find the length of every element
        List<String> listStr2 = Arrays.asList("anna", "rajivgandhi", "siva", "kathir", "ravi", "dinesh");

        //1.5
        for (String name: listStr2){
           // System.out.println(name.length());
        }
        //1.8
       // listStr2.stream().map(s-> s.length()).collect(Collectors.toList()).forEach(System.out::println);

        // Map- is one to one
        // apply filter and map
        List<Employee> employeeList =  new ArrayList<>();
        employeeList.add( new Employee(1,"anna1",10));
        employeeList.add( new Employee(2,"anna2",11));
        employeeList.add( new Employee(3,"anna3",12));

        List<Integer> salaryList = employeeList.stream()
                .filter(e -> e.salary>10)
                .map(e -> e.salary)
                .collect(Collectors.toList());
        System.out.println(salaryList);

        // flatmap - one to meney
        // take one collection and add in to the stream of object and process
        List<String> list1 = Arrays.asList("anna1", "rajivgandhi");
        List<String> list2 = Arrays.asList("anna2", "rajivgandhi2");
        List<String> list3 = Arrays.asList("anna3", "rajivgandhi3");

        List<List<String>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        // Before java 8
        for (List<String> str : lists){
            for(String name: str){
                System.out.println(name);
            }
        }
        List<String> lis = lists.stream().flatMap(list-> list.stream()).collect(Collectors.toList());
        System.out.println(lis);


        // with Employee object
        List<Employee> employeeList2 =  new ArrayList<>();
        employeeList2.add( new Employee(1,"anna12",10));
        employeeList2.add( new Employee(2,"anna22",11));
        employeeList2.add( new Employee(3,"anna32",12));

        List<List<Employee>> listList = new ArrayList<>();
        listList.add(employeeList);
        listList.add(employeeList2);

        List<String> listList1 = listList.stream().flatMap(s->s.stream().map(s1->s1.name)).collect(Collectors.toList());

        System.out.println(listList1);
    }
}
