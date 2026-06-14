package ejercicio3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
public class Logging {
    public static final String LOG_PATH = "src/main/resources/log.txt";

//    @Before("execution(todosLosConcursos(..)) || execution(saveInscription(..))")
    @Before("execution(@Log * *(..))")
    public void loguearAntes(JoinPoint joinPoint) throws IOException {
        String methodName = joinPoint.getSignature().getName();
        Object[] args     = joinPoint.getArgs();

        String params;
        if (args == null || args.length == 0) {
            params = "\"sin parametros\"";
        } else {
            params = "\"" + Arrays.stream(args)
                    .map(Object::toString)
                    .collect(Collectors.joining("|")) + "\"";
        }
        String fecha = "\"" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "\"";

        String linea = methodName + ", " + params + ", " + fecha;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_PATH, true))) {
            bw.write(linea);
            bw.newLine();
        }
    }
    //    @After("execution(todosLosConcursos(..)) || execution(saveInscription(..))")
//    @After("execution(@Log * *(..))")
    public void loguearDespues(JoinPoint joinPoint){

    }
    //    @Around("execution(todosLosConcursos(..)) || execution(saveInscription(..))")
//    @Around("execution(@Log * *(..))")
    public void loguearEntre(ProceedingJoinPoint joinPoint){

    }
}
