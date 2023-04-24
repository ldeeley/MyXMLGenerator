package com.example.myxmlgenerator;

import com.example.myxmlgenerator.cli.MessageGeneratorCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Slf4j
@EnableJpaRepositories(basePackages = {"com.example.myxmlgenerator.data.lei.repository", "com.example.myxmlgenerator.data.bic.repository"})
@EntityScan(basePackages = {"com.example.myxmlgenerator.data.lei.model", "com.example.myxmlgenerator.data.bic.model"})
@SpringBootApplication
public class lgdRapideCLIApplication implements CommandLineRunner,ExitCodeGenerator {

    private MessageGeneratorCommand command;

    private int exitCode;

    @Autowired
    private final IFactory cliFactory;

//    CommandLineRunner is a simple Spring Boot interface with a run method. Spring Boot will automatically call
//    the run method of all beans implementing this interface after the application context has been loaded.
//    https://www.baeldung.com/java-picocli-create-command-line-program

    public lgdRapideCLIApplication(IFactory cliFactory, MessageGeneratorCommand command) {
        this.cliFactory = cliFactory;
        this.command = command;
    }

    public static void main(String[] args) {
//        String[] args = new String[]{"-d=grrlgdMX","-n=1","-o=grrlgdMX"};
        System.exit(SpringApplication.exit(SpringApplication.run(lgdRapideCLIApplication.class, args)));
    }


//    Executing the CommandLine Runner to ingest the arguments on the CommandLine. Spring Boot automatically calls this on start up
    @Override
    public void run(String... args) throws Exception {
        log.info("EXECUTING : command line runner");
        System.out.println("EXECUTING : command line runner");
        for (int i = 0; i < args.length; ++i) {
            log.info("args[{}]: {}", i, args[i]);
        }
//        CommandLine will run, executing
        exitCode = new CommandLine(command, cliFactory).execute(args);
    }

    //  The Application should return an Exit code on exit. By implementing this interface we get to choose which code to return.
    @Override
    public int getExitCode() {
        return exitCode;
    }
}
