import java.util.ArrayList;
import java.util.Scanner;

public class Duke {


    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        //level1();
        //level2ArrayList();
        //level2ArrayofString();
        level3A_Classes();
    }

    static void level1(){
        System.out.println("What can I do for you?");

        Scanner input =new Scanner(System.in);

        String userInput = input.nextLine();

        while(!userInput.equals("bye")){
            System.out.println("   " + userInput);
            userInput = input.nextLine();
        }

        System.out.println("Bye, Hope to see you again soon!");
    }

    static void level2ArrayList(){
        System.out.println("What can I do for you?");

        Scanner input = new Scanner(System.in);

        String userInput;
        ArrayList list = new ArrayList();

        while(true){
            userInput = input.nextLine();
            if(userInput.equals("list")){
                for(int i = 0; i < list.size(); i++){
                    System.out.println((i+1) + "." + list.get(i));
                }
            }
            else if(userInput.equals("bye")){
                break;
            }
            else {
                list.add(userInput);
                System.out.println("added: " + userInput);
            }
        }

        System.out.println("Bye, Hope to see you again soon!");
    }

    static void level2ArrayofString(){
        System.out.println("What can I do for you?");

        Scanner input = new Scanner(System.in);

        String userInput;
        String[] list = new String[100];
        int k = 0;
        while(true){
            //if(k > 100) k = 100; //extra line for >100 input
            userInput = input.nextLine();
            if(userInput.equals("list")){
                for(int i = 0; i < k; i++){
                    System.out.println((i+1) + "." + list[i]);
                }
            }
            else if(userInput.equals("bye")){
                break;
            }
            else {
                list[k++] = userInput;
                System.out.println("added: " + userInput);
            }
        }

        System.out.println("Bye, Hope to see you again soon!");
    }

    static void level3(){
        System.out.println("What can I do for you?");

        String[] list = new String[100];
        //String[] list = {"read book", "return book", "buy bread"};
        Scanner input = new Scanner(System.in);
        String userInput; int k = 0;

        while(true){
            userInput = input.nextLine();

            if(userInput.equals("list")){
                //list items
                for(int i = 0; i < k; i++){
                    System.out.println((i+1) + ". " + list[i]);
                }
            }
            else if(userInput.equals("bye")){
                break;
            }
            else{
                String[] option;
                option = userInput.split(" ", 2);
                if(option[0].equals("done")){
                    int index = Integer.parseInt(option[1]);

                    String[] temp;
                    temp = list[index-1].split(" ", 2);

                    temp[0] ="[✓]"; //convert option[1] to int
                    list[index-1] = temp[0] + temp[1];
                    System.out.println(list[index-1]);
                    //list[index-1] = temp;
                }
                else {
                    list[k++] =  "[✗] " + userInput;
                    System.out.println("[✗] " + userInput);
                }
            }

        }

        System.out.println("Bye, Hope to see you again soon!");

    }

    static void level3A_Classes(){

        System.out.println("What can I do for you?");

        Task[] list = new Task[100];

        Scanner input = new Scanner(System.in);
        String userInput;
        int k = 0;

        while(true){
            userInput = input.nextLine();

            if(userInput.equals("list")){
                for(int i = 0; i < k; i++){
                    System.out.println((i+1) + ". " + list[i].getStatusIcon() + " " + list[i].description);
                }
            }
            else if(userInput.equals("bye")){
                break;
            }
            else{
                String[] temp = userInput.split(" ", 2);
                if(temp[0].equals("done")){
                    int index = Integer.parseInt(temp[1]) -1;
                    list[index].isDone = true;
//                    System.out.println("Nice! I've marked this task as done:");
//                    System.out.println("  " + list[index].getStatusIcon() + " " + list[index].description);
                }
                else{
                    list[k++].description = userInput;
//                    System.out.println(list[k].getStatusIcon() + " " + list[k].description);
                }
            }
        }

        System.out.println("Bye, Hope to see you again soon!");

    }


}
