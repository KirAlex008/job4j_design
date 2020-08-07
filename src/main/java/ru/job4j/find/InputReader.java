package ru.job4j.find;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class InputReader {
    private final String[] args;
    private String str;
    public InputReader(String[] args) {
        this.args = args;
    }

    //String str = new String("-d c:/ -n *.txt -m -o log.txt");
    public Map<String, String> inputKeys = new HashMap<String,String>();

    public boolean validateArgs() {
        boolean inputIsValid = true;
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments array are empty.");
        }
        if (args.length != 7) {
            throw new IllegalArgumentException("The amount of arguments is wrong.");
        }
        if (!Files.isDirectory(Paths.get(inputKeys.get("d")))) {
            throw new IllegalArgumentException("Directory is not exist");
        }
        return inputIsValid;
    }
    public void concatenateArgs() {
        str = String.join(" ", args);
        System.out.println(str);
        }

    public void read() {
        var strArr = str.split(" -");
        for (var el : strArr) {
            if (el.substring(0,1).equals("-")) {
                el = el.substring(1);
            }
            var elemMap = el.split(" ",2);
            String[] elemMapToAdd = new String[2];
            for (int i = 0; i < elemMap.length; i++) {
                elemMapToAdd[i] = elemMap[i];
            }
            inputKeys.put(elemMapToAdd[0], elemMapToAdd[1]);
        }
        if (inputKeys.containsKey("m") && inputKeys.get("n").contains("*")) {
            var newVal = inputKeys.get("n");
            newVal = newVal.substring(1);
            inputKeys.put("n", newVal);
        }
    }

    public static void main(String[] args) {
        InputReader inp = new InputReader(args);
        inp.concatenateArgs();
        System.out.println(inp.str);
        inp.read();
        for (var el : inp.inputKeys.keySet()) {
            System.out.println(inp.inputKeys.get(el));
            System.out.println(el);
        }
        System.out.println(inp.inputKeys);
    }
/*    public static void main(String[] args) {
        for (var el : args) {
            System.out.println(el);
        }
    }*/
}
