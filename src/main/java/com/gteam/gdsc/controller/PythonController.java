package com.gteam.gdsc.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

@RestController
public class PythonController {

    @GetMapping("/runPythonScript")
    public String runPythonScript() throws IOException, InterruptedException {
        //try {
        final Logger log = (Logger) LoggerFactory.getLogger(getClass());

        // ProcessBuilder를 사용하여 명령어 실행
        ProcessBuilder processBuilder = new ProcessBuilder("python", "google_ocr_run.py", "--txt", "--words");
        //ProcessBuilder processBuilder = new ProcessBuilder("C:/Users/User/Desktop/GDSC/SolutionChallenge/ocr/google_ocr_run.py", "--txt", "--words");
        Process process = processBuilder.start();

        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            // 실행 결과 처리
            System.out.println(line);
        }

           /* // 1. 오류 메시지 출력
            InputStream errorStream = process.getErrorStream();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));

            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                // 오류 처리
            }

// 2. 프로세스 종료 대기
            int exitCode = process.waitFor();
            System.out.println("종료 코드: " + exitCode);

// 3. 프로세스 강제 종료
            process.destroy();

// 4. 종료 코드 확인
            exitCode = process.exitValue();
            System.out.println("외부 프로그램 종료 코드: " + exitCode);*/

           /* // 프로세스의 출력을 읽기 위한 BufferedReader 생성
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();

            // 프로세스 출력을 읽어들여 StringBuilder에 추가
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // 프로세스가 완료될 때까지 대기
            int exitVal = process.waitFor();

            // 프로세스의 종료코드를 확인하여 처리
            if (exitVal == 0) {
                // 성공적으로 종료됨
                return output.toString();
            } else {
                // 오류 발생 시
                return "Python 스크립트 실행 중 오류가 발생했습니다.";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Python 스크립트 실행 중 오류가 발생했습니다.";
        }*/
        return line;
    }
}
