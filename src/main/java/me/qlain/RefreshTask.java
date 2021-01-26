package me.qlain;

import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RefreshTask extends Task<String> {
    @Override
    protected String call(){
        while (true) {
            try {
                Thread.sleep(Settings.interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.updateValue(execCommand());
        }
    }

    private String execCommand() {
        StringBuilder out = new StringBuilder();
        Process p;

        try {
            p = Runtime.getRuntime().exec(Settings.command);
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            br.lines().forEach(out::append);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return out.toString();
    }
}
