package test;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.ent.Records;
import test.ent.UniqueEnt;
import test.rpos.RecordsRepose;
import test.rpos.RecordsReposeI;
import test.rpos.UniqueRepo;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final UniqueRepo uniqueRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        var ent1 = new UniqueEnt();
        ent1.setName("124");
        ent1.setVal("130");

        var result = uniqueRepo.insert(ent1);
        System.out.println(result);

        Thread.sleep(2000);

        var result2 = uniqueRepo.insert(ent1);
        System.out.println(result2);
    }
}