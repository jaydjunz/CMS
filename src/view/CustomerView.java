package view;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public void enterMainMenu(){

        boolean flag = true;
        while(flag){
            System.out.println("\n-----------------Customer Management System-----------------\n");
            System.out.println("                   1 Add Customers");
            System.out.println("                   2 Modify Customers");
            System.out.println("                   3 Delete Customers");
            System.out.println("                   4 Show Customer List");
            System.out.println("                   5 Exit\n");
            System.out.print("               Please Choose(1-5)：");

            char menu = CMUtility.readMenuSelection();
            switch(menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("Exit?(Y/N): ");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        flag = false;
                    }
            }
        }



    }

    private void listAllCustomer() {
        System.out.println("---------------------------Customer List---------------------------");
        if(customerList.getTotal() == 0){
            System.out.println("No Customer!");
        }else{
            System.out.println("No.\tName\tGender\tAge\t\tPhone\t\tEmail");
            Customer[] customers = customerList.getAllCustomers();
            for(int i = 0; i< customers.length;i++){
                Customer customer = customers[i];
                System.out.println((i+1) + "\t" + customer.getName() + "\t" + customer.getGender() + "\t\t" +
                        customer.getAge() + "\t\t" + customer.getPhone() + "\t\t" + customer.getEmail());
            }
        }
        System.out.println("-------------------------Done!-------------------------");
    }

    private void deleteCustomer() {
        System.out.println("---------------------Delete Customer---------------------");
        int num;
        while (true){
            System.out.print("Please select the customer(Exit Code: -1)：");
            num =  CMUtility.readInt();

            if(num == -1){
                return;
            }

            Customer customer = customerList.getCustomer(num -1);
            if(customer == null){
                System.out.println("Can't find the specific customer!");
            }else{
                break;
            }
        }

        System.out.println("Are you sure?(Y/N):");
        char confirm = CMUtility.readConfirmSelection();
        if(confirm == 'Y'){
            boolean isDeleted = customerList.deleteCustomer(num - 1);
            if(isDeleted){
                System.out.println("---------------------Customer is successfully deleted!---------------------");
            }
        }else{
            return;
        }

    }

    public void addNewCustomer(){
        System.out.println("---------------------Add New Customer---------------------");
        System.out.print("Name：");
        String name = CMUtility.readString(10);
        System.out.print("Gender：");
        char gender = CMUtility.readChar();
        System.out.print("Age：");
        int age = CMUtility.readInt();
        System.out.print("Phone：");
        String phone = CMUtility.readString(13);
        System.out.print("Email：");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isAdded = customerList.addCustomer(customer);
        if(isAdded){
            System.out.println("---------------------Customer is successfully added---------------------");
        }else{
            System.out.println("Customer is not Added. Please try again!");
        }


    }

    public void modifyCustomer(){
        System.out.println("---------------------Modify Customer---------------------");
        Customer customer;
        int number;
        while (true){
            System.out.print("请选择修改客户编号(-1退出)：");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }
            customer = customerList.getCustomer(number - 1);
            if(customer == null){
                System.out.println("Can't find the specific customer!");
            }else{
                break;
            }
        }

        System.out.println("Name(" + customer.getName() + "):");
        String name = CMUtility.readString(10,customer.getName());
        System.out.println("Gender(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.println("Age(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.println("Phone(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(13,customer.getPhone());
        System.out.println("Email(" + customer.getEmail() + "):");
        String email = CMUtility.readString(30,customer.getEmail());

        Customer modifiedCustomer = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(number - 1,modifiedCustomer);
        if(isReplaced){
            System.out.println("---------------------Completed---------------------");
        }
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}
