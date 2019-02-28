package com.cvt;

import org.python.util.PythonInterpreter;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.util.Properties;

public class ScriptManagerMain {
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager=new ScriptEngineManager();

        Properties props=new Properties();
        props.put("python.home","/Users/cvt11/.m2/repository/org/python/jython/2.7.0/Lib");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site","false");
        Properties preprops = System.getProperties();

        //initializing pythonScriptEngine
        PythonInterpreter.initialize(preprops, props, new String[0]);

        //create a PythonScript engine
        ScriptEngine scriptEngine=scriptEngineManager.getEngineByName("python");
        try {
            scriptEngine.eval(new BufferedReader(new FileReader("test.py")));
            Invocable invocable= (Invocable) scriptEngine;
            System.out.println( "ADD -> "+(int) invocable.invokeFunction("add",3,5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
