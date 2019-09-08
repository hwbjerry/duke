import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    static ArrayList<Task> arrList = new ArrayList<Task>();

    public Duke() {
        ui = new Ui();
        tasks = new TaskList(arrList);
       // try {
            ui.showWelcomeDukeLogo();
            ui.sayHello();
            //tasks = new TaskList();
           // String userInput = ui.scanLine();
            Parser parser = new Parser(ui, tasks);
            parser.decode("userInput");


//        } catch (DukeException e) {
//            ui.showLoadingError(e);
//            //tasks = new TaskList();
//        }
    }

    public static void main(String[] args) throws IOException{
        new Duke();
    }
}