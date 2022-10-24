package service;
import bean.Customer;

/**
 * Customer Management Module
 *
 */

public class CustomerList {
    Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer){

        if(total >= customers.length){
            return false;
        }

        customers[total++] = customer;

        return true;
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
        for(int i = index ; i < total - 1; i++){
            customers[i] = customers[i+1];
        }
        customers[--total] = null;
        return true;
    }

    public Customer[] getAllCustomers(){
            Customer[] customers1 = new Customer[total];
            for(int i = 0;i< total ; i++){
                customers1[i] = customers[i];
            }

            return customers1;
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
