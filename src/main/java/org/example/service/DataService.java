package org.example.service;

import org.example.utils.DataInputHelper;
import org.example.model.Data;
import org.example.utils.Menu;

import java.util.*;

public class DataService {
    Map<Long, Data> accountMap = new TreeMap<>();
    Map<String, List<Data>> nameMap = new TreeMap<>();
    Map<Double, List<Data>> valueMap = new TreeMap<>();
    final DataInputHelper putDataInputHandler = new DataInputHelper();

    public void addData() {
        Data data = putDataInputHandler.inputData();
        accountMap.put(data.getAccount(), data);
        List<Data> dataList = nameMap.computeIfAbsent(data.getName(), k -> new ArrayList<>());
        dataList.add(data);
        dataList = valueMap.computeIfAbsent(data.getValue(), k -> new ArrayList<>());
        dataList.add(data);
        System.out.println("Data with accountID: " + data.getAccount() + " was added!");
    }

    public void getDataByAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter accountID to find whole data for update");
        long account = scanner.nextLong();
        List<Data> dataList = new ArrayList<>();
        Data data = accountMap.get(account);
        if(data != null) {
            dataList.add(data);
        }
        System.out.println(dataList);
    }

    public void getDataByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name to find whole data's");
        String name = scanner.next();
        List<Data> dataList = nameMap.get(name);
        if(dataList == null) {
            dataList = new ArrayList<>();
        }
        System.out.println(dataList);
    }

    public void getDataByValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value to find whole data's");
        double value = scanner.nextDouble();
        List<Data> dataList = valueMap.get(value);
        if(dataList == null) {
            dataList = new ArrayList<>();
        }
        System.out.println(dataList);
    }

    public void updateData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter accountID to update whole data");
        long account = scanner.nextLong();
        Data data = accountMap.get(account);
        Data newData = putDataInputHandler.updateData();

        if (newData.getAccount() != data.getAccount()) {
            accountMap.remove(data.getAccount());
        } else {
            System.out.println("New accountID = old accountID. You just updated existing values");
        }

        accountMap.put(newData.getAccount(), newData);

        List<Data> dataList = nameMap.get(data.getName());
        if (dataList != null) {
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).getAccount() == data.getAccount()) {
                    dataList.remove(i);
                    dataList.add(i, newData);
                    break;
                }
            }
        }

        dataList = valueMap.get(data.getValue());
        if (dataList != null) {
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).getAccount() == data.getAccount()) {
                    dataList.remove(i);
                    dataList.add(i, newData);
                    break;
                }
            }
        }
        System.out.println("Data was updated");
    }
    public void deleteDataByAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter accountID to delete whole data");
        long account = scanner.nextLong();
        List<Data> dataList = new ArrayList<>();
        Data data = accountMap.get(account);
        if(data == null) {
            System.out.println("Data with such an account was not found");
            return;
        } else {
            dataList.add(data);
        }
        Iterator<Data> iterator = dataList.iterator();
        while (iterator.hasNext()) {
            data = iterator.next();
            accountMap.remove(account);
            nameMap.get(data.getName()).remove(data);
            valueMap.get(data.getValue()).remove(data);
            iterator.remove();
        }
        System.out.println("Data with account id " + account + " was deleted");
    }
}
