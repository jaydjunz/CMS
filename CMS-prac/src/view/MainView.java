package view;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

public class MainView {
    private CustomerList customerList = new CustomerList(10);

    public static void main(String[] args) {
        MainView view = new MainView();
        view.enterMainMenu();
    }

    public void enterMainMenu(){

        boolean mainFlag = true;
        while(mainFlag){
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char menuCode = CMUtility.readMenuSelection();
            switch (menuCode){
                case '1':
                    this.addNewCustomer();
                    break;
                case '2':
                    this.modifyCustomer();
                    break;
                case '3':
                    this.deleteCustomer();
                    break;
                case '4':
                    this.listAllCustomer();
                    break;
                case '5':
                    System.out.println("Are you sure to exit(Y/N): ");
                    char comfirm = CMUtility.readConfirmSelection();
                    if(comfirm == 'Y'){
                        mainFlag = false;
                    }


            }

        }
    }

    public void addNewCustomer(){
        System.out.println("-------------------------Add New Customer--------------------------");
        System.out.println("Name: ");
        String name = CMUtility.readString(10);
        System.out.println("Gender: ");
        char gender = CMUtility.readChar();
        System.out.println("Age: ");
        int age = CMUtility.readInt();
        System.out.println("Phone: ");
        String phone = CMUtility.readString(13);
        System.out.println("Email: ");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isAdded = customerList.addCustomer(customer);
        if(isAdded){
            System.out.println("---------------------Customer is successfully added---------------------");
        }else{
            System.out.println("Customer is not Added. Please try again!");
        }
    }

    public void modifyCustomer(){
        Customer customer;
        int modiNum;
        System.out.println("-------------------------Modify Customer--------------------------");
        while(true){
            modiNum = CMUtility.readInt();
            if(modiNum == -1){
                return;
            }
            customer = customerList.getCustomer(modiNum - 1);
            if(customer == null){
                System.out.println("cannot find the specific customer.");
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

        Customer modifiedCust = new Customer(name,gender,age,phone,email);


        boolean isReplaced =  customerList.replaceCustomer(modiNum - 1,modifiedCust);
        if(isReplaced){
            System.out.println("Customer is replaced successfully.");
        }


    }

    public  void deleteCustomer(){
        Customer customer;
        int readNo;
        System.out.println("-------------------------Delete Customer--------------------------");
        while (true){
            System.out.print("请选择待删除客户编号(-1退出)：");
            readNo = CMUtility.readInt();
            if(readNo == -1){
                return;
            }
            customer = customerList.getCustomer(readNo - 1 );
            if(customer == null){
                System.out.println("无法找到指定客户！");
            }else{
                break;
            }
        }

        System.out.print("确认是否删除(Y/N)：");
        char delete = CMUtility.readConfirmSelection();
        if(delete == 'Y'){
            customerList.deleteCustomer(readNo - 1);
        }else{
            return;
        }

    }

    public  void listAllCustomer(){
        System.out.println("-------------------------Customer List--------------------------");

        if(customerList.getTotal() == 0){
            System.out.println("No Customer!");
        }else{
            System.out.println("Name\t\tGender\t\tAge\t\tPhone\t\tEmail");
            Customer[] customers = customerList.getAllCustomer();
            for(int i =0;i<customers.length;i++){
                Customer customer = customers[i];
                System.out.println(customer.getName() + "\t\t" + customer.getGender() + "\t\t" + customer.getAge() + "\t\t" + customer.getPhone() + "\t\t" + customer.getEmail());
            }

        }

        System.out.println("-------------------------Done!-------------------------");


    }
}
