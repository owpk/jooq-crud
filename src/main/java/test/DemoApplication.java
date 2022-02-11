package test;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.rpos.UserRepo;
import test.rpos.UserRoleRepo;
import test.tables.RoleUser;
import test.tables.Users;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final UserRoleRepo roleUserRepo;
    private final UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        var rec = roleUserRepo.createRecord();
        rec.setRoleid(1L);
        rec.setUserid(1L);
        roleUserRepo.saveOrUpdate(rec, RoleUser.ROLE_USER.USERID.getName());

        var user = userRepo.createRecord();
        user.setId(1L);
        user.setPhone("7800509");
        user.setEmail("ABOBA@AA");
        var opt = userRepo.saveOrUpdate(user, Users.USERS.ID.getName());
        var u = opt.orElseThrow(RuntimeException::new);
        System.out.println(u.getId());
    }
}