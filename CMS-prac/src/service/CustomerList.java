package service;

import bean.Customer;

public class CustomerList {
    Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer){
        if(total < customers.length){
            customers[total++] = customer;
            return true;
        }else{
            return false;
        }
    }

    public boolean replaceCustomer(int index, Customer customer){
        if(index < 0 || index >= total){
            return false;
        }

        customers[index] = customer;
        return true;
    }

    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }

        for (int i = index; i<total;i++){
            customers[i] = customers[i+1];

        }
        customers[total - 1] = null;
        total = total - 1;
        return true;
    }

    public Customer[] getAllCustomer(){
        Customer[] tempCustomers = new Customer[total];
        for(int i =0; i<total ; i++){
            tempCustomers[i] = customers[i];
        }
        return customers;
    }

    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    public int getTotal(){
        return total;
    }
}


