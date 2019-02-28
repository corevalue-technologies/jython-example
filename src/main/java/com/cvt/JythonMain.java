package com.cvt;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.io.*;
import java.util.Properties;

public class JythonMain {
    public static void main(String[] args) {

        Properties props=new Properties();
        props.put("python.home","/Users/cvt11/.m2/repository/org/python/jython/2.7.0/Lib");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site","false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter interp = new PythonInterpreter();



        try {

            File file=new File("demo.py");
            System.out.println(file.getName());


            //running .py file script
            interp.execfile("demo.py");


        } catch (Exception e) {
            e.printStackTrace();
        }

        //using scriptEngineManager call python code into java

       /* ScriptEngineManager scriptEngineManager=new ScriptEngineManager();

        //create a PythonScript engine
        ScriptEngine scriptEngine=scriptEngineManager.getEngineByName("python");
        try {
            URI uri=new File("test.py").toURI();
            scriptEngine.eval(Files.newBufferedReader(Paths.get(uri), StandardCharsets.UTF_8));
            Invocable invocable= (Invocable) scriptEngine;
            System.out.println( "ADD -> "+(int) invocable.invokeFunction("add",3,5));
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }
}
