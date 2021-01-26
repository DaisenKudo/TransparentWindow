package me.qlain.infrastructure.repositoryimpl;

import javafx.concurrent.Task;
import me.qlain.interfaces.repository.RuntimeRepository;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeRepositoryImpl extends Task<String> implements RuntimeRepository {
    @Override
    protected String call(){
        while (true) {
            try {
                Thread.sleep(Settings.INSTANCE.getInterval());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.updateValue(execCommand());
        }
    }

    @Nullable
    @Override
    public String execCommand() {
        StringBuilder out = new StringBuilder();
        Process p;

        try {
            p = Runtime.getRuntime().exec(Settings.INSTANCE.getCommand());
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
